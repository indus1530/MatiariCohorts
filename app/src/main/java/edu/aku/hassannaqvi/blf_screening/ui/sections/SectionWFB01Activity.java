package edu.aku.hassannaqvi.blf_screening.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.blf_screening.R;
import edu.aku.hassannaqvi.blf_screening.contracts.FormsWFContract;
import edu.aku.hassannaqvi.blf_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.blf_screening.core.MainApp;
import edu.aku.hassannaqvi.blf_screening.databinding.ActivitySectionWfb01Binding;
import edu.aku.hassannaqvi.blf_screening.ui.other.MainActivity;

public class SectionWFB01Activity extends AppCompatActivity {

    ActivitySectionWfb01Binding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_wfb01);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.wfb101.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.wfb10102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVwfb102);
            }
        });

        bi.wfb1081a.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfb1081a02.getId()) {
                Clear.clearAllFields(bi.llgrpsecb01);
            }
        });

        bi.wfb1081b.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.wfb1081b02.getId()) {
                Clear.clearAllFields(bi.fldGrpCVwfb1081c);
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
                startActivity(new Intent(this, SectionWFB02Activity.class));
            }
        }
    }


    public void BtnEnd() {
        oF = new Intent(this, MainActivity.class);
        startActivity(oF);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormsWFColumn(FormsWFContract.FormsWFTable.COLUMN_SWFB01, MainApp.formsWF.sWFB01toString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() {

        MainApp.formsWF.setWfb101(bi.wfb10101.isChecked() ? "1"
                : bi.wfb10102.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfb102(bi.wfb10201.isChecked() ? "1"
                : bi.wfb10202.isChecked() ? "2"
                : bi.wfb10203.isChecked() ? "3"
                : bi.wfb10204.isChecked() ? "4"
                : bi.wfb10296.isChecked() ? "96"
                : "-1");
        MainApp.formsWF.setWfb10296x(bi.wfb10296x.getText().toString().trim().isEmpty() ? "-1" : bi.wfb10296x.getText().toString());

        MainApp.formsWF.setWfb103(bi.wfb103.getText().toString().trim().isEmpty() ? "-1" : bi.wfb103.getText().toString());

        MainApp.formsWF.setWfb104(bi.wfb104.getText().toString().trim().isEmpty() ? "-1" : bi.wfb104.getText().toString());

        MainApp.formsWF.setWfb105(bi.wfb105.getText().toString().trim().isEmpty() ? "-1" : bi.wfb105.getText().toString());

        //    MainApp.formsWF.setWfi06(bi.wfi06.getText().toString().trim().isEmpty() ? "-1" : bi.wfa504.getText().toString());

        MainApp.formsWF.setWfi0601(bi.wfi0601.getText().toString().trim().isEmpty() ? "-1" : bi.wfi0601.getText().toString());

        MainApp.formsWF.setWfi0701(bi.wfi0701.isChecked() ? "1" : "-1");
        MainApp.formsWF.setWfi0702(bi.wfi0702.isChecked() ? "2" : "-1");
        MainApp.formsWF.setWfi0796(bi.wfi0796.isChecked() ? "96" : "-1");
        MainApp.formsWF.setWfi0796x(bi.wfi0796x.getText().toString().trim().isEmpty() ? "-1" : bi.wfi0796x.getText().toString());

        MainApp.formsWF.setWfb1081a(bi.wfb1081a01.isChecked() ? "1"
                : bi.wfb1081a02.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfb1081b(bi.wfb1081b01.isChecked() ? "1"
                : bi.wfb1081b02.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfb1081c(bi.wfb1081c01.isChecked() ? "1"
                : bi.wfb1081c02.isChecked() ? "2"
                : bi.wfb1081c03.isChecked() ? "3"
                : "-1");

        MainApp.formsWF.setWfb1081d(bi.wfb1081d01.isChecked() ? "1"
                : bi.wfb1081d02.isChecked() ? "2"
                : bi.wfb1081d03.isChecked() ? "3"
                : bi.wfb1081d04.isChecked() ? "4"
                : bi.wfb1081d05.isChecked() ? "5"
                : bi.wfb1081d06.isChecked() ? "6"
                : bi.wfb1081d96.isChecked() ? "96"
                : "-1");
        MainApp.formsWF.setWfb1081d06x(bi.wfb1081d06x.getText().toString().trim().isEmpty() ? "-1" : bi.wfb1081d06x.getText().toString());
        MainApp.formsWF.setWfb1081d96x(bi.wfb1081d96x.getText().toString().trim().isEmpty() ? "-1" : bi.wfb1081d96x.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}