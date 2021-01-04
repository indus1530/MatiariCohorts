package edu.aku.hassannaqvi.matiari_cohorts.ui.other.mainActivity.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.aku.hassannaqvi.matiari_cohorts.models.FormIndicatorsModel
import edu.aku.hassannaqvi.matiari_cohorts.repository.GeneralRepository
import edu.aku.hassannaqvi.matiari_cohorts.repository.ResponseStatusCallbacks
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel(val repository: GeneralRepository) : ViewModel() {

    /*
    * Today's form
    * */
    private var _tf: MutableLiveData<ResponseStatusCallbacks<Int>> = MutableLiveData()
    val todayForms: MutableLiveData<ResponseStatusCallbacks<Int>>
        get() = _tf

    /*
    * Unsynced and Synced Forms as upload forms
    * */
    private var _uf: MutableLiveData<ResponseStatusCallbacks<FormIndicatorsModel>> = MutableLiveData()
    val uploadForms: MutableLiveData<ResponseStatusCallbacks<FormIndicatorsModel>>
        get() = _uf

    /*
    * Complete and Incomplete forms as status forms
    * */
    private var _fs: MutableLiveData<ResponseStatusCallbacks<FormIndicatorsModel>> = MutableLiveData()
    val formsStatus: MutableLiveData<ResponseStatusCallbacks<FormIndicatorsModel>>
        get() = _fs


     fun getTodayForms(date: String) {
        _tf.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                delay(1000L)
                val todayData = repository.getFormsByDate(date)
                _tf.value = ResponseStatusCallbacks.success(data = todayData.size, message = "Forms exist")
            } catch (e: Exception) {
                _tf.value = ResponseStatusCallbacks.error(null, e.message.toString())
            }
        }
    }


    fun getUploadFormsStatus() {
        _uf.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                delay(1000L)
                val todayData = repository.getUploadStatus()
                _uf.value = ResponseStatusCallbacks.success(data = todayData, message = "Upload status exist")
            } catch (e: Exception) {
                _uf.value = ResponseStatusCallbacks.error(null, e.message.toString())
            }
        }
    }


    fun getFormsStatus(date: String) {
        _fs.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                delay(1000L)
                val todayData = repository.getFormStatus(date)
                _fs.value = ResponseStatusCallbacks.success(data = todayData, message = "Form status exist")
            } catch (e: Exception) {
                _fs.value = ResponseStatusCallbacks.error(null, e.message.toString())
            }
        }
    }

}