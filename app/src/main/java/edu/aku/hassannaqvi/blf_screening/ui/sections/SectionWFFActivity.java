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
import edu.aku.hassannaqvi.blf_screening.databinding.ActivitySectionWffBinding;
import edu.aku.hassannaqvi.blf_screening.ui.other.MainActivity;

public class SectionWFFActivity extends AppCompatActivity {

    ActivitySectionWffBinding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_wff);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.wf101.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wf10102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVwfi02);
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
        oF = new Intent(this, MainActivity.class);
        startActivity(oF);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormsWFColumn(FormsWFContract.FormsWFTable.COLUMN_SWFF, MainApp.formsWF.sWFFtoString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() {

        MainApp.formsWF.setWf101(bi.wf10101.isChecked() ? "1"
                : bi.wf10102.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWf10102x(bi.wf10102x.getText().toString().trim().isEmpty() ? "-1" : bi.wf10102x.getText().toString());

        MainApp.formsWF.setWfi02(bi.wfi02.getText().toString().trim().isEmpty() ? "-1" : bi.wfi02.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}