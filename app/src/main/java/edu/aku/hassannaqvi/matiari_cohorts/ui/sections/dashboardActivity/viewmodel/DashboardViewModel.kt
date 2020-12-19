package edu.aku.hassannaqvi.matiari_cohorts.ui.sections.dashboardActivity.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel
import edu.aku.hassannaqvi.matiari_cohorts.models.VillageModel
import edu.aku.hassannaqvi.matiari_cohorts.repository.GeneralRepository
import edu.aku.hassannaqvi.matiari_cohorts.repository.ProgressResponseStatusCallbacks
import edu.aku.hassannaqvi.matiari_cohorts.repository.ResponseStatusCallbacks
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: GeneralRepository) : ViewModel() {

    private val _villageResponse: MutableLiveData<ResponseStatusCallbacks<List<VillageModel>>> = MutableLiveData()
    private val _childResponse: MutableLiveData<ResponseStatusCallbacks<List<ChildModel>>> = MutableLiveData()

    val childDataProcessResponse: MutableLiveData<ProgressResponseStatusCallbacks<Boolean>> = MutableLiveData(
            ProgressResponseStatusCallbacks.error()
    )

    val villageResponse: MutableLiveData<ResponseStatusCallbacks<List<VillageModel>>>
        get() = _villageResponse

    val childResponse: MutableLiveData<ResponseStatusCallbacks<List<ChildModel>>>
        get() = _childResponse


    fun getVillageDataFromDB() {
        _villageResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                val villages = repository.getVillages()
                _villageResponse.value = if (villages.size > 0)
                    ResponseStatusCallbacks.success(villages, "Villages found")
                else
                    ResponseStatusCallbacks.error(data = null, message = "No village found!")
            } catch (e: Exception) {
                _villageResponse.value =
                        ResponseStatusCallbacks.error(data = null, message = "Something wen't wrong while fetching village data!")
            }

        }

    }

    fun progressAlert(boolean: Boolean) {
        childDataProcessResponse.value = if (boolean) ProgressResponseStatusCallbacks.loading() else ProgressResponseStatusCallbacks.success()
    }

    fun getChildDataFromDB(vCode: String) {
        _childResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                delay(3000)
                val children = repository.getChildListByVillage(vCode)
                _childResponse.value = if (children.size > 0)
                    ResponseStatusCallbacks.success(data = children, message = "Child list found")
                else
                    ResponseStatusCallbacks.error(data = null, message = "No child found!")
            } catch (e: Exception) {
                _childResponse.value =
                        ResponseStatusCallbacks.error(data = null, message = e.message.toString())
            }

        }

    }


}