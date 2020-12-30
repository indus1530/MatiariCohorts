package edu.aku.hassannaqvi.matiari_cohorts.models

import android.database.Cursor
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hassan.naqvi on 11/30/2016.
 */
class Users {
    var userID: Long = 0
    var userName: String = ""
    var password: String = ""
    var fullname: String = ""

    constructor() {
        // Default Constructor
    }

    constructor(username: String, fullname: String) {
        userName = username
        this.fullname = fullname
    }

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): Users {
        userName = jsonObject.getString(UsersTable.COLUMN_USERNAME)
        password = jsonObject.getString(UsersTable.COLUMN_PASSWORD)
        fullname = jsonObject.getString(UsersTable.COLUMN_FULLNAME)
        return this
    }

    fun hydrate(cursor: Cursor): Users {
        userID = cursor.getLong(cursor.getColumnIndex(UsersTable.COLUMN_ID))
        userName = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_USERNAME))
        password = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_PASSWORD))
        fullname = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_FULLNAME))
        return this
    }

    object UsersTable {
        const val TABLE_NAME = "users"
        const val COLUMN_ID = "id"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_FULLNAME = "full_name"
    }
}