package edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.fragments

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.repository.ResponseStatus
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_selection.*

/*
* @author Ali Azaz Alam dt. 12.17.20
* */
class SelectionFragment : Fragment(R.layout.fragment_selection) {

    private val viewModel: DashboardViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinnerUC.adapter = this.activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, mutableListOf("....")) }
        spinnerVillage.adapter = this.activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, mutableListOf("....")) }

        viewModel.villageResponse.observe(viewLifecycleOwner, Observer {
            it?.let {
                when (it.status) {
                    ResponseStatus.SUCCESS -> {
                        Toast.makeText(this.context, it.message, Toast.LENGTH_SHORT).show()
                    }
                    ResponseStatus.ERROR -> {
                        Toast.makeText(this.context, it.message, Toast.LENGTH_SHORT).show()
                    }
                    ResponseStatus.LOADING -> {

                    }
                }
            }
        })

    }
}