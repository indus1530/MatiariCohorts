package edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kennyc.view.MultiStateView
import edu.aku.hassannaqvi.matiari_cohorts.R
import kotlinx.android.synthetic.main.fragment_child_list.*
import kotlinx.coroutines.Runnable
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

/*
* @author Ali Azaz Alam dt. 12.18.20
* */
class ChildListFragment : Fragment(R.layout.fragment_child_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        * Show loading while data is fetching
        * */
        multiStateView.viewState = MultiStateView.ViewState.LOADING
        multiStateView.postDelayed(Runnable {
            //multiStateView.viewState = MultiStateView.ViewState.EMPTY
            val worker: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
            worker.schedule(Runnable {
                Toast.makeText(this.activity, "No Content", Toast.LENGTH_SHORT).show()
            }, 3500, TimeUnit.MILLISECONDS)
        }, 2000L)

    }
}