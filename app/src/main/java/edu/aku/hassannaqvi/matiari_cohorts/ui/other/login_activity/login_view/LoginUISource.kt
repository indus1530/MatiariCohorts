package edu.aku.hassannaqvi.matiari_cohorts.ui.other.login_activity.login_view

interface LoginUISource {

    fun isPasswordValid(password: String): Boolean = password.length >= 7

    fun showProgress(show: Boolean)

    fun formValidation(username: String, password: String): Boolean

    fun setPasswordIncorrect(error: String? = null)

    suspend fun isLoginApproved(username: String, password: String)
}