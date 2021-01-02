package edu.aku.hassannaqvi.matiari_cohorts.repository

import edu.aku.hassannaqvi.matiari_cohorts.core.DatabaseHelper
import edu.aku.hassannaqvi.matiari_cohorts.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.collections.ArrayList

open class GeneralRepository(private val db: DatabaseHelper) : GeneralDataSource {

    override suspend fun getVillages(): ArrayList<VillageModel> = withContext(Dispatchers.IO) {
        db.villagesList
    }

    override suspend fun getChildListByVillage(villageCode: String): ArrayList<ChildModel> = withContext(Dispatchers.IO) {
        db.getChildList(villageCode)
    }

    override suspend fun getLoginInformation(username: String, password: String): Users? = withContext(Dispatchers.IO) {
        db.getLoginUser(username, password)
    }

    override suspend fun getFormsByDate(date: String): ArrayList<Forms> = withContext(Dispatchers.IO) {
        db.getFormsByDate(date)
    }

    override suspend fun getUploadStatus(): FormIndicatorsModel = withContext(Dispatchers.IO) {
        db.uploadStatusCount
    }

    override suspend fun getFormStatus(date: String): FormIndicatorsModel = withContext(Dispatchers.IO) {
        db.getFormStatusCount(date)
    }
}