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
import edu.aku.hassannaqvi.blf_screening.databinding.ActivitySectionWfeBinding;
import edu.aku.hassannaqvi.blf_screening.ui.other.MainActivity;

public class SectionWFEActivity extends AppCompatActivity {

    ActivitySectionWfeBinding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_wfe);
        bi.setCallback(this);
        setupSkips();
    }

    private void setupSkips() {

        bi.wfe101.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfe10102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVwfe102);
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
                startActivity(new Intent(this, SectionWFFActivity.class));
            }
        }
    }


    public void BtnEnd() {
        oF = new Intent(this, MainActivity.class);
        startActivity(oF);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormsWFColumn(FormsWFContract.FormsWFTable.COLUMN_SWFE, MainApp.formsWF.sWFEtoString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() {

        MainApp.formsWF.setWfe101(bi.wfe10101.isChecked() ? "1"
                : bi.wfe10102.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfe10102x(bi.wfe10102x.getText().toString().trim().isEmpty() ? "-1" : bi.wfe10102x.getText().toString());

        MainApp.formsWF.setWfe102(bi.wfe102.getText().toString().trim().isEmpty() ? "-1" : bi.wfe102.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}