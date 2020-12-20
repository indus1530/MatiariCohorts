package edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.add
import androidx.fragment.app.commit
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.adapter.ChildListAdapter
import edu.aku.hassannaqvi.matiari_cohorts.databinding.ActivityDashboardBinding
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.fragments.ChildListFragment
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.fragments.SelectionFragment

class DashboardActivity : AppCompatActivity() {

    lateinit var adapter: ChildListAdapter
    lateinit var bi: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bi = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<SelectionFragment>(R.id.fragment_container_selection)
                add<ChildListFragment>(R.id.fragment_container_childlist)
            }
        }

    }
}