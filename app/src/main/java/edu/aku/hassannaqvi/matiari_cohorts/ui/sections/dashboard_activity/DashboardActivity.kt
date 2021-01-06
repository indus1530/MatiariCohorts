package edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboard_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.add
import androidx.fragment.app.commit
import edu.aku.hassannaqvi.matiari_cohorts.CONSTANTS
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.adapter.ChildListAdapter
import edu.aku.hassannaqvi.matiari_cohorts.databinding.ActivityDashboardBinding
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.SectionAActivity
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboard_activity.fragments.ChildListFragment
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboard_activity.fragments.SelectionFragment
import edu.aku.hassannaqvi.matiari_cohorts.utils.WarningActivityInterface
import edu.aku.hassannaqvi.matiari_cohorts.utils.extension.gotoActivityWithSerializable

class DashboardActivity : AppCompatActivity(), WarningActivityInterface {

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

    override fun callWarningActivity(data: Any?) {
        gotoActivityWithSerializable(SectionAActivity::class.java, CONSTANTS.CHILD_DATA, data as ChildModel)
    }
}