package edu.aku.hassannaqvi.matiari_cohorts.ui.other.main_activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
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
import androidx.lifecycle.lifecycleScope
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.core.AndroidDatabaseManager
import edu.aku.hassannaqvi.matiari_cohorts.core.DatabaseHelper
import edu.aku.hassannaqvi.matiari_cohorts.core.MainApp
import edu.aku.hassannaqvi.matiari_cohorts.databinding.ActivityMainBinding
import edu.aku.hassannaqvi.matiari_cohorts.base.repository.GeneralRepository
import edu.aku.hassannaqvi.matiari_cohorts.base.repository.ResponseStatus
import edu.aku.hassannaqvi.matiari_cohorts.ui.other.SyncActivity
import edu.aku.hassannaqvi.matiari_cohorts.ui.other.login_activity.LoginActivity
import edu.aku.hassannaqvi.matiari_cohorts.base.viewmodel.MainViewModel
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboard_activity.DashboardActivity
import edu.aku.hassannaqvi.matiari_cohorts.utils.extension.gotoActivity
import edu.aku.hassannaqvi.matiari_cohorts.utils.extension.gotoActivityWithNoHistory
import edu.aku.hassannaqvi.matiari_cohorts.utils.extension.obtainViewModel
import edu.aku.hassannaqvi.matiari_cohorts.utils.isGPSEnabled
import edu.aku.hassannaqvi.matiari_cohorts.utils.isNetworkConnected
import edu.aku.hassannaqvi.matiari_cohorts.utils.showGPSAlert
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
        if (MainApp.admin) bi.adminSection.visibility = View.VISIBLE
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
                    bi.statisticLayout.tf.text = it.data.toString()
                }
                ResponseStatus.ERROR -> {
                }
                ResponseStatus.LOADING -> {
                    lifecycleScope.launch { delay(1000) }
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
                        bi.statisticLayout.cf.text = String.format("%02d", item.closedForms)
                        bi.statisticLayout.icf.text = String.format("%02d", item.openedForms)
                    }

                }
                ResponseStatus.ERROR -> {
                    animateFadeOut()
                }
                ResponseStatus.LOADING -> {
                    lifecycleScope.launch { delay(1000) }
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
                        bi.statisticLayout.sf.text = item.closedForms.toString()
                        bi.statisticLayout.usf.text = item.openedForms.toString()
                    }
                    animateFadeOut()
                }
                ResponseStatus.ERROR -> {
                    animateFadeOut()
                }
                ResponseStatus.LOADING -> {
                    lifecycleScope.launch { delay(1000) }
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
                if (isNetworkConnected(this)) {
                    gotoActivity(SyncActivity::class.java)
                } else
                    Toast.makeText(this, "Network connection not available!", Toast.LENGTH_SHORT).show()

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
        }
    }

    override fun onResume() {
        super.onResume()

        animateFadeIn()
        viewModel.getTodayForms(sysdateToday)
        viewModel.getUploadFormsStatus()
        viewModel.getFormsStatus(sysdateToday)
    }

    /*
    * Stop animation on statistic Layout
    * */
    private fun animateFadeOut() {
        val shortAnimationDuration = 2000
        /*
        * Animate the content view to 100% opacity, and clear any animation
        * listener set on the view.
        * */
        bi.statisticLayout.syncLinearLayout.animate()
                .alpha(1f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(null)
        bi.statisticLayout.statusLinearLayout.animate()
                .alpha(1f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(null)

        /* 
        * Animate the loading view to 0% opacity. After the animation ends, 
        * set its visibility to GONE as an optimization step (it won't participate 
        * in layout passes, etc.)
        * */

        bi.statisticLayout.loading.animate()
                .alpha(0f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        bi.statisticLayout.loading.visibility = View.GONE
                    }
                })
    }

    /*
    * Start animation on statistic Layout
    * */
    private fun animateFadeIn() {
        bi.statisticLayout.syncLinearLayout.alpha = 0f
        bi.statisticLayout.statusLinearLayout.alpha = 0f
        bi.statisticLayout.loading.alpha = 1f
        bi.statisticLayout.loading.visibility = View.VISIBLE
    }
}