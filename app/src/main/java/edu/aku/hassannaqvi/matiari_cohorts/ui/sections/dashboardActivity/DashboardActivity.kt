package edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.core.DatabaseHelper
import edu.aku.hassannaqvi.matiari_cohorts.extension.obtainViewModel
import edu.aku.hassannaqvi.matiari_cohorts.repository.GeneralRepository
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.fragments.ChildListFragment
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.fragments.SelectionFragment
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.viewmodel.DashboardViewModel

class DashboardActivity : AppCompatActivity() {

    lateinit var viewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        viewModel = obtainViewModel(DashboardViewModel::class.java, GeneralRepository(DatabaseHelper(this)))

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<SelectionFragment>(R.id.fragment_container_selection)
                add<ChildListFragment>(R.id.fragment_container_childlist)
            }
        }


    }
}