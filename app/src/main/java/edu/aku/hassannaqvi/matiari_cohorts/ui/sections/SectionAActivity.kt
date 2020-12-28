package edu.aku.hassannaqvi.matiari_cohorts.ui.sections

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Clear
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.matiari_cohorts.CONSTANTS
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.contracts.FormsContract
import edu.aku.hassannaqvi.matiari_cohorts.core.MainApp
import edu.aku.hassannaqvi.matiari_cohorts.databinding.ActivitySectionABinding
import edu.aku.hassannaqvi.matiari_cohorts.extension.gotoActivity
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel
import edu.aku.hassannaqvi.matiari_cohorts.models.Forms
import edu.aku.hassannaqvi.matiari_cohorts.ui.other.EndingActivity
import edu.aku.hassannaqvi.matiari_cohorts.utils.CustomExceptions
import edu.aku.hassannaqvi.matiari_cohorts.utils.EndSectionActivity
import edu.aku.hassannaqvi.matiari_cohorts.utils.contextEndActivity
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*

class SectionAActivity : AppCompatActivity(), EndSectionActivity {

    private val TAG: String = SectionAActivity::class.java.name
    lateinit var bi: ActivitySectionABinding
    lateinit var scope: CoroutineScope
    private val child: ChildModel by lazy {
        intent.getSerializableExtra(CONSTANTS.CHILD_DATA) as ChildModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a)
        bi.callback = this
        setupSkips()
        bi.form = child
        bi.mc14.check(if (child.gender == "Male") bi.mc1401.id else bi.mc1402.id)
        scope = CoroutineScope(Job() + Dispatchers.Main + CoroutineExceptionHandler { _, exception ->
            Log.e(TAG, exception.message.toString())
        })
    }


    fun BtnContinue() {
        initializeCoroutine()
        scope.launch {
            launch {
                if (!formValidation()) throw CustomExceptions("Not validate form")
                val saveJob = launch { saveDraft() }
                saveJob.join()
                launch(Dispatchers.IO) {
                    if (!updateDB()) throw CustomExceptions("Update db error")
                    finish()
                    startActivity(Intent(this@SectionAActivity, EndingActivity::class.java).putExtra("complete", true))
                }
            }
        }

    }

    fun BtnEnd() {
        initializeCoroutine()
        contextEndActivity(this)
    }


    private fun setupSkips() {
        bi.mc15.setOnCheckedChangeListener { group: RadioGroup?, checkedId: Int ->
            if (checkedId == bi.mc1501.id) {
                Clear.clearAllFields(bi.fldGrpCVmc16)
                Clear.clearAllFields(bi.fldGrpCVmc18)
            } else if (checkedId == bi.mc1502.id) {
                Clear.clearAllFields(bi.fldGrpCVmc17)
                Clear.clearAllFields(bi.fldGrpCVmc19)
                Clear.clearAllFields(bi.fldGrpCVmc20)
                Clear.clearAllFields(bi.fldGrpCVmc21)
                Clear.clearAllFields(bi.fldGrpCVmc22)
                Clear.clearAllFields(bi.fldGrpCVmc23)
                Clear.clearAllFields(bi.fldGrpCVmc24)
                Clear.clearAllFields(bi.fldGrpCVmc25)
            }
        }
        bi.mc17.setOnCheckedChangeListener { group: RadioGroup?, checkedId: Int ->
            if (checkedId == bi.mc1701.id) {
                Clear.clearAllFields(bi.fldGrpCVmc18)
            } else if (checkedId == bi.mc1702.id) {
                Clear.clearAllFields(bi.fldGrpCVmc19)
                Clear.clearAllFields(bi.fldGrpCVmc20)
                Clear.clearAllFields(bi.fldGrpCVmc21)
                Clear.clearAllFields(bi.fldGrpCVmc22)
            }
        }
        bi.mc19.setOnCheckedChangeListener { group: RadioGroup?, checkedId: Int ->
            if (checkedId == bi.mc1901.id) {
                Clear.clearAllFields(bi.fldGrpCVmc20)
                Clear.clearAllFields(bi.fldGrpCVmc21)
            } else if (checkedId == bi.mc1902.id) {
                Clear.clearAllFields(bi.fldGrpCVmc22)
            }
        }
    }

    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addForm(MainApp.forms)
        MainApp.forms._ID = updcount.toString()
        return if (updcount > 0) {
            MainApp.forms._UID = MainApp.forms.deviceID + MainApp.forms._ID
            db.updatesFormsColumn(FormsContract.FormsTable.COLUMN_UID, MainApp.forms._UID)
            db.updatesFormsColumn(FormsContract.FormsTable.COLUMN_SA, MainApp.forms.sAtoString())
            true
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun saveDraft() {
        MainApp.forms = Forms()
        MainApp.forms.sysdate = SimpleDateFormat("dd-MM-yy HH:mm", Locale.getDefault()).format(Date().time)
        MainApp.forms.deviceID = MainApp.appInfo.deviceID
        MainApp.forms.devicetagID = MainApp.appInfo.tagName
        MainApp.forms.appversion = MainApp.appInfo.appVersion
        MainApp.forms.username = MainApp.userName
        MainApp.forms.child_id = child.childId
        MainApp.forms.village_code = child.villageCode
        MainApp.forms.setHhhead(child.hhHead)
        MainApp.forms.setEproject(child.project)
        setGPS(this)
        MainApp.forms.setMc01(if (bi.mc01.text.toString().trim().isEmpty()) "-1" else bi.mc01.text.toString())
        MainApp.forms.setMc02(if (bi.mc02.text.toString().trim().isEmpty()) "-1" else bi.mc02.text.toString())
        MainApp.forms.setMc03(if (bi.mc03.text.toString().trim().isEmpty()) "-1" else bi.mc03.text.toString())
//        forms.setMc04(bi.mc04.getText().toString().trim().isEmpty() ? "-1" : bi.mc04.getText().toString());
//        forms.setMc05(bi.mc05.getText().toString().trim().isEmpty() ? "-1" : bi.mc05.getText().toString());
        MainApp.forms.setMc06(if (bi.mc06.text.toString().trim().isEmpty()) "-1" else bi.mc06.text.toString())
        MainApp.forms.setMc07(if (bi.mc07.text.toString().trim().isEmpty()) "-1" else bi.mc07.text.toString())
        MainApp.forms.setMc08(if (bi.mc08.text.toString().trim().isEmpty()) "-1" else bi.mc08.text.toString())
        MainApp.forms.setMc09(if (bi.mc09.text.toString().trim().isEmpty()) "-1" else bi.mc09.text.toString())
        MainApp.forms.setMc10(if (bi.mc10.text.toString().trim().isEmpty()) "-1" else bi.mc10.text.toString())
        MainApp.forms.setMc11(if (bi.mc11.text.toString().trim().isEmpty()) "-1" else bi.mc11.text.toString())
        MainApp.forms.setMc12(if (bi.mc12.text.toString().trim().isEmpty()) "-1" else bi.mc12.text.toString())
        MainApp.forms.setMc1301(if (bi.mc1301.text.toString().trim().isEmpty()) "-1" else bi.mc1301.text.toString())
        MainApp.forms.setMc1302(if (bi.mc1302.text.toString().trim().isEmpty()) "-1" else bi.mc1302.text.toString())
        MainApp.forms.setMc14(if (bi.mc1401.isChecked) "1" else if (bi.mc1402.isChecked) "2" else "-1")
        MainApp.forms.setMc15(if (bi.mc1501.isChecked) "1" else if (bi.mc1502.isChecked) "2" else "-1")
        MainApp.forms.setMc16(if (bi.mc16.text.toString().trim().isEmpty()) "-1" else bi.mc16.text.toString())
        MainApp.forms.setMc17(if (bi.mc1701.isChecked) "1" else if (bi.mc1702.isChecked) "2" else "-1")
        MainApp.forms.setMc18(if (bi.mc1801.isChecked) "1" else if (bi.mc1802.isChecked) "2" else if (bi.mc1898.isChecked) "98" else "-1")
        MainApp.forms.setMc1898x(if (bi.mc1898x.text.toString().trim().isEmpty()) "-1" else bi.mc1898x.text.toString())
        MainApp.forms.setMc19(if (bi.mc1901.isChecked) "1" else if (bi.mc1902.isChecked) "2" else "-1")
        MainApp.forms.setMc2001(if (bi.mc2001.text.toString().trim().isEmpty()) "-1" else bi.mc2001.text.toString())
        MainApp.forms.setMc2002(if (bi.mc2002.text.toString().trim().isEmpty()) "-1" else bi.mc2002.text.toString())
        MainApp.forms.setMc21(bi.mc21.text.toString())
        MainApp.forms.setMc22(if (bi.mc2201.isChecked) "1" else if (bi.mc2202.isChecked) "2" else "-1")
        MainApp.forms.setMc23(if (bi.mc23.text.toString().trim().isEmpty()) "-1" else bi.mc23.text.toString())
        MainApp.forms.setMc24(if (bi.mc24.text.toString().trim().isEmpty()) "-1" else bi.mc24.text.toString())
        MainApp.forms.setMc25(if (bi.mc2501.isChecked) "1" else if (bi.mc2502.isChecked) "2" else if (bi.mc2503.isChecked) "3" else if (bi.mc2504.isChecked) "4" else if (bi.mc2505.isChecked) "5" else if (bi.mc2506.isChecked) "6" else "-1")
//        forms.setMc26(bi.mc26.getText().toString().trim().isEmpty() ? "-1" : bi.mc26.getText().toString());
        MainApp.forms.setMcrem(if (bi.mcrem.text.toString().trim().isEmpty()) "-1" else bi.mcrem.text.toString())
        setGPS(this)
    }

    private fun formValidation(): Boolean {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) return false
        if (bi.mc1301.text.toString().toInt() == 0 && bi.mc1302.text.toString().toInt() == 0) {
            Toast.makeText(this, "Year and Month both can't be zero", Toast.LENGTH_SHORT).show()
            bi.mc1301.error = "Year and Month both can't be zero"
            return false
        }
        if (bi.fldGrpCVmc20.isVisible) {
            if (bi.mc2001.text.toString().toInt() == 0 && bi.mc2002.text.toString().toInt() == 0) {
                Toast.makeText(this, "Year and Month both can't be zero", Toast.LENGTH_SHORT).show()
                bi.mc2001.error = "Year and Month both can't be zero"
                return false
            }
        }
        return true
    }

    private fun setGPS(activity: Activity) {
        val gpsPref = activity.getSharedPreferences("GPSCoordinates", MODE_PRIVATE)
        try {
            val lat = gpsPref.getString("Latitude", "0")
            val lang = gpsPref.getString("Longitude", "0")
            val acc = gpsPref.getString("Accuracy", "0")
            val dt = gpsPref.getString("Time", "0")
            if (lat == "0" && lang == "0") {
                Toast.makeText(activity, "Could not obtained GPS points", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "GPS set", Toast.LENGTH_SHORT).show()
            }
            val date = DateFormat.format("dd-MM-yyyy HH:mm", gpsPref.getString("Time", "0")!!.toLong()).toString()
            MainApp.forms.gpsLat = gpsPref.getString("Latitude", "0")
            MainApp.forms.gpsLng = gpsPref.getString("Longitude", "0")
            MainApp.forms.gpsAcc = gpsPref.getString("Accuracy", "0")
            //            MainApp.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            MainApp.forms.gpsDT = date // Timestamp is converted to date above
        } catch (e: Exception) {
            Log.e("GPS", "setGPS: " + e.message)
        }
    }

    private fun initializeCoroutine() {
        if (scope.isActive.not())
            scope = CoroutineScope(Job() + Dispatchers.Main + CoroutineExceptionHandler { _, exception ->
                Log.e(TAG, exception.message.toString())
            })
    }


    override fun endSecActivity(flag: Boolean) {
        scope.launch {
            val saveJob = launch { saveDraft() }
            saveJob.join()
            launch(Dispatchers.IO) {
                if (!updateDB()) throw CustomExceptions("Update db error")
                finish()
                gotoActivity(EndingActivity::class.java)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        scope.cancel()
    }
}