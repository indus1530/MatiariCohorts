package edu.aku.hassannaqvi.matiari_cohorts.base.repository

import edu.aku.hassannaqvi.matiari_cohorts.models.*
import java.util.*
import kotlin.collections.ArrayList

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
    * For login End
    * */

    /*
    * For MainActivity Start
    * */
    suspend fun getFormsByDate(date: String): ArrayList<Forms>

    suspend fun getUploadStatus(): FormIndicatorsModel

    suspend fun getFormStatus(date: String): FormIndicatorsModel
    /*
    * For MainActivity End
    * */

}