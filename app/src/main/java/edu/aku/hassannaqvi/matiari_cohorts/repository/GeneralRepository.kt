package edu.aku.hassannaqvi.matiari_cohorts.repository

import edu.aku.hassannaqvi.matiari_cohorts.core.DatabaseHelper
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel
import edu.aku.hassannaqvi.matiari_cohorts.models.VillageModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

open class GeneralRepository(private val db: DatabaseHelper) : GeneralBluePrint {

    override suspend fun getVillages(): ArrayList<VillageModel> = withContext(Dispatchers.IO) {
        db.villagesList
    }

    override suspend fun getChildListByVillage(villageCode: String): ArrayList<ChildModel> = withContext(Dispatchers.IO) {
        db.getChildList(villageCode)
    }
}