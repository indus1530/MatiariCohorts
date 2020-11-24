package edu.aku.hassannaqvi.blf_screening.ui.sections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.blf_screening.R;
import edu.aku.hassannaqvi.blf_screening.contracts.FormsSLContract;
import edu.aku.hassannaqvi.blf_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.blf_screening.core.MainApp;
import edu.aku.hassannaqvi.blf_screening.databinding.ActivitySectionSlBinding;
import edu.aku.hassannaqvi.blf_screening.models.FormsSL;
import edu.aku.hassannaqvi.blf_screening.ui.other.MainActivity;
import edu.aku.hassannaqvi.blf_screening.utils.DateUtils;
import edu.aku.hassannaqvi.blf_screening.workers.DataUpWorkerSL;

import static edu.aku.hassannaqvi.blf_screening.utils.AppUtilsKt.contextBackActivity;

public class SectionSLActivity extends AppCompatActivity {

    ActivitySectionSlBinding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_sl);
        bi.setCallback(this);
        setupSkip();

    }


    private void setupSkip() {
        //sl701 setMaxDate
        bi.sl701.setMaxDate(DateUtils.getMonthsBack("dd/MM/yyyy", 3));
    }


    public void BtnContinue() {
        bi.pBar3.setVisibility(View.GONE);
        if (!formValidation()) return;
        SaveDraft();
        if (UpdateDB()) {
            bi.pBar3.setVisibility(View.VISIBLE);
            RetrieveSLNo();
            // startActivity(new Intent(this, EndingActivity.class));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean RetrieveSLNo() {
        bi.sl4.setError(null);
        final OneTimeWorkRequest workRequest1 = new OneTimeWorkRequest.Builder(DataUpWorkerSL.class).build();
        WorkManager.getInstance().enqueue(workRequest1);


        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest1.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(@Nullable WorkInfo workInfo) {


                        if (workInfo.getState() != null &&
                                workInfo.getState() == WorkInfo.State.SUCCEEDED) {
                            //Displaying the status into TextView
                            //mTextView1.append("\n" + workInfo.getState().name());
                            bi.wmError.setVisibility(View.GONE);
                            bi.pBar3.setVisibility(View.GONE);


                            String message = workInfo.getOutputData().getString("slno");
                            DatabaseHelper db = new DatabaseHelper(SectionSLActivity.this); // Database Helper
                            StringBuilder sSyncedError = new StringBuilder();
                            JSONObject jsonObject;
                            try {


                                JSONArray json = new JSONArray(message);
                                for (int i = 0; i < json.length(); i++) {
                                    jsonObject = new JSONObject(json.getString(i));


                                    if (jsonObject.getString("status").equals("1") && jsonObject.getString("error").equals("0")) {

                                        db.updateSyncedFormsSL(jsonObject.getString("id"));  // UPDATE SYNCED
                                        bi.sl2.setText(jsonObject.getString("slno"));
                                        bi.wmError.setText("Log saved for MR No: " + bi.sl4.getText().toString());
                                        bi.wmError.setTextColor(getResources().getColor(R.color.green));
                                        bi.wmError.setVisibility(View.VISIBLE);
                                        Toast.makeText(SectionSLActivity.this, "Log saved for MR No: " + bi.sl4.getText().toString(), Toast.LENGTH_LONG).show();
                                        bi.btnEnd.setVisibility(View.VISIBLE);
                                        bi.btnContinue.setVisibility(View.GONE);
                                        //method.invoke(db, jsonObject.getString("id"));

                                        final Handler handler = new Handler(Looper.getMainLooper());
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                //Do something after 100ms
                                                oF = new Intent(SectionSLActivity.this, SectionSLActivity.class);
                                                startActivity(oF);
                                            }
                                        }, 3500);


                                    } else if (jsonObject.getString("status").equals("2") && jsonObject.getString("error").equals("0")) {

                                        if (jsonObject.getString("sl4").equals(bi.sl4.getText().toString())) {
                                            bi.wmError.setText("MR No. already exists.");
                                            bi.wmError.setVisibility(View.VISIBLE);
                                            bi.sl4.setError("MR No. already exists");
                                        } else {
                                            bi.wmError.setText("Server Error: UID not unique.");
                                        }

                                        db.updateSyncedFormsSL(jsonObject.getString("id")); // UPDATE DUPLICATES

                                    } else {
                                        sSyncedError.append("\nError: ").append(jsonObject.getString("message"));

                                    }

                                }
                            } catch (JSONException e) {
                                bi.wmError.setText("JSON Error: " + message);
                                bi.wmError.setVisibility(View.VISIBLE);
                                Log.d("JSON Error", "onChanged: " + message);
                                e.printStackTrace();


                            }
                            //bi.sl2.setText(message);
                        }
                        //mTextView1.append("\n" + workInfo.getState().name());
                        if (workInfo.getState() != null &&
                                workInfo.getState() == WorkInfo.State.FAILED) {
                            bi.pBar3.setVisibility(View.GONE);
                            String message = workInfo.getOutputData().getString("error");
                            bi.wmError.setText(message);
                            bi.wmError.setVisibility(View.VISIBLE);

                        }
                    }
                });
        return false;
    }

    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addFormSL(MainApp.formsSL);
        MainApp.formsSL.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.formsSL.set_UID(MainApp.formsSL.getDeviceID() + MainApp.formsSL.get_ID());
            db.updatesFormsSLColumn(FormsSLContract.FormsSLTable.COLUMN_UID, MainApp.formsSL.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() {
        MainApp.formsSL = new FormsSL();
        MainApp.formsSL.setSysdate(new SimpleDateFormat("dd-MM-yy HH:mm:sss").format(new Date().getTime()));
        MainApp.formsSL.setDeviceID(MainApp.appInfo.getDeviceID());
        MainApp.formsSL.setDevicetagID(MainApp.appInfo.getTagName());
        MainApp.formsSL.setAppversion(MainApp.appInfo.getAppVersion());
        MainApp.formsSL.setSl2(bi.sl2.getText().toString());
        MainApp.formsSL.setUsername(MainApp.userName);
        setGPS(this);

        String[] sl3 = bi.sl301.getText().toString().split("-");

        String sl301 = sl3[0];
        String sl302 = sl3[1];
        String sl303 = sl3[2];

        MainApp.formsSL.setSl301(sl301);
        MainApp.formsSL.setSl302(sl302);
        MainApp.formsSL.setSl303(sl303);


        MainApp.formsSL.setSl4(bi.sl4.getText().toString());

        MainApp.formsSL.setSl5(bi.sl5.getText().toString());

        MainApp.formsSL.setSl601(bi.sl601.getText().toString());
        MainApp.formsSL.setSl602(bi.sl602.getText().toString());

        String[] sl7 = bi.sl701.getText().toString().split("-");

        String sl701 = sl7[0];
        String sl702 = sl7[1];
        String sl703 = sl7[2];

        MainApp.formsSL.setSl701(sl701);
        MainApp.formsSL.setSl702(sl702);
        MainApp.formsSL.setSl703(sl703);


        MainApp.formsSL.setSl8(bi.sl801.isChecked() ? "1"
                : bi.sl802.isChecked() ? "2"
                : "-1");

        MainApp.formsSL.setSl9(bi.sl9.getText().toString());

        MainApp.formsSL.setSl10(bi.sl10.getText().toString());

        MainApp.formsSL.setSl11(bi.sl11.getText().toString());
        MainApp.setGPS(this);

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    private void setGPS(Activity activity) {
        SharedPreferences GPSPref = activity.getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String dt = GPSPref.getString("Time", "0");

            if (lat.equals("0") && lang.equals("0")) {
                Toast.makeText(activity, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            MainApp.formsSL.setGpsLat(GPSPref.getString("Latitude", "0"));
            MainApp.formsSL.setGpsLng(GPSPref.getString("Longitude", "0"));
            MainApp.formsSL.setGpsAcc(GPSPref.getString("Accuracy", "0"));
//            MainApp.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            MainApp.formsSL.setGpsDT(date); // Timestamp is converted to date above

        } catch (Exception e) {
            Log.e("GPS", "setGPS: " + e.getMessage());
        }
    }

    public void BtnEnd() {
        oF = new Intent(this, MainActivity.class);
        startActivity(oF);
    }

    @Override
    public void onBackPressed() {
        contextBackActivity(this);

    }

}