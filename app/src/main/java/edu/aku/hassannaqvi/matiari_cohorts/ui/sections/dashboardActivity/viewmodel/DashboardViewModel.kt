package edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel
import edu.aku.hassannaqvi.matiari_cohorts.models.VillageModel
import edu.aku.hassannaqvi.matiari_cohorts.repository.GeneralRepository
import edu.aku.hassannaqvi.matiari_cohorts.repository.ResponseStatusCallbacks
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: GeneralRepository) : ViewModel() {

    private val _villageResponse: MutableLiveData<ResponseStatusCallbacks<List<VillageModel>>> = MutableLiveData()
    private val _childResponse: MutableLiveData<ResponseStatusCallbacks<List<ChildModel>>> = MutableLiveData()

    val villageResponse: MutableLiveData<ResponseStatusCallbacks<List<VillageModel>>>
        get() = _villageResponse

    val childResponse: MutableLiveData<ResponseStatusCallbacks<List<ChildModel>>>
        get() = _childResponse


    fun getVillageDataFromDB() {
        _villageResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                _villageResponse.value =
                        ResponseStatusCallbacks.success(repository.getVillages(), "Villages found")
            } catch (e: Exception) {
                _villageResponse.value =
                        ResponseStatusCallbacks.error(data = null, message = "No village found!")
            }

        }

    }

    fun getChildDataFromDB(vCode: String) {
        _childResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                _childResponse.value =
                        ResponseStatusCallbacks.success(data = repository.getChildListByVillage(vCode), message = "Child list found")
            } catch (e: Exception) {
                _childResponse.value =
                        ResponseStatusCallbacks.error(data = null, message = "No child found!")
            }

        }

    }


}