package edu.aku.hassannaqvi.matiari_cohorts.ui.other

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.core.MainApp
import edu.aku.hassannaqvi.matiari_cohorts.core.MainApp.appInfo
import edu.aku.hassannaqvi.matiari_cohorts.databinding.ActivityEndingBinding
import java.text.SimpleDateFormat
import java.util.*

class EndingActivity : AppCompatActivity() {
    lateinit var bi: ActivityEndingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending)
        bi.callback = this

        val check = intent.getBooleanExtra("complete", false)
        if (check) {
            bi.a0601.isEnabled = true
            bi.a0602.isEnabled = false
            bi.a0603.isEnabled = false
            bi.a0604.isEnabled = false
            bi.a0696.isEnabled = false
        } else {
            bi.a0601.isEnabled = false
            bi.a0602.isEnabled = true
            bi.a0603.isEnabled = true
            bi.a0604.isEnabled = true
            bi.a0696.isEnabled = true
        }
    }

    fun BtnEnd() {
        if (!formValidation()) return
        saveDraft()
        if (updateDB()) {
            finish()
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveDraft() {
        val statusValue = if (bi.a0601.isChecked) "1" else if (bi.a0602.isChecked) "2" else if (bi.a0603.isChecked) "3" else if (bi.a0696.isChecked) "96" else "0"
        MainApp.forms.istatus = statusValue
        MainApp.forms.istatus96x = bi.a0696x.text.toString()
        MainApp.forms.endingdatetime = SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH).format(Date().time)
    }


    private fun updateDB(): Boolean {
        val db = appInfo.dbHelper
        val updcount = db.updateEnding()
        return if (updcount == 1) {
            true
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun formValidation(): Boolean {
        return Validator.emptyCheckingContainer(this, bi.fldGrpEnd)
    }

    override fun onBackPressed() {
        Toast.makeText(applicationContext, "You Can't go back", Toast.LENGTH_LONG).show()
    }
}