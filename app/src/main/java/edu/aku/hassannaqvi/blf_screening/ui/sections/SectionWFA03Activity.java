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
import edu.aku.hassannaqvi.blf_screening.databinding.ActivitySectionWfa03Binding;
import edu.aku.hassannaqvi.blf_screening.ui.other.MainActivity;

public class SectionWFA03Activity extends AppCompatActivity {

    ActivitySectionWfa03Binding bi;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_wfa03);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.wfa301.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa30102.getId()) {
                Clear.clearAllFields(bi.llGrpseca301);
            }
        });

        bi.wfa304.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa30402.getId()) {
                Clear.clearAllFields(bi.llGrpseca302);
            }
        });

        bi.wfa307.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa30702.getId()) {
                Clear.clearAllFields(bi.llGrpseca303);
            }
        });

        bi.wfa310.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa31002.getId()) {
                Clear.clearAllFields(bi.llGrpseca304);
            }
        });

        bi.wfa313.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa31302.getId()) {
                Clear.clearAllFields(bi.llGrpseca305);
            }
        });

        bi.wfa316.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa31602.getId()) {
                Clear.clearAllFields(bi.llGrpseca306);
            }
        });

        bi.wfa319.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa31902.getId()) {
                Clear.clearAllFields(bi.llGrpseca307);
            }
        });

        bi.wfa322.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa32202.getId()) {
                Clear.clearAllFields(bi.fldGrpCVwfa323);
            }
        });

        bi.wfa324.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa32402.getId()) {
                Clear.clearAllFields(bi.llGrpseca308);
            }
        });

        bi.wfa327.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa32702.getId()) {
                Clear.clearAllFields(bi.fldGrpCVwfa328);
            }
        });

        bi.wfa329.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa32902.getId()) {
                Clear.clearAllFields(bi.llGrpseca309);
            }
        });

        bi.wfa333.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa33302.getId()) {
                Clear.clearAllFields(bi.llGrpseca310);
            }
        });

        bi.wfa336.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.wfa33602.getId()) {
                Clear.clearAllFields(bi.llGrpseca311);
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
                startActivity(new Intent(this, SectionWFA04Activity.class));
            }
        }
    }


    public void BtnEnd() {
        oF = new Intent(this, MainActivity.class);
        startActivity(oF);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormsWFColumn(FormsWFContract.FormsWFTable.COLUMN_SWFA03, MainApp.formsWF.sWFA03toString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() {

        MainApp.formsWF.setWfa301(bi.wfa30101.isChecked() ? "1"
                : bi.wfa30102.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa302(bi.wfa302.getText().toString().trim().isEmpty() ? "-1" : bi.wfa302.getText().toString());

        MainApp.formsWF.setWfa30301(bi.wfa30301.getText().toString().trim().isEmpty() ? "-1" : bi.wfa30301.getText().toString());
        MainApp.formsWF.setWfa30302(bi.wfa30302.getText().toString().trim().isEmpty() ? "-1" : bi.wfa30302.getText().toString());
        MainApp.formsWF.setWfa30303(bi.wfa30303.getText().toString().trim().isEmpty() ? "-1" : bi.wfa30303.getText().toString());

        MainApp.formsWF.setWfa304(bi.wfa30401.isChecked() ? "1"
                : bi.wfa30402.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa305(bi.wfa305.getText().toString().trim().isEmpty() ? "-1" : bi.wfa305.getText().toString());

        MainApp.formsWF.setWfa30601(bi.wfa30601.getText().toString().trim().isEmpty() ? "-1" : bi.wfa30601.getText().toString());
        MainApp.formsWF.setWfa30602(bi.wfa30602.getText().toString().trim().isEmpty() ? "-1" : bi.wfa30602.getText().toString());
        MainApp.formsWF.setWfa30603(bi.wfa30603.getText().toString().trim().isEmpty() ? "-1" : bi.wfa30603.getText().toString());

        MainApp.formsWF.setWfa307(bi.wfa30701.isChecked() ? "1"
                : bi.wfa30702.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa308(bi.wfa308.getText().toString().trim().isEmpty() ? "-1" : bi.wfa308.getText().toString());

        MainApp.formsWF.setWfa30901(bi.wfa30901.getText().toString().trim().isEmpty() ? "-1" : bi.wfa30901.getText().toString());
        MainApp.formsWF.setWfa30902(bi.wfa30902.getText().toString().trim().isEmpty() ? "-1" : bi.wfa30902.getText().toString());

        MainApp.formsWF.setWfa310(bi.wfa31001.isChecked() ? "1"
                : bi.wfa31002.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa311(bi.wfa311.getText().toString().trim().isEmpty() ? "-1" : bi.wfa311.getText().toString());

        MainApp.formsWF.setWfa31201(bi.wfa31201.getText().toString().trim().isEmpty() ? "-1" : bi.wfa31201.getText().toString());
        MainApp.formsWF.setWfa31202(bi.wfa31202.getText().toString().trim().isEmpty() ? "-1" : bi.wfa31202.getText().toString());
        MainApp.formsWF.setWfa31203(bi.wfa31203.getText().toString().trim().isEmpty() ? "-1" : bi.wfa31203.getText().toString());

        MainApp.formsWF.setWfa313(bi.wfa31301.isChecked() ? "1"
                : bi.wfa31302.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa314(bi.wfa314.getText().toString().trim().isEmpty() ? "-1" : bi.wfa314.getText().toString());

        MainApp.formsWF.setWfa31501(bi.wfa31501.getText().toString().trim().isEmpty() ? "-1" : bi.wfa31501.getText().toString());
        MainApp.formsWF.setWfa31502(bi.wfa31502.getText().toString().trim().isEmpty() ? "-1" : bi.wfa31502.getText().toString());

        MainApp.formsWF.setWfa316(bi.wfa31601.isChecked() ? "1"
                : bi.wfa31602.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa317(bi.wfa317.getText().toString().trim().isEmpty() ? "-1" : bi.wfa317.getText().toString());

        MainApp.formsWF.setWfa318(bi.wfa318.getText().toString().trim().isEmpty() ? "-1" : bi.wfa318.getText().toString());

        MainApp.formsWF.setWfa319(bi.wfa31901.isChecked() ? "1"
                : bi.wfa31902.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa320(bi.wfa320.getText().toString().trim().isEmpty() ? "-1" : bi.wfa320.getText().toString());

        MainApp.formsWF.setWfa321(bi.wfa321.getText().toString().trim().isEmpty() ? "-1" : bi.wfa321.getText().toString());

        MainApp.formsWF.setWfa322(bi.wfa32201.isChecked() ? "1"
                : bi.wfa32202.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa32301(bi.wfa32301.getText().toString().trim().isEmpty() ? "-1" : bi.wfa32301.getText().toString());
        MainApp.formsWF.setWfa32302(bi.wfa32302.getText().toString().trim().isEmpty() ? "-1" : bi.wfa32302.getText().toString());
        MainApp.formsWF.setWfa32303(bi.wfa32303.getText().toString().trim().isEmpty() ? "-1" : bi.wfa32303.getText().toString());

        MainApp.formsWF.setWfa324(bi.wfa32401.isChecked() ? "1"
                : bi.wfa32402.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa325(bi.wfa325.getText().toString().trim().isEmpty() ? "-1" : bi.wfa325.getText().toString());

        MainApp.formsWF.setWfa32601(bi.wfa32601.getText().toString().trim().isEmpty() ? "-1" : bi.wfa32601.getText().toString());
        MainApp.formsWF.setWfa32602(bi.wfa32602.getText().toString().trim().isEmpty() ? "-1" : bi.wfa32602.getText().toString());

        MainApp.formsWF.setWfa327(bi.wfa32701.isChecked() ? "1"
                : bi.wfa32702.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa328(bi.wfa328.getText().toString().trim().isEmpty() ? "-1" : bi.wfa328.getText().toString());

        MainApp.formsWF.setWfa329(bi.wfa32901.isChecked() ? "1"
                : bi.wfa32902.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa330(bi.wfa33001.isChecked() ? "1"
                : bi.wfa33002.isChecked() ? "2"
                : bi.wfa33003.isChecked() ? "3"
                : "-1");

        MainApp.formsWF.setWfa331(bi.wfa331.getText().toString().trim().isEmpty() ? "-1" : bi.wfa331.getText().toString());

        MainApp.formsWF.setWfa33201(bi.wfa33201.getText().toString().trim().isEmpty() ? "-1" : bi.wfa33201.getText().toString());
        MainApp.formsWF.setWfa33202(bi.wfa33202.getText().toString().trim().isEmpty() ? "-1" : bi.wfa33202.getText().toString());

        MainApp.formsWF.setWfa333(bi.wfa33301.isChecked() ? "1"
                : bi.wfa33302.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa334(bi.wfa334.getText().toString().trim().isEmpty() ? "-1" : bi.wfa334.getText().toString());

        MainApp.formsWF.setWfa33501(bi.wfa33501.getText().toString().trim().isEmpty() ? "-1" : bi.wfa33501.getText().toString());
        MainApp.formsWF.setWfa33502(bi.wfa33502.getText().toString().trim().isEmpty() ? "-1" : bi.wfa33502.getText().toString());

        MainApp.formsWF.setWfa336(bi.wfa33601.isChecked() ? "1"
                : bi.wfa33602.isChecked() ? "2"
                : "-1");

        MainApp.formsWF.setWfa337(bi.wfa337.getText().toString().trim().isEmpty() ? "-1" : bi.wfa337.getText().toString());

        MainApp.formsWF.setWfa338(bi.wfa338.getText().toString().trim().isEmpty() ? "-1" : bi.wfa338.getText().toString());

        MainApp.formsWF.setWfa339(bi.wfa339.getText().toString().trim().isEmpty() ? "-1" : bi.wfa339.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}