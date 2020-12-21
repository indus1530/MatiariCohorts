package edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.kennyc.view.MultiStateView
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.adapter.ChildListAdapter
import edu.aku.hassannaqvi.matiari_cohorts.core.DatabaseHelper
import edu.aku.hassannaqvi.matiari_cohorts.extension.obtainViewModel
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel
import edu.aku.hassannaqvi.matiari_cohorts.models.VillageModel
import edu.aku.hassannaqvi.matiari_cohorts.repository.GeneralRepository
import edu.aku.hassannaqvi.matiari_cohorts.repository.ResponseStatus
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.DashboardActivity
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.viewmodel.DashboardViewModel
import edu.aku.hassannaqvi.matiari_cohorts.utils.openWarningFragment
import kotlinx.android.synthetic.main.fragment_child_list.*
import java.util.*

/*
* @author Ali Azaz Alam dt. 12.18.20
* @update Ali Azaz Alam dt. 12.19.20
* */
class ChildListFragment : Fragment(R.layout.fragment_child_list) {

    lateinit var viewModel: DashboardViewModel
    lateinit var adapter: ChildListAdapter
    var villageData: VillageModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /*
        * Obtaining ViewModel
        * */
        viewModel = obtainViewModel(activity as DashboardActivity, DashboardViewModel::class.java, GeneralRepository(DatabaseHelper(activity)))
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callingRecyclerView()

        /*
        * Show Error text when no data is selected
        * */
        multiStateView.viewState = MultiStateView.ViewState.ERROR

        /*
        * Fetch flag that defines village exist and it's processing child list
        * */
        viewModel.villageDataProcessResponse.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    multiStateView.viewState = MultiStateView.ViewState.CONTENT
                }
                ResponseStatus.ERROR -> multiStateView.viewState = MultiStateView.ViewState.ERROR
                ResponseStatus.LOADING -> {
                    multiStateView.viewState = MultiStateView.ViewState.LOADING
                    villageData = it.data as VillageModel
                }
            }
        })

        /*
        * Fetch child list
        * */
        viewModel.childResponse.observe(viewLifecycleOwner, Observer {
            it?.let {
                when (it.status) {
                    ResponseStatus.SUCCESS -> {
                        adapter.childItems = it.data as ArrayList<ChildModel>
                        viewModel.progressVillageAlert(false)
                    }
                    ResponseStatus.ERROR -> {
                        multiStateView.viewState = MultiStateView.ViewState.EMPTY
                    }
                    ResponseStatus.LOADING -> {
                    }
                }
            }
        })
    }

    /*
    * Initialize recyclerView with onClickListener
    * */
    private fun callingRecyclerView() {
        adapter = ChildListAdapter(object : ChildListAdapter.OnItemClickListener {
            override fun onItemClick(item: ChildModel, position: Int) {
                villageData?.let {
                    item.village = villageData!!.village
                    item.uc = villageData!!.uc
                }
                openWarningFragment(
                        activity as DashboardActivity,
                        title = "CONFIRMATION!",
                        message = "Are you sure, you want to continue ${item.childName.toUpperCase(Locale.ENGLISH)} interview?",
                        data = item)
            }
        })
        childList.adapter = adapter
    }

}