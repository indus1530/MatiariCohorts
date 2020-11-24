package edu.aku.hassannaqvi.blf_screening.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.blf_screening.R;
import edu.aku.hassannaqvi.blf_screening.contracts.FormsENContract;
import edu.aku.hassannaqvi.blf_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.blf_screening.core.MainApp;
import edu.aku.hassannaqvi.blf_screening.databinding.ActivitySectionEn03Binding;
import edu.aku.hassannaqvi.blf_screening.ui.other.MainActivity;
import edu.aku.hassannaqvi.blf_screening.workers.DataUpWorkerEN;

public class SectionEN03Activity extends AppCompatActivity {

    ActivitySectionEn03Binding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_en03);
        bi.setCallback(this);
        setupSkips();
    }

    private void setupSkips() {

        bi.fldGrpCVs3q9.setVisibility(MainApp.childAgeinHours > 24 ? View.VISIBLE : View.GONE);

        bi.s3q3.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.s3q301.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs3q4);
            }
        });

        bi.s3q5.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.s3q505.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs3q6);
            }
        });

        bi.s3q7.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.s3q702.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs3q8);
            }
        });

    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
   /*             finish();
                startActivity(new Intent(this, MainActivity.class));*/
                bi.pBar3.setVisibility(View.VISIBLE);

                UploadData();

            }
        }
    }

    private boolean UploadData() {
        final OneTimeWorkRequest workRequest1 = new OneTimeWorkRequest.Builder(DataUpWorkerEN.class).build();
        WorkManager.getInstance().enqueue(workRequest1);


        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest1.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(@Nullable WorkInfo workInfo) {


                        if (workInfo.getState() != null &&
                                workInfo.getState() == WorkInfo.State.SUCCEEDED) {

                            bi.wmError.setVisibility(View.GONE);
                            bi.pBar3.setVisibility(View.GONE);
                            //Displaying the status into TextView
                            //mTextView1.append("\n" + workInfo.getState().name());
                            String message = workInfo.getOutputData().getString("message");
                            DatabaseHelper db = new DatabaseHelper(SectionEN03Activity.this); // Database Helper
                            StringBuilder sSyncedError = new StringBuilder();
                            JSONObject jsonObject;
                            try {

                                JSONArray json = new JSONArray(message);
                                for (int i = 0; i < json.length(); i++) {
                                    jsonObject = new JSONObject(json.getString(i));

                                    if (!jsonObject.getString("error").equals("1")) {

                                        if (jsonObject.getString("status").equals("1")) {

                                            db.updateSyncedFormsEN(jsonObject.getString("id"));  // UPDATE SYNCED

                                            Toast.makeText(SectionEN03Activity.this, "Enrolment Form saved for MR No: " + MainApp.s1q2, Toast.LENGTH_LONG).show();

                                            //method.invoke(db, jsonObject.getString("id"));

                                            final Handler handler = new Handler(Looper.getMainLooper());
                                            handler.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    //Do something after 100ms
                                                    oF = new Intent(SectionEN03Activity.this, MainActivity.class);
                                                    startActivity(oF);
                                                }
                                            }, 3500);

                                        } else {
                                            sSyncedError.append("\nError: ").append(jsonObject.getString("message"));
                                        }
                                    } else {
                                        bi.wmError.setText(jsonObject.getString("message"));
                                        bi.wmError.setVisibility(View.VISIBLE);
                                        bi.wmError.setTextColor(getResources().getColor(R.color.red));
                                        //bi.sf2.setError("MR No. already exists");
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

    public void BtnEnd() {
        oF = new Intent(this, MainActivity.class);
        startActivity(oF);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormsS3Column(FormsENContract.FormsS3Table.COLUMN_EN, MainApp.formsEN.s3toString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() {

        MainApp.formsEN.setS3q1(bi.s3q101.isChecked() ? "1"
                : bi.s3q102.isChecked() ? "2"
                : bi.s3q199.isChecked() ? "99"
                : "-1");

        MainApp.formsEN.setS3q2(bi.s3q201.isChecked() ? "1"
                : bi.s3q202.isChecked() ? "2"
                : bi.s3q203.isChecked() ? "3"
                : bi.s3q204.isChecked() ? "4"
                : bi.s3q205.isChecked() ? "5"
                : bi.s3q206.isChecked() ? "6"
                : bi.s3q2096.isChecked() ? "96"
                : "-1");
        MainApp.formsEN.setS3q2096x(bi.s3q2096x.getText().toString().trim().isEmpty() ? "-1" : bi.s3q2096x.getText().toString());

        MainApp.formsEN.setS3q3(bi.s3q301.isChecked() ? "1"
                : bi.s3q302.isChecked() ? "2"
                : bi.s3q399.isChecked() ? "99"
                : "-1");

        MainApp.formsEN.setS3q401(bi.s3q401.isChecked() ? "1" : "-1");
        MainApp.formsEN.setS3q402(bi.s3q402.isChecked() ? "2" : "-1");
        MainApp.formsEN.setS3q403(bi.s3q403.isChecked() ? "3" : "-1");
        MainApp.formsEN.setS3q496(bi.s3q496.isChecked() ? "96" : "-1");
        MainApp.formsEN.setS3q496x(bi.s3q496x.getText().toString().trim().isEmpty() ? "-1" : bi.s3q496x.getText().toString());

        MainApp.formsEN.setS3q5(bi.s3q501.isChecked() ? "1"
                : bi.s3q502.isChecked() ? "2"
                : bi.s3q503.isChecked() ? "3"
                : bi.s3q504.isChecked() ? "4"
                : bi.s3q505.isChecked() ? "5"
                : bi.s3q596.isChecked() ? "96"
                : "-1");
        MainApp.formsEN.setS3q596x(bi.s3q596x.getText().toString().trim().isEmpty() ? "-1" : bi.s3q596x.getText().toString());

        MainApp.formsEN.setS3q601(bi.s3q601.isChecked() ? "1" : "-1");
        MainApp.formsEN.setS3q602(bi.s3q602.isChecked() ? "2" : "-1");
        MainApp.formsEN.setS3q603(bi.s3q603.isChecked() ? "3" : "-1");
        MainApp.formsEN.setS3q604(bi.s3q604.isChecked() ? "4" : "-1");
        MainApp.formsEN.setS3q605(bi.s3q605.isChecked() ? "5" : "-1");
        MainApp.formsEN.setS3q696(bi.s3q696.isChecked() ? "96" : "-1");
        MainApp.formsEN.setS3q696x(bi.s3q696x.getText().toString().trim().isEmpty() ? "-1" : bi.s3q696x.getText().toString());

        MainApp.formsEN.setS3q7(bi.s3q701.isChecked() ? "1"
                : bi.s3q702.isChecked() ? "2"
                : "-1");

        MainApp.formsEN.setS3q801(bi.s3q801.isChecked() ? "1" : "-1");
        MainApp.formsEN.setS3q802(bi.s3q802.isChecked() ? "2" : "-1");
        MainApp.formsEN.setS3q803(bi.s3q803.isChecked() ? "3" : "-1");
        MainApp.formsEN.setS3q896(bi.s3q896.isChecked() ? "96" : "-1");
        MainApp.formsEN.setS3q896x(bi.s3q896x.getText().toString().trim().isEmpty() ? "-1" : bi.s3q896x.getText().toString());

        MainApp.formsEN.setS3q9(bi.s3q901.isChecked() ? "1"
                : bi.s3q902.isChecked() ? "2"
                : bi.s3q999.isChecked() ? "99"
                : "-1");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}