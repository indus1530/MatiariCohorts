package edu.aku.hassannaqvi.matiari_cohorts.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel
import edu.aku.hassannaqvi.matiari_cohorts.models.VillageModel
import edu.aku.hassannaqvi.matiari_cohorts.base.repository.GeneralDataSource
import edu.aku.hassannaqvi.matiari_cohorts.base.repository.ProgressResponseStatusCallbacks
import edu.aku.hassannaqvi.matiari_cohorts.base.repository.ResponseStatusCallbacks
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: GeneralDataSource) : ViewModel() {

    private val _villageResponse: MutableLiveData<ResponseStatusCallbacks<List<VillageModel>>> = MutableLiveData()
    private val _childResponse: MutableLiveData<ResponseStatusCallbacks<List<ChildModel>>> = MutableLiveData()

    val villageDataProcessResponse: MutableLiveData<ProgressResponseStatusCallbacks<Any>> = MutableLiveData(
            ProgressResponseStatusCallbacks.error()
    )

    val villageResponse: MutableLiveData<ResponseStatusCallbacks<List<VillageModel>>>
        get() = _villageResponse

    val childResponse: MutableLiveData<ResponseStatusCallbacks<List<ChildModel>>>
        get() = _childResponse

    init {
        /*
        * Load village data when viewmodel connected
        * */
        getVillageDataFromDB()
    }

    private fun getVillageDataFromDB() {
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
                        ResponseStatusCallbacks.error(data = null, message = e.message.toString())
            }

        }

    }

    fun progressVillageAlert(boolean: Boolean? = null, data: Any? = null) {
        villageDataProcessResponse.value = boolean?.run { if (boolean) ProgressResponseStatusCallbacks.loading(data) else ProgressResponseStatusCallbacks.success() }
                ?: ProgressResponseStatusCallbacks.error()
    }

    fun getChildDataFromDB(vCode: String) {
        _childResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                delay(1000)
                val children = repository.getChildListByVillage(vCode)
                _childResponse.value = if (children.size > 0) {
                    val childList = ArrayList<ChildModel>(children.sortedBy { it.formFlag })
                    ResponseStatusCallbacks.success(data = childList, message = "Child list found")
                } else
                    ResponseStatusCallbacks.error(data = null, message = "No child found!")
            } catch (e: Exception) {
                _childResponse.value =
                        ResponseStatusCallbacks.error(data = null, message = e.message.toString())
            }

        }

    }


}