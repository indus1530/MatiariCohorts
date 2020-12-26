package edu.aku.hassannaqvi.matiari_cohorts.repository

import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel
import edu.aku.hassannaqvi.matiari_cohorts.models.VillageModel
import java.util.*

interface GeneralDataSource {

    suspend fun getVillages(): ArrayList<VillageModel>

    suspend fun getChildListByVillage(villageCode: String): ArrayList<ChildModel>

}