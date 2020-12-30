package edu.aku.hassannaqvi.matiari_cohorts.repository

import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel
import edu.aku.hassannaqvi.matiari_cohorts.models.Users
import edu.aku.hassannaqvi.matiari_cohorts.models.VillageModel
import java.util.*

interface GeneralDataSource {

    /*
    * For dashboard Start
    * */
    suspend fun getVillages(): ArrayList<VillageModel>

    suspend fun getChildListByVillage(villageCode: String): ArrayList<ChildModel>
    /*
    * For dashboard End
    * */


    /*
    * For login Start
    * */
    suspend fun getLoginInformation(username: String, password: String): Users?
    /*
    * For dashboard End
    * */


}