package edu.aku.hassannaqvi.matiari_cohorts.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.aku.hassannaqvi.matiari_cohorts.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.matiari_cohorts.contracts.UsersContract.UsersTable;
import edu.aku.hassannaqvi.matiari_cohorts.contracts.VersionAppContract;
import edu.aku.hassannaqvi.matiari_cohorts.contracts.VersionAppContract.VersionAppTable;
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel;
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel.ChildTable;
import edu.aku.hassannaqvi.matiari_cohorts.models.Forms;
import edu.aku.hassannaqvi.matiari_cohorts.models.Users;
import edu.aku.hassannaqvi.matiari_cohorts.models.VersionApp;
import edu.aku.hassannaqvi.matiari_cohorts.models.VillageModel;
import edu.aku.hassannaqvi.matiari_cohorts.models.VillageModel.VillageTable;

import static edu.aku.hassannaqvi.matiari_cohorts.utils.CreateTable.DATABASE_NAME;
import static edu.aku.hassannaqvi.matiari_cohorts.utils.CreateTable.DATABASE_VERSION;
import static edu.aku.hassannaqvi.matiari_cohorts.utils.CreateTable.SQL_CREATE_CHILD_LIST;
import static edu.aku.hassannaqvi.matiari_cohorts.utils.CreateTable.SQL_CREATE_FORMS;
import static edu.aku.hassannaqvi.matiari_cohorts.utils.CreateTable.SQL_CREATE_USERS;
import static edu.aku.hassannaqvi.matiari_cohorts.utils.CreateTable.SQL_CREATE_VERSIONAPP;
import static edu.aku.hassannaqvi.matiari_cohorts.utils.CreateTable.SQL_CREATE_VILLAGE;

/**
 * @author hassan.naqvi on 11/30/2016.
 * @update ali azaz on 12/18/20
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String TAG = DatabaseHelper.class.getName();

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_CHILD_LIST);
        db.execSQL(SQL_CREATE_VILLAGE);
        db.execSQL(SQL_CREATE_VERSIONAPP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    /*
     * Syncing functions
     * */
    public int syncVersionApp(JSONObject VersionList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VersionAppContract.VersionAppTable.TABLE_NAME, null, null);
        long count = 0;
        try {
            JSONObject jsonObjectCC = ((JSONArray) VersionList.get(VersionAppContract.VersionAppTable.COLUMN_VERSION_PATH)).getJSONObject(0);
            VersionApp Vc = new VersionApp();
            Vc.Sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionAppContract.VersionAppTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionAppContract.VersionAppTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;

        } catch (Exception ignored) {
        } finally {
            db.close();
        }

        return (int) count;
    }

    public int syncUser(JSONArray userList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < userList.length(); i++) {

                JSONObject jsonObjectUser = userList.getJSONObject(i);

                Users user = new Users();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersTable.COLUMN_USERNAME, user.getUserName());
                values.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
                values.put(UsersTable.COLUMN_FULLNAME, user.getFullname());
                long rowID = db.insert(UsersTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncVillage(JSONArray vList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VillageTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < vList.length(); i++) {
                JSONObject jsonObjectV = vList.getJSONObject(i);
                VillageModel village = new VillageModel();
                village.sync(jsonObjectV);

                ContentValues values = new ContentValues();
                values.put(VillageTable.COLUMN_VILLAGE_CODE, village.getVillageCode());
                values.put(VillageTable.COLUMN_UC_CODE, village.getUcCode());
                values.put(VillageTable.COLUMN_UC, village.getUc());
                values.put(VillageTable.COLUMN_VILLAGE, village.getVillage());
                long rowID = db.insert(VillageTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncVillage(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncChildList(JSONArray childList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ChildTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < childList.length(); i++) {

                JSONObject jsonObjectChild = childList.getJSONObject(i);
                ChildModel childItems = new ChildModel();
                childItems.sync(jsonObjectChild);
                ContentValues values = new ContentValues();

                values.put(ChildTable.COLUMN_CHILD_ID, childItems.getChildId());
                values.put(ChildTable.COLUMN_CHILD_NAME, childItems.getChildName());
                values.put(ChildTable.COLUMN_DOB, childItems.getDob());
                values.put(ChildTable.COLUMN_GENDER, childItems.getGender());
                values.put(ChildTable.COLUMN_HH_HEAD, childItems.getHhHead());
                values.put(ChildTable.COLUMN_MOTHER_NAME, childItems.getMotherName());
                values.put(ChildTable.COLUMN_PROJECT, childItems.getProject());
                values.put(ChildTable.COLUMN_VILLAGE_CODE, childItems.getVillageCode());

                long rowID = db.insert(ChildTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncChildTable(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    /*
     * Functions that dealing with table data
     * */
    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + UsersTable.TABLE_NAME + " WHERE " + UsersTable.COLUMN_USERNAME + "=? AND " + UsersTable.COLUMN_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            return mCursor.getCount() > 0;
        }
        return false;
    }

    public Collection<Forms> checkFormsExist() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_USERNAME,
//              FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<Forms> allForms = new ArrayList<Forms>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Forms forms = new Forms();
                allForms.add(forms.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public boolean checkUsers() throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + UsersTable.TABLE_NAME, null, null);
        if (mCursor != null) {
            return mCursor.getCount() > 0;
        }
        return false;
    }


    /*
     * Addition in DB
     * */
    public Long addForm(Forms form) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(FormsTable.COLUMN_UID, form.get_UID());
        values.put(FormsTable.COLUMN_SYSDATE, form.getSysdate());
        values.put(FormsTable.COLUMN_USERNAME, form.getUsername());
    /*    values.put(FormsWFTable.COLUMN_ISTATUS, formSF.getIstatus());
        values.put(FormsWFTable.COLUMN_ISTATUS96x, formSF.getIstatus96x());*/
//        values.put(FormsTable.COLUMN_ENDINGDATETIME, formSF.getEndingdatetime());
        values.put(FormsTable.COLUMN_GPSLAT, form.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, form.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDATE, form.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, form.getGpsAcc());
        values.put(FormsTable.COLUMN_DEVICETAGID, form.getDevicetagID());
        values.put(FormsTable.COLUMN_DEVICEID, form.getDeviceID());
        values.put(FormsTable.COLUMN_APPVERSION, form.getAppversion());
        values.put(FormsTable.COLUMN_SA, form.getsA());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    /*
     * Get data from tables
     * */
    public Collection<Forms> getAllForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_USERNAME,
/*
                FormsTable.COLUMN_ISTATUS,
*/
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<Forms> allForms = new ArrayList<Forms>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Forms forms = new Forms();
                allForms.add(forms.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public Collection<Forms> getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS96x,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
        };

        String whereClause = FormsTable.COLUMN_SYNCED + " is null OR " + FormsTable.COLUMN_SYNCED + " == '' ";
        // String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Collection<Forms> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedForms: " + c.getCount());
                Forms forms = new Forms();
                allForms.add(forms.Hydrate(c));
            }
        } catch (SQLiteException e) {
            Log.e(TAG, "getUnsyncedForms: " + e.getMessage());
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public Collection<Forms> getTodayForms(String sysdate) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_USERNAME,
//                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<Forms> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Forms forms = new Forms();
                forms.set_ID(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                forms.set_UID(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                forms.setSysdate(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYSDATE)));
                forms.setUsername(c.getString(c.getColumnIndex(FormsTable.COLUMN_USERNAME)));
                //               formsWF.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                forms.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                allForms.add(forms);
            }
        } catch (SQLiteException e) {

            //      db.rawQuery(SQL_ALTER_FORMS_A05CODE, null);

        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public VersionApp getVersionApp() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VersionAppTable._ID,
                VersionAppTable.COLUMN_VERSION_CODE,
                VersionAppTable.COLUMN_VERSION_NAME,
                VersionAppTable.COLUMN_PATH_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = null;

        VersionApp allVC = new VersionApp();
        try {
            c = db.query(
                    VersionAppTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allVC.hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allVC;
    }

    public ArrayList<ChildModel> getChildList(String vCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ChildTable.COLUMN_CHILD_ID,
                ChildTable.COLUMN_CHILD_NAME,
                ChildTable.COLUMN_DOB,
                ChildTable.COLUMN_GENDER,
                ChildTable.COLUMN_HH_HEAD,
                ChildTable.COLUMN_MOTHER_NAME,
                ChildTable.COLUMN_PROJECT,
                ChildTable.COLUMN_VILLAGE_CODE
        };
        String whereClause = ChildTable.COLUMN_VILLAGE_CODE + "=?";
        String[] whereArgs = {vCode};
        String groupBy = null;
        String having = null;
        String orderBy = ChildTable.COLUMN_CHILD_ID + " ASC";

        ArrayList<ChildModel> allForms = new ArrayList<>();
        try {
            c = db.query(
                    ChildModel.ChildTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildModel forms = new ChildModel();
                allForms.add(forms.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public ArrayList<VillageModel> getVillagesList() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VillageTable.COLUMN_VILLAGE_CODE,
                VillageTable.COLUMN_UC_CODE,
                VillageTable.COLUMN_UC,
                VillageTable.COLUMN_VILLAGE
        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = VillageTable.COLUMN_ID + " ASC";

        ArrayList<VillageModel> allForms = new ArrayList<>();
        try {
            c = db.query(
                    VillageModel.VillageTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allForms.add(new VillageModel().hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }


    /*
     * Update data in tables
     * */
    public int updatesFormsColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.forms.get_ID())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
/*        values.put(FormsSFTable.COLUMN_ISTATUS, MainApp.formsSF.getIstatus());
        values.put(FormsSFTable.COLUMN_ISTATUS96x, MainApp.formsSF.getIstatus96x());*/
//        values.put(FormsSFTable.COLUMN_ENDINGDATETIME, MainApp.formsSF.getEndingdatetime());

        // Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.forms.get_ID())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, true);
        values.put(FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

}