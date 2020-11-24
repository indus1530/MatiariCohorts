package edu.aku.hassannaqvi.blf_screening.ui.sections;

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

import edu.aku.hassannaqvi.blf_screening.R;
import edu.aku.hassannaqvi.blf_screening.contracts.FormsWFContract;
import edu.aku.hassannaqvi.blf_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.blf_screening.core.MainApp;
import edu.aku.hassannaqvi.blf_screening.databinding.ActivitySectionWfa01Binding;
import edu.aku.hassannaqvi.blf_screening.models.FormsWF;
import edu.aku.hassannaqvi.blf_screening.ui.other.MainActivity;

import static edu.aku.hassannaqvi.blf_screening.core.MainApp.formsWF;

public class SectionWFA01Activity extends AppCompatActivity {

    ActivitySectionWfa01Binding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_wfa01);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.wfa107.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.wfa10701.getId()) {
                Clear.clearAllFields(bi.fldGrpCVwfa108);
            }
        });

        bi.wfa108.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.wfa10802.getId()) {
                Clear.clearAllFields(bi.llGrpseca01);
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
                startActivity(new Intent(this, bi.wfa10802.isChecked() ? MainActivity.class : SectionWFA02Activity.class));

            }
        }
    }


    public void BtnEnd() {
        oF = new Intent(this, MainActivity.class);
        startActivity(oF);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addFormWF(formsWF);
        formsWF.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            formsWF.set_UID(formsWF.getDeviceID() + formsWF.get_ID());
            db.updatesFormsWFColumn(FormsWFContract.FormsWFTable.COLUMN_UID, formsWF.get_UID());
            db.updatesFormsWFColumn(FormsWFContract.FormsWFTable.COLUMN_SWFA01, formsWF.sWFA01toString());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() {

        formsWF = new FormsWF();
        formsWF.setSysdate(new SimpleDateFormat("dd-MM-yy HH:mm", Locale.getDefault()).format(new Date().getTime()));
        formsWF.setDeviceID(MainApp.appInfo.getDeviceID());
        formsWF.setDevicetagID(MainApp.appInfo.getTagName());
        formsWF.setAppversion(MainApp.appInfo.getAppVersion());
        formsWF.setUsername(MainApp.userName);

        setGPS(this);

        String[] swf1 = bi.wfa10401.getText().toString().split("-");
        String wfa10401 = swf1[0];
        String wfa10402 = swf1[1];
        String wfa10403 = swf1[2];
        MainApp.formsWF.setWfa10401(wfa10401);
        MainApp.formsWF.setWfa10402(wfa10402);
        MainApp.formsWF.setWfa10403(wfa10403);

        swf1 = bi.wfa10404.getText().toString().split(":");
        String wfa10404 = swf1[0];
        String wfa10405 = swf1[1];
        MainApp.formsWF.setWfa10404(wfa10404);
        MainApp.formsWF.setWfa10405(wfa10405);

        formsWF.setWfa101(bi.wfa101.getText().toString().trim().isEmpty() ? "-1" : bi.wfa101.getText().toString());

        formsWF.setWfa102(bi.wfa102.getText().toString().trim().isEmpty() ? "-1" : bi.wfa102.getText().toString());

        formsWF.setWfa103(bi.wfa103.getText().toString().trim().isEmpty() ? "-1" : bi.wfa103.getText().toString());

        formsWF.setWfa105(bi.wfa10501.isChecked() ? "1"
                : bi.wfa10502.isChecked() ? "2"
                : bi.wfa10503.isChecked() ? "3"
                : bi.wfa10504.isChecked() ? "4"
                : bi.wfa10505.isChecked() ? "5"
                : bi.wfa10506.isChecked() ? "6"
                : bi.wfa10507.isChecked() ? "7"
                : bi.wfa10508.isChecked() ? "8"
                : bi.wfa10509.isChecked() ? "9"
                : bi.wfa10510.isChecked() ? "10"
                : bi.wfa10511.isChecked() ? "11"
                : bi.wfa10512.isChecked() ? "12"
                : bi.wfa10513.isChecked() ? "13"
                : "-1");

        formsWF.setWfa106(bi.wfa10601.isChecked() ? "1"
                : bi.wfa10602.isChecked() ? "2"
                : bi.wfa10696.isChecked() ? "96"
                : "-1");
        formsWF.setWfa10696x(bi.wfa10696x.getText().toString().trim().isEmpty() ? "-1" : bi.wfa10696x.getText().toString());

        formsWF.setWfa107(bi.wfa10701.isChecked() ? "1"
                : bi.wfa10702.isChecked() ? "2"
                : "-1");

        formsWF.setWfa108(bi.wfa10801.isChecked() ? "1"
                : bi.wfa10802.isChecked() ? "2"
                : "-1");

        formsWF.setWfa109(bi.wfa10901.isChecked() ? "1"
                : bi.wfa10902.isChecked() ? "2"
                : bi.wfa10903.isChecked() ? "3"
                : bi.wfa10904.isChecked() ? "4"
                : bi.wfa10905.isChecked() ? "5"
                : bi.wfa10906.isChecked() ? "6"
                : bi.wfa10907.isChecked() ? "7"
                : bi.wfa10908.isChecked() ? "8"
                : bi.wfa10998.isChecked() ? "98"
                : bi.wfa10996.isChecked() ? "96"
                : "-1");
        formsWF.setWfa10996x(bi.wfa10996x.getText().toString().trim().isEmpty() ? "-1" : bi.wfa10996x.getText().toString());

        String[] swf10 = bi.wfa11001.getText().toString().split("-");
        String wfa11001 = swf10[0];
        String wfa11002 = swf10[1];
        String wfa11003 = swf10[2];
        MainApp.formsWF.setWfa11001(wfa11001);
        MainApp.formsWF.setWfa11002(wfa11002);
        MainApp.formsWF.setWfa11003(wfa11003);

        swf10 = bi.wfa11004.getText().toString().split(":");
        String wfa11004 = swf10[0];
        String wfa11005 = swf10[1];
        MainApp.formsWF.setWfa11004(wfa11004);
        MainApp.formsWF.setWfa11005(wfa11005);

        formsWF.setWfa111(bi.wfa11101.isChecked() ? "1"
                : bi.wfa11102.isChecked() ? "2"
                : bi.wfa11103.isChecked() ? "3"
                : "-1");

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