package edu.aku.hassannaqvi.matiari_cohorts.utils

import edu.aku.hassannaqvi.matiari_cohorts.contracts.FormsContract.FormsTable
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel.ChildTable
import edu.aku.hassannaqvi.matiari_cohorts.models.Users.UsersTable
import edu.aku.hassannaqvi.matiari_cohorts.models.VersionApp.VersionAppTable
import edu.aku.hassannaqvi.matiari_cohorts.models.VillageModel.VillageTable

object CreateTable {
    const val DATABASE_NAME = "matiari_cohorts.db"
    const val DB_NAME = "matiari_cohorts_copy.db"
    const val PROJECT_NAME = "matiari_cohorts"
    const val DATABASE_VERSION = 1
    const val SQL_CREATE_FORMS = ("CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_CHILD_ID + " TEXT,"
            + FormsTable.COLUMN_VILLAGE_CODE + " TEXT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT,"
            + FormsTable.COLUMN_GPSLAT + " TEXT,"
            + FormsTable.COLUMN_GPSLNG + " TEXT,"
            + FormsTable.COLUMN_GPSDATE + " TEXT,"
            + FormsTable.COLUMN_GPSACC + " TEXT,"
            + FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsTable.COLUMN_SA + " TEXT,"
            + FormsTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsTable.COLUMN_ISTATUS96x + " TEXT,"
            + FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );")
    const val SQL_CREATE_USERS = ("CREATE TABLE " + UsersTable.TABLE_NAME + "("
            + UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.COLUMN_USERNAME + " TEXT,"
            + UsersTable.COLUMN_PASSWORD + " TEXT,"
            + UsersTable.COLUMN_FULLNAME + " TEXT"
            + " );")
    const val SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppTable.TABLE_NAME + " (" +
            VersionAppTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");"
    const val SQL_CREATE_VILLAGE = ("CREATE TABLE " + VillageTable.TABLE_NAME + "("
            + VillageTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VillageTable.COLUMN_VILLAGE_CODE + " TEXT,"
            + VillageTable.COLUMN_UC_CODE + " TEXT,"
            + VillageTable.COLUMN_UC + " TEXT,"
            + VillageTable.COLUMN_VILLAGE + " TEXT);")
    const val SQL_CREATE_CHILD_LIST = ("CREATE TABLE " + ChildTable.TABLE_NAME + "("
            + ChildTable.COLUMN_ID + " TEXT,"
            + ChildTable.COLUMN_CHILD_ID + " TEXT,"
            + ChildTable.COLUMN_CHILD_NAME + " TEXT,"
            + ChildTable.COLUMN_DOB + " TEXT,"
            + ChildTable.COLUMN_GENDER + " TEXT,"
            + ChildTable.COLUMN_HH_HEAD + " TEXT,"
            + ChildTable.COLUMN_MOTHER_NAME + " TEXT,"
            + ChildTable.COLUMN_PROJECT + " TEXT,"
            + ChildTable.COLUMN_VILLAGE_CODE + " TEXT);")

/*    public static final String SQL_ALTER_CHILD_TABLE = "ALTER TABLE " +
            ChildTable.TABLE_NAME + " ADD COLUMN " +
            ChildTable.COLUMN_SYSDATE + " TEXT";*/
}