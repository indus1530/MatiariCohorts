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
import edu.aku.hassannaqvi.blf_screening.databinding.ActivitySectionWfa05Binding;
import edu.aku.hassannaqvi.blf_screening.ui.other.MainActivity;

public class SectionWFA05Activity extends AppCompatActivity {

    ActivitySectionWfa05Binding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_wfa05);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.wfa507.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa50702.getId()) {
                Clear.clearAllFields(bi.fldGrpCVwfa508);
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
                startActivity(new Intent(this, SectionWFB01Activity.class));
            }
        }
    }


    public void BtnEnd() {
        oF = new Intent(this, MainActivity.class);
        startActivity(oF);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormsWFColumn(FormsWFContract.FormsWFTable.COLUMN_SWFA05, MainApp.formsWF.sWFA05toString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() {

        MainApp.formsWF.setWfa504(bi.wfa504.getText().toString().trim().isEmpty() ? "-1" : bi.wfa504.getText().toString());

        MainApp.formsWF.setWfa505(bi.wfa505.getText().toString().trim().isEmpty() ? "-1" : bi.wfa505.getText().toString());

        MainApp.formsWF.setWfa506(bi.wfa506.getText().toString().trim().isEmpty() ? "-1" : bi.wfa506.getText().toString());

        MainApp.formsWF.setWfa507(bi.wfa50701.isChecked() ? "1"
                : bi.wfa50702.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa50801(bi.wfa50801.isChecked() ? "1" : "-1");
        MainApp.formsWF.setWfa50802(bi.wfa50802.isChecked() ? "2" : "-1");
        MainApp.formsWF.setWfa50803(bi.wfa50803.isChecked() ? "3" : "-1");
        MainApp.formsWF.setWfa50804(bi.wfa50804.isChecked() ? "4" : "-1");
        MainApp.formsWF.setWfa50805(bi.wfa50805.isChecked() ? "5" : "-1");

        MainApp.formsWF.setWfa509(bi.wfa50901.isChecked() ? "1"
                : bi.wfa50902.isChecked() ? "2"
                : bi.wfa50903.isChecked() ? "3"
                : bi.wfa50904.isChecked() ? "4"
                : bi.wfa50996.isChecked() ? "96"
                : "-1");
        MainApp.formsWF.setWfa50996x(bi.wfa50996x.getText().toString().trim().isEmpty() ? "-1" : bi.wfa50996x.getText().toString());

        MainApp.formsWF.setWfa510(bi.wfa51001.isChecked() ? "1"
                : bi.wfa51002.isChecked() ? "2"
                : bi.wfa51096.isChecked() ? "96"
                : "-1");
        MainApp.formsWF.setWfa51096x(bi.wfa51096x.getText().toString().trim().isEmpty() ? "-1" : bi.wfa51096x.getText().toString());

        MainApp.formsWF.setWfa511(bi.wfa51101.isChecked() ? "1"
                : bi.wfa51102.isChecked() ? "2"
                : bi.wfa51103.isChecked() ? "3"
                : bi.wfa51104.isChecked() ? "4"
                : bi.wfa51105.isChecked() ? "5"
                : bi.wfa51196.isChecked() ? "96"
                : "-1");
        MainApp.formsWF.setWfa51196x(bi.wfa51196x.getText().toString().trim().isEmpty() ? "-1" : bi.wfa51196x.getText().toString());

        MainApp.formsWF.setWfa512(bi.wfa51201.isChecked() ? "1"
                : bi.wfa51202.isChecked() ? "2"
                : bi.wfa51296.isChecked() ? "96"
                : "-1");
        MainApp.formsWF.setWfa51296x(bi.wfa51296x.getText().toString().trim().isEmpty() ? "-1" : bi.wfa51296x.getText().toString());

        MainApp.formsWF.setWfa513(bi.wfa51301.isChecked() ? "1"
                : bi.wfa51302.isChecked() ? "2"
                : bi.wfa51396.isChecked() ? "96"
                : "-1");
        MainApp.formsWF.setWfa51396x(bi.wfa51396x.getText().toString().trim().isEmpty() ? "-1" : bi.wfa51396x.getText().toString());

        MainApp.formsWF.setWfa51401(bi.wfa51401.isChecked() ? "1" : "-1");
        MainApp.formsWF.setWfa51402(bi.wfa51402.isChecked() ? "2" : "-1");
        MainApp.formsWF.setWfa51403(bi.wfa51403.isChecked() ? "3" : "-1");
        MainApp.formsWF.setWfa51404(bi.wfa51404.isChecked() ? "4" : "-1");

        MainApp.formsWF.setWfa515(bi.wfa51501.isChecked() ? "1"
                : bi.wfa51502.isChecked() ? "2"
                : bi.wfa51596.isChecked() ? "96"
                : "-1");
        MainApp.formsWF.setWfa51596x(bi.wfa51596x.getText().toString().trim().isEmpty() ? "-1" : bi.wfa51596x.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}