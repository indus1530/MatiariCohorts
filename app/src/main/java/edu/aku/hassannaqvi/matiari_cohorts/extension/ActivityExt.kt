package edu.aku.hassannaqvi.matiari_cohorts.extension

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.aku.hassannaqvi.matiari_cohorts.base.ViewModelFactory
import edu.aku.hassannaqvi.matiari_cohorts.repository.GeneralRepository

/*
* @author Ali Azaz Alam dt. 12.18.20
* */
fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>, generalRepository: GeneralRepository) =
        ViewModelProvider(this, ViewModelFactory(generalRepository)).get(viewModelClass)

fun <T : ViewModel> Fragment.obtainViewModel(activity: AppCompatActivity, viewModelClass: Class<T>, generalRepository: GeneralRepository) =
        ViewModelProvider(activity, ViewModelFactory(generalRepository)).get(viewModelClass)

fun <T : AppCompatActivity> AppCompatActivity.gotoActivity(targetActivityClass: Class<T>) {
    val intent = Intent(this, targetActivityClass)
    startActivity(intent)
}

fun AppCompatActivity.gotoActivityWithNoHistory(targetActivityClass: Class<*>) {
    val i = Intent(this, targetActivityClass)
    i.flags =
            Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(i)
}