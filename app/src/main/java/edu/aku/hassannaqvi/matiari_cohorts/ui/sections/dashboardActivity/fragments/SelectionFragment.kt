package edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.core.DatabaseHelper
import edu.aku.hassannaqvi.matiari_cohorts.extension.obtainViewModel
import edu.aku.hassannaqvi.matiari_cohorts.repository.GeneralRepository
import edu.aku.hassannaqvi.matiari_cohorts.repository.ResponseStatus
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_selection.*

/*
* @author Ali Azaz Alam dt. 12.17.20
* */
class SelectionFragment : Fragment(R.layout.fragment_selection) {

    lateinit var viewModel: DashboardViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = obtainViewModel(DashboardViewModel::class.java, GeneralRepository(DatabaseHelper(activity)))
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinnerUC.adapter = this.activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, mutableListOf("....")) }
        spinnerVillage.adapter = this.activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, mutableListOf("....")) }
        viewModel.getVillageDataFromDB()
        viewModel.villageResponse.observe(viewLifecycleOwner, Observer {
            it?.let {
                when (it.status) {
                    ResponseStatus.SUCCESS -> {
                        Toast.makeText(view.context, it.message, Toast.LENGTH_SHORT).show()
                    }
                    ResponseStatus.ERROR -> {
                        Toast.makeText(view.context, it.message, Toast.LENGTH_SHORT).show()
                    }
                    ResponseStatus.LOADING -> {

                    }
                }
            }
        })

    }
}