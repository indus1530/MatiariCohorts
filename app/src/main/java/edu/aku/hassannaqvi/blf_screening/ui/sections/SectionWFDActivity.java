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
import edu.aku.hassannaqvi.blf_screening.databinding.ActivitySectionWfdBinding;
import edu.aku.hassannaqvi.blf_screening.ui.other.MainActivity;

public class SectionWFDActivity extends AppCompatActivity {

    ActivitySectionWfdBinding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_wfd);
        bi.setCallback(this);
        setupSkips();
    }

    private void setupSkips() {

        bi.wfd101.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfd10102.getId()) {
                Clear.clearAllFields(bi.wfdGrpCVwfd101);
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
                startActivity(new Intent(this, SectionWFEActivity.class));
            }
        }
    }


    public void BtnEnd() {
        oF = new Intent(this, MainActivity.class);
        startActivity(oF);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormsWFColumn(FormsWFContract.FormsWFTable.COLUMN_SWFD, MainApp.formsWF.sWFDtoString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() {

        MainApp.formsWF.setWfd101(bi.wfd10101.isChecked() ? "1"
                : bi.wfd10102.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd10102x(bi.wfd10102x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd10102x.getText().toString());

        MainApp.formsWF.setWfd102a(bi.wfd102a01.isChecked() ? "1"
                : bi.wfd102a02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102a01x(bi.wfd102a01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102a01x.getText().toString());

        MainApp.formsWF.setWfd102b(bi.wfd102b01.isChecked() ? "1"
                : bi.wfd102b02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102b01x(bi.wfd102b01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102b01x.getText().toString());

        MainApp.formsWF.setWfd102c(bi.wfd102c01.isChecked() ? "1"
                : bi.wfd102c02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102c01x(bi.wfd102c01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102c01x.getText().toString());

        MainApp.formsWF.setWfd102d(bi.wfd102d01.isChecked() ? "1"
                : bi.wfd102d02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102d01x(bi.wfd102d01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102d01x.getText().toString());

        MainApp.formsWF.setWfd102e(bi.wfd102e01.isChecked() ? "1"
                : bi.wfd102e02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102e01x(bi.wfd102e01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102e01x.getText().toString());

        MainApp.formsWF.setWfd102f(bi.wfd102f01.isChecked() ? "1"
                : bi.wfd102f02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102f01x(bi.wfd102f01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102f01x.getText().toString());

        MainApp.formsWF.setWfd102g(bi.wfd102g01.isChecked() ? "1"
                : bi.wfd102g02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102g01x(bi.wfd102g01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102g01x.getText().toString());

        MainApp.formsWF.setWfd102h(bi.wfd102h01.isChecked() ? "1"
                : bi.wfd102h02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102h01x(bi.wfd102h01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102h01x.getText().toString());

        MainApp.formsWF.setWfd102i(bi.wfd102i01.isChecked() ? "1"
                : bi.wfd102i02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102i01x(bi.wfd102i01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102i01x.getText().toString());

        MainApp.formsWF.setWfd102j(bi.wfd102j01.isChecked() ? "1"
                : bi.wfd102j02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102j01x(bi.wfd102j01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102j01x.getText().toString());

        MainApp.formsWF.setWfd102k(bi.wfd102k01.isChecked() ? "1"
                : bi.wfd102k02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102k01x(bi.wfd102k01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102k01x.getText().toString());

        MainApp.formsWF.setWfd102l(bi.wfd102l01.isChecked() ? "1"
                : bi.wfd102l02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102l01x(bi.wfd102l01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102l01x.getText().toString());

        MainApp.formsWF.setWfd102m(bi.wfd102m01.isChecked() ? "1"
                : bi.wfd102m02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102m01x(bi.wfd102m01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102m01x.getText().toString());

        MainApp.formsWF.setWfd102n(bi.wfd102n01.isChecked() ? "1"
                : bi.wfd102n02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102n01x(bi.wfd102n01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102n01x.getText().toString());

        MainApp.formsWF.setWfd102o(bi.wfd102o01.isChecked() ? "1"
                : bi.wfd102o02.isChecked() ? "2"
                : "-1");
        MainApp.formsWF.setWfd102o01x(bi.wfd102o01x.getText().toString().trim().isEmpty() ? "-1" : bi.wfd102o01x.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}