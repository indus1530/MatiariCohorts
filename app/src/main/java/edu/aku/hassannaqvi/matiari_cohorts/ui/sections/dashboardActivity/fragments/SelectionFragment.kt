package edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.core.DatabaseHelper
import edu.aku.hassannaqvi.matiari_cohorts.extension.obtainViewModel
import edu.aku.hassannaqvi.matiari_cohorts.models.VillageModel
import edu.aku.hassannaqvi.matiari_cohorts.repository.GeneralRepository
import edu.aku.hassannaqvi.matiari_cohorts.repository.ResponseStatus
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.DashboardActivity
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_selection.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

/*
* @author Ali Azaz Alam dt. 12.17.20
* @update Ali Azaz Alam dt. 12.19.20
* */
class SelectionFragment : Fragment(R.layout.fragment_selection) {

    lateinit var viewModel: DashboardViewModel
    lateinit var ucAdapter: ArrayAdapter<String>
    lateinit var villageAdapter: ArrayAdapter<String>
    var uc = mutableListOf("....")
    var village = mutableListOf("....")
    var ucMap: MutableMap<String, Pair<String, VillageModel>> = mutableMapOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /*
        * Obtaining ViewModel
        * */
        viewModel = obtainViewModel(activity as DashboardActivity, DashboardViewModel::class.java, GeneralRepository(DatabaseHelper(activity)))
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        * Setting Adapters
        * */
        ucAdapter = ArrayAdapter(view.context, android.R.layout.simple_spinner_dropdown_item, uc)
        spinnerUC.adapter = ucAdapter
        villageAdapter = ArrayAdapter(view.context, android.R.layout.simple_spinner_dropdown_item, village)
        spinnerVillage.adapter = villageAdapter

        /*
        * Calling viewmodel village data function
        * Fetch village result response
        * */
        viewModel.getVillageDataFromDB()
        viewModel.villageResponse.observe(viewLifecycleOwner, Observer {
            it?.let {
                when (it.status) {
                    ResponseStatus.SUCCESS -> {
                        lifecycleScope.launch {
                            populateSpinnersData(it.data as ArrayList<VillageModel>)
                        }
                    }
                    ResponseStatus.ERROR -> {
                        lifecycleScope.launch {
                            delay(3000)
                            activity?.finish()
                        }
                    }
                    ResponseStatus.LOADING -> {
                    }
                }
            }
        })
        setupListener()
    }


    /*
    * Setup Listeners
    * */
    private fun setupListener() {

        spinnerUC.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinnerVillage.setSelection(0)
                if (position == 0) {
                    spinnerVillage.isEnabled = false
                    return
                }
                spinnerVillage.isEnabled = true
                village.clear()
                village.add("....")
                ucMap.forEach { (k, v) ->
                    if (v.first == spinnerUC.selectedItem.toString()) village.add(v.second.village)
                }
                villageAdapter.notifyDataSetChanged()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinnerVillage.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                if (position == 0) return
                lifecycleScope.launch {
                    withContext(Dispatchers.Main) {
                        var ucKey = ""
                        ucMap.forEach { (k, v) ->
                            if (v.first == spinnerUC.selectedItem.toString() && v.second.village == spinnerVillage.selectedItem.toString()) {
                                ucKey = k
                                return@forEach
                            }
                        }
                        viewModel.progressVillageAlert(true, ucMap.get(ucKey)?.second)
                        viewModel.getChildDataFromDB(ucKey)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }

    /*
    * Suspend function for populating UC and Village response
    * */
    private suspend fun populateSpinnersData(villages: ArrayList<VillageModel>) {
        withContext(Dispatchers.Main) {
            val splitLst: MutableMap<String, VillageModel> = mutableMapOf()
            villages.forEach { item ->
                splitLst[item.villageCode] = item
            }
            if (splitLst.isNotEmpty()) {
                splitLst.entries.forEach { item ->
                    if (!uc.contains(item.value.uc)) {
                        uc.add(item.value.uc)
                    }
                    villages.find { it.villageCode == item.key }?.let { ucMap[item.key] = Pair(item.value.uc, it) }
                }
                ucAdapter.notifyDataSetChanged()
            }
        }
    }

}