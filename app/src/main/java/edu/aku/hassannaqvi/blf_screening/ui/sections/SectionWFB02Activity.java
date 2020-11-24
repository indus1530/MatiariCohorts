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
import edu.aku.hassannaqvi.blf_screening.databinding.ActivitySectionWfb02Binding;
import edu.aku.hassannaqvi.blf_screening.ui.other.MainActivity;

public class SectionWFB02Activity extends AppCompatActivity {

    ActivitySectionWfb02Binding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_wfb02);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.wfb201.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.wfb20101.getId()) {
                Clear.clearAllFields(bi.fldGrpCVwfb202);
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
                startActivity(new Intent(this, SectionWFCActivity.class));
            }
        }
    }


    public void BtnEnd() {
        oF = new Intent(this, MainActivity.class);
        startActivity(oF);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormsWFColumn(FormsWFContract.FormsWFTable.COLUMN_SWFB02, MainApp.formsWF.sWFB02toString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() {

        MainApp.formsWF.setWfb201(bi.wfb20101.isChecked() ? "1"
                : bi.wfb20102.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfb202(bi.wfb202.getText().toString().trim().isEmpty() ? "-1" : bi.wfb202.getText().toString());

        MainApp.formsWF.setWfb203(bi.wfb20301.isChecked() ? "1"
                : bi.wfb20302.isChecked() ? "2"
                : bi.wfb20303.isChecked() ? "3"
                : bi.wfb20396.isChecked() ? "96"
                : "-1");
        MainApp.formsWF.setWfb20396x(bi.wfb20396x.getText().toString().trim().isEmpty() ? "-1" : bi.wfb20396x.getText().toString());

        MainApp.formsWF.setWfb204(bi.wfb204.getText().toString().trim().isEmpty() ? "-1" : bi.wfb204.getText().toString());

        MainApp.formsWF.setWfb205(bi.wfb20501.isChecked() ? "1"
                : bi.wfb20502.isChecked() ? "2"
                : bi.wfb20503.isChecked() ? "3"
                : bi.wfb20504.isChecked() ? "4"
                : bi.wfb20596.isChecked() ? "96"
                : "-1");
        MainApp.formsWF.setWfb20596x(bi.wfb20596x.getText().toString().trim().isEmpty() ? "-1" : bi.wfb20596x.getText().toString());

        MainApp.formsWF.setWfb206(bi.wfb206.getText().toString().trim().isEmpty() ? "-1" : bi.wfb206.getText().toString());

        MainApp.formsWF.setWfb207(bi.wfb207.getText().toString().trim().isEmpty() ? "-1" : bi.wfb207.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}