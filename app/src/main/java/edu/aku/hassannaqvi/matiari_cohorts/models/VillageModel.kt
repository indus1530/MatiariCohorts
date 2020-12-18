package edu.aku.hassannaqvi.matiari_cohorts.models

import android.database.Cursor
import android.provider.BaseColumns
import org.json.JSONException
import org.json.JSONObject

class VillageModel {
    var villageCode: String = ""
    var ucCode: String = ""
    var uc: String = ""
    var village: String = ""


    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): VillageModel {
        this.villageCode = jsonObject.getString(VillageTable.COLUMN_VILLAGE_CODE)
        this.ucCode = jsonObject.getString(VillageTable.COLUMN_UC_CODE)
        this.uc = jsonObject.getString(VillageTable.COLUMN_UC)
        this.village = jsonObject.getString(VillageTable.COLUMN_VILLAGE)
        return this
    }

    fun hydrate(cursor: Cursor): VillageModel {
        this.villageCode = cursor.getString(cursor.getColumnIndex(VillageTable.COLUMN_VILLAGE_CODE))
        this.ucCode = cursor.getString(cursor.getColumnIndex(VillageTable.COLUMN_UC_CODE))
        this.uc = cursor.getString(cursor.getColumnIndex(VillageTable.COLUMN_UC))
        this.village = cursor.getString(cursor.getColumnIndex(VillageTable.COLUMN_VILLAGE))
        this.villageCode = cursor.getString(cursor.getColumnIndex(VillageTable.COLUMN_VILLAGE_CODE))
        return this
    }


    object VillageTable : BaseColumns {
        const val TABLE_NAME = "villages"
        const val COLUMN_ID = "_id"
        const val COLUMN_VILLAGE_CODE = "village_code"
        const val COLUMN_UC_CODE = "uc_code"
        const val COLUMN_UC = "uc"
        const val COLUMN_VILLAGE = "village"
    }

}