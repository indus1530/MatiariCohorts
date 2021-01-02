package edu.aku.hassannaqvi.matiari_cohorts.ui.other.mainActivity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.core.AndroidDatabaseManager
import edu.aku.hassannaqvi.matiari_cohorts.core.DatabaseHelper
import edu.aku.hassannaqvi.matiari_cohorts.databinding.ActivityMainBinding
import edu.aku.hassannaqvi.matiari_cohorts.repository.GeneralRepository
import edu.aku.hassannaqvi.matiari_cohorts.repository.ResponseStatus
import edu.aku.hassannaqvi.matiari_cohorts.ui.other.SyncActivity
import edu.aku.hassannaqvi.matiari_cohorts.ui.other.loginActivity.LoginActivity
import edu.aku.hassannaqvi.matiari_cohorts.ui.other.loginActivity.viewmodel.LoginViewModel
import edu.aku.hassannaqvi.matiari_cohorts.ui.other.mainActivity.viewmodel.MainViewModel
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.DashboardActivity
import edu.aku.hassannaqvi.matiari_cohorts.utils.extension.gotoActivity
import edu.aku.hassannaqvi.matiari_cohorts.utils.extension.gotoActivityWithNoHistory
import edu.aku.hassannaqvi.matiari_cohorts.utils.extension.obtainViewModel
import edu.aku.hassannaqvi.matiari_cohorts.utils.isGPSEnabled
import edu.aku.hassannaqvi.matiari_cohorts.utils.isNetworkConnected
import edu.aku.hassannaqvi.matiari_cohorts.utils.showGPSAlert
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var bi: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private var exit = false
    private var sysdateToday = SimpleDateFormat("dd-MM-yy", Locale.ENGLISH).format(Date())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bi.callback = this
        viewModel = obtainViewModel(MainViewModel::class.java, GeneralRepository(DatabaseHelper(this)))

        /*
        * Get Today's form DB
        * If it's null then return 0 otherwise return count
        * Show loading while data is fetching
        * */
        viewModel.todayForms.observe(this, {
            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    Log.d("Today's form count:", it.data.toString())
                }
                ResponseStatus.ERROR -> {
                }
                ResponseStatus.LOADING -> {
                }
            }
        })

        /*
        * Get Today's form DB
        * If it's null then return 0 otherwise return count
        * Show loading while data is fetching
        * */
        viewModel.formsStatus.observe(this, {
            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    it.data?.let { item ->
                        Log.d("Complete count:", item.closedForms.toString())
                        Log.d("In-complete count:", item.openedForms.toString())
                    }

                }
                ResponseStatus.ERROR -> {
                }
                ResponseStatus.LOADING -> {
                }
            }
        })

        /*
        * Get Today's form DB
        * If it's null then return 0 otherwise return count
        * Show loading while data is fetching
        * */
        viewModel.uploadForms.observe(this, {
            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    it.data?.let { item ->
                        Log.d("Synced count:", item.closedForms.toString())
                        Log.d("Un-Synced count:", item.openedForms.toString())
                    }
                }
                ResponseStatus.ERROR -> {
                }
                ResponseStatus.LOADING -> {
                }
            }
        })
    }

    /*
    * Back press button that will route to login activity after pressing -
    * back button two times
    * */
    override fun onBackPressed() {
        if (exit) {
            gotoActivityWithNoHistory(LoginActivity::class.java)
        } else {
            Toast.makeText(this, "Press back again to exit",
                    Toast.LENGTH_SHORT).show()
            exit = true
            Handler(Looper.getMainLooper()).postDelayed({ exit = false }, 3000)
        }
    }

    /*
    * Inflate menu on current activity
    * */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return true
    }

    /*
    * Menu items selection
    * */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.onSync -> {
                gotoActivity(SyncActivity::class.java)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*
    * Route to specific activity according to selection
    * For uploading/downloading data, the network needs to work
    * */
    fun openSpecificActivity(v: View) {
        when (v.id) {
            R.id.formA -> {
                if (isGPSEnabled(this)) gotoActivity(DashboardActivity::class.java)
                else showGPSAlert(this)
            }
            R.id.databaseBtn -> gotoActivity(AndroidDatabaseManager::class.java)
            R.id.uploadData -> {
                if (!isNetworkConnected(this)) {
                    Toast.makeText(this, "Network connection not available!", Toast.LENGTH_SHORT).show()
                    return
                }
                gotoActivity(SyncActivity::class.java)
            }
        }
    }
}