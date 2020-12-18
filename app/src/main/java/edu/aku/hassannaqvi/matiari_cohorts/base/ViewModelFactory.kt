package edu.aku.hassannaqvi.matiari_cohorts.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.aku.hassannaqvi.matiari_cohorts.repository.GeneralRepository
import edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.viewmodel.DashboardViewModel

/*
* @author Ali Azaz Alam dt. 12.18.20
* */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: GeneralRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DashboardViewModel::class.java) -> DashboardViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown viewModel class $modelClass")
        }
    }

    /* companion object {
         @Volatile
         private var instance: ViewModelFactory? = null

         fun getInstance() =
                 instance ?: synchronized(ViewModelFactory::class.java) {
                     instance ?: ViewModelFactory().also { instance = it }
                 }
     }*/
}