package edu.aku.hassannaqvi.matiari_cohorts.ui.sections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
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
import edu.aku.hassannaqvi.matiari_cohorts.models.Forms;
import edu.aku.hassannaqvi.matiari_cohorts.ui.other.MainActivity;

import static edu.aku.hassannaqvi.matiari_cohorts.core.MainApp.forms;

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

        bi.mc15.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.mc1501.getId()) {
                Clear.clearAllFields(bi.fldGrpCVmc16);
                Clear.clearAllFields(bi.fldGrpCVmc18);
            } else if (checkedId == bi.mc1502.getId()) {
                Clear.clearAllFields(bi.fldGrpCVmc17);
                Clear.clearAllFields(bi.fldGrpCVmc19);
                Clear.clearAllFields(bi.fldGrpCVmc20);
                Clear.clearAllFields(bi.fldGrpCVmc21);
                Clear.clearAllFields(bi.fldGrpCVmc22);
                Clear.clearAllFields(bi.fldGrpCVmc23);
                Clear.clearAllFields(bi.fldGrpCVmc24);
                Clear.clearAllFields(bi.fldGrpCVmc25);
            }
        });

        bi.mc17.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.mc1701.getId()) {
                Clear.clearAllFields(bi.fldGrpCVmc18);
            } else if (checkedId == bi.mc1702.getId()) {
                Clear.clearAllFields(bi.fldGrpCVmc19);
                Clear.clearAllFields(bi.fldGrpCVmc20);
                Clear.clearAllFields(bi.fldGrpCVmc21);
                Clear.clearAllFields(bi.fldGrpCVmc22);
            }
        });

        bi.mc19.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.mc1901.getId()) {
                Clear.clearAllFields(bi.fldGrpCVmc20);
                Clear.clearAllFields(bi.fldGrpCVmc21);
            } else if (checkedId == bi.mc1902.getId()) {
                Clear.clearAllFields(bi.fldGrpCVmc22);
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

        forms = new Forms();
        forms.setSysdate(new SimpleDateFormat("dd-MM-yy HH:mm", Locale.getDefault()).format(new Date().getTime()));
        forms.setDeviceID(MainApp.appInfo.getDeviceID());
        forms.setDevicetagID(MainApp.appInfo.getTagName());
        forms.setAppversion(MainApp.appInfo.getAppVersion());
        forms.setUsername(MainApp.userName);

        setGPS(this);

       /* form.setMc01(bi.mc01.getText().toString().trim().isEmpty() ? "-1" : bi.mc01.getText().toString());

        form.setMc02( bi.mc0201.isChecked() ? "1"
                : bi.mc0202.isChecked() ? "2"
                : bi.mc0203.isChecked() ? "3"
                : bi.mc0204.isChecked() ? "4"
                :  "-1");

        form.setMc03(bi.mc03.getText().toString().trim().isEmpty() ? "-1" : bi.mc03.getText().toString());

        form.setMc04(bi.mc04.getText().toString().trim().isEmpty() ? "-1" : bi.mc04.getText().toString());

        form.setMc05(bi.mc05.getText().toString().trim().isEmpty() ? "-1" : bi.mc05.getText().toString());

        form.setMc06(bi.mc06.getText().toString().trim().isEmpty() ? "-1" : bi.mc06.getText().toString());

        form.setMc07(bi.mc07.getText().toString().trim().isEmpty() ? "-1" : bi.mc07.getText().toString());

        form.setMc08(bi.mc08.getText().toString().trim().isEmpty() ? "-1" : bi.mc08.getText().toString());

        form.setMc09(bi.mc09.getText().toString().trim().isEmpty() ? "-1" : bi.mc09.getText().toString());

        form.setMc10(bi.mc10.getText().toString().trim().isEmpty() ? "-1" : bi.mc10.getText().toString());

        form.setMc11(bi.mc11.getText().toString().trim().isEmpty() ? "-1" : bi.mc11.getText().toString());

        form.setMc12(bi.mc12.getText().toString().trim().isEmpty() ? "-1" : bi.mc12.getText().toString());

        form.setMc1301(bi.mc1301.getText().toString().trim().isEmpty() ? "-1" : bi.mc1301.getText().toString());
        form.setMc1302(bi.mc1302.getText().toString().trim().isEmpty() ? "-1" : bi.mc1302.getText().toString());

        form.setMc14( bi.mc1401.isChecked() ? "1"
                : bi.mc1402.isChecked() ? "2"
                :  "-1");

        form.setMc15( bi.mc1501.isChecked() ? "1"
                : bi.mc1502.isChecked() ? "2"
                :  "-1");

        form.setMc16(bi.mc16.getText().toString().trim().isEmpty() ? "-1" : bi.mc16.getText().toString());

        form.setMc17( bi.mc1701.isChecked() ? "1"
                : bi.mc1702.isChecked() ? "2"
                :  "-1");

        form.setMc18( bi.mc1801.isChecked() ? "1"
                : bi.mc1802.isChecked() ? "2"
                : bi.mc1898.isChecked() ? "98"
                :  "-1");
        form.setMc1898x(bi.mc1898x.getText().toString().trim().isEmpty() ? "-1" : bi.mc1898x.getText().toString());

        form.setMc19( bi.mc1901.isChecked() ? "1"
                : bi.mc1902.isChecked() ? "2"
                :  "-1");

        form.setMc2001(bi.mc2001.getText().toString().trim().isEmpty() ? "-1" : bi.mc2001.getText().toString());
        form.setMc2002(bi.mc2002.getText().toString().trim().isEmpty() ? "-1" : bi.mc2002.getText().toString());

        form.setMc21(bi.mc21.getText().toString());

        form.setMc22( bi.mc2201.isChecked() ? "1"
                : bi.mc2202.isChecked() ? "2"
                :  "-1");

        form.setMc23(bi.mc23.getText().toString().trim().isEmpty() ? "-1" : bi.mc23.getText().toString());

        form.setMc24(bi.mc24.getText().toString().trim().isEmpty() ? "-1" : bi.mc24.getText().toString());

        form.setMc25( bi.mc2501.isChecked() ? "1"
                : bi.mc2502.isChecked() ? "2"
                : bi.mc2503.isChecked() ? "3"
                : bi.mc2504.isChecked() ? "4"
                : bi.mc2505.isChecked() ? "5"
                : bi.mc2506.isChecked() ? "6"
                :  "-1");

        form.setMc26(bi.mc26.getText().toString().trim().isEmpty() ? "-1" : bi.mc26.getText().toString());

        form.setMcrem(bi.mcrem.getText().toString().trim().isEmpty() ? "-1" : bi.mcrem.getText().toString());*/

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

        /*if (!bi.s1q8.getText().toString().isEmpty()) {

            if (bi.s1q8.getText().toString().equals(bi.s1q2.getText().toString())) {
                return Validator.emptyCustomTextBox(this, bi.s1q8, "S1Q2 & S1Q8\ncould not be the SAME");
            }
        }*/

        /*if (!bi.s1q15.getText().toString().isEmpty()) {

            if (Integer.parseInt(bi.s1q15.getText().toString()) >= Integer.parseInt(bi.s1q14.getText().toString())) {
                return Validator.emptyCustomTextBox(this, bi.s1q15, "S1Q15 could not be the \n greater or equals to then S1Q14");
            }
        }*/

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

            MainApp.forms.setGpsLat(GPSPref.getString("Latitude", "0"));
            MainApp.forms.setGpsLng(GPSPref.getString("Longitude", "0"));
            MainApp.forms.setGpsAcc(GPSPref.getString("Accuracy", "0"));
//            MainApp.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            MainApp.forms.setGpsDT(date); // Timestamp is converted to date above

        } catch (Exception e) {
            Log.e("GPS", "setGPS: " + e.getMessage());
        }
    }

}