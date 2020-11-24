package edu.aku.hassannaqvi.matiari_cohorts.ui.sections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.matiari_cohorts.R;
import edu.aku.hassannaqvi.matiari_cohorts.core.MainApp;
import edu.aku.hassannaqvi.matiari_cohorts.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.matiari_cohorts.models.FormsEN;
import edu.aku.hassannaqvi.matiari_cohorts.ui.other.MainActivity;

import static edu.aku.hassannaqvi.matiari_cohorts.core.MainApp.formsEN;

public class SectionAActivity extends AppCompatActivity {

    ActivitySectionABinding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        bi.s1q2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //         Log.d(this.getClass().getSimpleName(), "onTextChanged: S " + start + " A " + after + " C " + count);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (bi.llGrpName03.getVisibility() == View.VISIBLE) {
                    bi.llGrpName03.setVisibility(View.GONE);
                    bi.btnContinue.setVisibility(View.GONE);
                    Clear.clearAllFields(bi.llGrpName03);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bi.s1q18.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.s1q1802.getId()) {
                Clear.clearAllFields(bi.llGrpsec31);
            }
        });

        bi.s1q20.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.s1q2002.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs1q21);
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
                finish();
                startActivity(new Intent(this, MainActivity.class));

            }
        }
    }


    public void BtnEnd() {
        super.onBackPressed();
    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addFormS3(formsEN);
        formsEN.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            formsEN.set_UID(formsEN.getDeviceID() + formsEN.get_ID());
            db.updatesFormsS3Column(FormsENContract.FormsS3Table.COLUMN_UID, formsEN.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;

    }


    private void SaveDraft() {

        formsEN = new FormsEN();
        formsEN.setSysdate(new SimpleDateFormat("dd-MM-yy HH:mm", Locale.getDefault()).format(new Date().getTime()));
        formsEN.setDeviceID(MainApp.appInfo.getDeviceID());
        formsEN.setDevicetagID(MainApp.appInfo.getTagName());
        formsEN.setAppversion(MainApp.appInfo.getAppVersion());
        formsEN.setUsername(MainApp.userName);

        setGPS(this);

        formsEN.setS1q1(bi.s1q1.getText().toString().trim().isEmpty() ? "-1" : bi.s1q1.getText().toString());

        formsEN.setS1q2(bi.s1q2.getText().toString().trim().isEmpty() ? "-1" : bi.s1q2.getText().toString());

        formsEN.setS1q3(bi.s1q3.getText().toString().trim().isEmpty() ? "-1" : bi.s1q3.getText().toString());

        formsEN.setS1q4(bi.s1q401.isChecked() ? "1"
                : bi.s1q402.isChecked() ? "2"
                : "-1");

        formsEN.setS1q501(bi.s1q501.getText().toString().trim().isEmpty() ? "-1" : bi.s1q501.getText().toString());
        formsEN.setS1q502(bi.s1q502.getText().toString().trim().isEmpty() ? "-1" : bi.s1q502.getText().toString());

        formsEN.setS1q6(bi.s1q6.getText().toString().trim().isEmpty() ? "-1" : bi.s1q6.getText().toString());

        formsEN.setS1q7(bi.s1q7.getText().toString().trim().isEmpty() ? "-1" : bi.s1q7.getText().toString());

        formsEN.setS1q8(bi.s1q8.getText().toString().trim().isEmpty() ? "-1" : bi.s1q8.getText().toString());

        formsEN.setS1q9(bi.s1q9.getText().toString().trim().isEmpty() ? "-1" : bi.s1q9.getText().toString());

        formsEN.setS1q10(bi.s1q10.getText().toString().trim().isEmpty() ? "-1" : bi.s1q10.getText().toString());

        formsEN.setS1q11(bi.s1q11.getText().toString().trim().isEmpty() ? "-1" : bi.s1q11.getText().toString());

        formsEN.setS1q12(bi.s1q12.getText().toString().trim().isEmpty() ? "-1" : bi.s1q12.getText().toString());

        formsEN.setS1q13(bi.s1q13.getText().toString().trim().isEmpty() ? "-1" : bi.s1q13.getText().toString());

        formsEN.setS1q14(bi.s1q14.getText().toString().trim().isEmpty() ? "-1" : bi.s1q14.getText().toString());

        formsEN.setS1q15(bi.s1q15.getText().toString().trim().isEmpty() ? "-1" : bi.s1q15.getText().toString());

        formsEN.setS1q16(bi.s1q1601.isChecked() ? "1"
                : bi.s1q1602.isChecked() ? "2"
                : "-1");

        formsEN.setS1q17(bi.s1q1701.isChecked() ? "1"
                : bi.s1q1702.isChecked() ? "2"
                : "-1");

        formsEN.setS1q18(bi.s1q1801.isChecked() ? "1"
                : bi.s1q1802.isChecked() ? "2"
                : "-1");

        formsEN.setS1q1802x(bi.s1q1802x.getText().toString().trim().isEmpty() ? "-1" : bi.s1q1802x.getText().toString());

        formsEN.setS1q1901(bi.s1q1901.getText().toString().trim().isEmpty() ? "-1" : bi.s1q1901.getText().toString());
        formsEN.setS1q1902(bi.s1q1902.getText().toString().trim().isEmpty() ? "-1" : bi.s1q1902.getText().toString());

        formsEN.setS1q20(bi.s1q2001.isChecked() ? "1"
                : bi.s1q2002.isChecked() ? "2"
                : "-1");

        formsEN.setS1q21(bi.s1q2101.isChecked() ? "1"
                : bi.s1q2102.isChecked() ? "2"
                : bi.s1q2103.isChecked() ? "3"
                : bi.s1q2104.isChecked() ? "4"
                : "-1");

        //    formsEN.setS1q22(bi.s1q22.getText().toString().trim().isEmpty() ? "-1" : bi.s1q22.getText().toString());

        formsEN.setS1q2301(bi.s1q2301.getText().toString().trim().isEmpty() ? "-1" : bi.s1q2301.getText().toString());
        formsEN.setS1q2302(bi.s1q2302.getText().toString().trim().isEmpty() ? "-1" : bi.s1q2302.getText().toString());

    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (!bi.s1q8.getText().toString().isEmpty()) {

            if (bi.s1q8.getText().toString().equals(bi.s1q2.getText().toString())) {
                return Validator.emptyCustomTextBox(this, bi.s1q8, "S1Q2 & S1Q8\ncould not be the SAME");
            }
        }

        if (!bi.s1q15.getText().toString().isEmpty()) {

            if (Integer.parseInt(bi.s1q15.getText().toString()) >= Integer.parseInt(bi.s1q14.getText().toString())) {
                return Validator.emptyCustomTextBox(this, bi.s1q15, "S1Q15 could not be the \n greater or equals to then S1Q14");
            }
        }

        return true;

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
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

            MainApp.formsEN.setGpsLat(GPSPref.getString("Latitude", "0"));
            MainApp.formsEN.setGpsLng(GPSPref.getString("Longitude", "0"));
            MainApp.formsEN.setGpsAcc(GPSPref.getString("Accuracy", "0"));
//            MainApp.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            MainApp.formsEN.setGpsDT(date); // Timestamp is converted to date above

        } catch (Exception e) {
            Log.e("GPS", "setGPS: " + e.getMessage());
        }
    }

}