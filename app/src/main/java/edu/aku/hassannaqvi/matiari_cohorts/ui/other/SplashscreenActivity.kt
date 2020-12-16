package edu.aku.hassannaqvi.matiari_cohorts.ui.other

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import edu.aku.hassannaqvi.matiari_cohorts.R
import kotlinx.coroutines.*

/*
* @author Ali Azaz Alam dt. 12.16.20
* */
class SplashscreenActivity : Activity() {
    private lateinit var activityScope: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        activityScope = launchSplashScope()
    }

    override fun onPause() {
        super.onPause()
        activityScope.cancel()
    }

    override fun onResume() {
        super.onResume()
        if (activityScope.isActive.not())
            launchSplashScope()
    }

    private fun launchSplashScope() =
            CoroutineScope(Dispatchers.Main).launch {
                delay(SPLASH_TIME_OUT.toLong())
                finish()
                startActivity(Intent(this@SplashscreenActivity, LoginActivity::class.java))
            }

    companion object {
        private const val SPLASH_TIME_OUT = 1000
    }
}