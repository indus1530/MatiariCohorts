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
import edu.aku.hassannaqvi.blf_screening.databinding.ActivitySectionWfcBinding;
import edu.aku.hassannaqvi.blf_screening.ui.other.MainActivity;

public class SectionWFCActivity extends AppCompatActivity {

    ActivitySectionWfcBinding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_wfc);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_wfc);
        bi.setCallback(this);
        setupSkips();
    }

    private void setupSkips() {

        bi.wfc101.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != bi.wfc10101.getId()) {
                Clear.clearAllFields(bi.llgrpsec1101);
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
                startActivity(new Intent(this, SectionWFDActivity.class));

            }
        }
    }


    public void BtnEnd() {
        oF = new Intent(this, MainActivity.class);
        startActivity(oF);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormsWFColumn(FormsWFContract.FormsWFTable.COLUMN_SWFC, MainApp.formsWF.sWFCtoString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() {

        MainApp.formsWF.setWfc101(bi.wfc10101.isChecked() ? "1"
                : bi.wfc10102.isChecked() ? "2"
                : bi.wfc10196.isChecked() ? "96"
                : "-1");
        MainApp.formsWF.setWfc10196x(bi.wfc10196x.getText().toString().trim().isEmpty() ? "-1" : bi.wfc10196x.getText().toString());

        MainApp.formsWF.setWfc102(bi.wfc102.getText().toString().trim().isEmpty() ? "-1" : bi.wfc102.getText().toString());

        MainApp.formsWF.setWfc103(bi.wfc103.getText().toString().trim().isEmpty() ? "-1" : bi.wfc103.getText().toString());

        MainApp.formsWF.setWfc104(bi.wfc104.getText().toString().trim().isEmpty() ? "-1" : bi.wfc104.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}