package edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.fragments

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import edu.aku.hassannaqvi.matiari_cohorts.R
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment(R.layout.fragment_selection) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinnerUC.adapter = this.activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, mutableListOf("....")) }
        spinnerVillage.adapter = this.activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, mutableListOf("....")) }

    }
}