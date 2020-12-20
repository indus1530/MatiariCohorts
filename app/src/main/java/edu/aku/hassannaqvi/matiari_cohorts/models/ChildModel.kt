package edu.aku.hassannaqvi.matiari_cohorts.models

import android.database.Cursor
import android.provider.BaseColumns
import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable

class ChildModel : Serializable {
    var childId: String = ""
    var childName: String = ""
    var dob: String = ""
    var gender: String = ""
    var hhHead: String = ""
    var motherName: String = ""
    var project: String = ""
    var villageCode: String = ""

    //Not for DB
    var formFlag: Int = 0
    var uc: String = ""
    var village: String = ""


    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): ChildModel {
        this.childId = jsonObject.getString(ChildTable.COLUMN_CHILD_ID)
        this.childName = jsonObject.getString(ChildTable.COLUMN_CHILD_NAME)
        this.dob = jsonObject.getString(ChildTable.COLUMN_DOB)
        this.gender = jsonObject.getString(ChildTable.COLUMN_GENDER)
        this.hhHead = jsonObject.getString(ChildTable.COLUMN_HH_HEAD)
        this.motherName = jsonObject.getString(ChildTable.COLUMN_MOTHER_NAME)
        this.project = jsonObject.getString(ChildTable.COLUMN_PROJECT)
        this.villageCode = jsonObject.getString(ChildTable.COLUMN_VILLAGE_CODE)
        return this
    }

    fun hydrate(cursor: Cursor): ChildModel {
        this.childId = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_CHILD_ID))
        this.childName = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_CHILD_NAME))
        this.dob = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_DOB))
        this.gender = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_GENDER))
        this.hhHead = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_HH_HEAD))
        this.motherName = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_MOTHER_NAME))
        this.project = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_PROJECT))
        this.villageCode = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_VILLAGE_CODE))
        return this
    }


    object ChildTable : BaseColumns {
        const val TABLE_NAME = "child_list"
        const val COLUMN_ID = "_id"
        const val COLUMN_CHILD_ID = "child_id"
        const val COLUMN_CHILD_NAME = "child_name"
        const val COLUMN_DOB = "dob"
        const val COLUMN_GENDER = "gender"
        const val COLUMN_HH_HEAD = "hh_head"
        const val COLUMN_MOTHER_NAME = "mother_name"
        const val COLUMN_PROJECT = "project"
        const val COLUMN_VILLAGE_CODE = "village_code"
    }

}