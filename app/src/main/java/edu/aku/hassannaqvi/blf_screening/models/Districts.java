package edu.aku.hassannaqvi.blf_screening.models;


import android.database.Cursor;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.blf_screening.contracts.DistrictsContract.DistrictsTable;

public class Districts {

    private static final String TAG = "Districts_CONTRACT";
    String prov;
    String dist_id;
    String admin_unit;

    public Districts() {
        // Default Constructor
    }


    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getDist_id() {
        return dist_id;
    }

    public void setDist_id(String dist_id) {
        this.dist_id = dist_id;
    }

    public String getAdmin_unit() {
        return admin_unit;
    }

    public void setAdmin_unit(String admin_unit) {
        this.admin_unit = admin_unit;
    }

    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();
        try {
            json.put(DistrictsTable.COLUMN_PROV, this.prov == null ? JSONObject.NULL : this.prov);
            json.put(DistrictsTable.COLUMN_DIST_ID, this.dist_id == null ? JSONObject.NULL : this.dist_id);
            json.put(DistrictsTable.COLUMN_ADMIN_UNIT, this.admin_unit == null ? JSONObject.NULL : this.admin_unit);
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Districts Sync(JSONObject jsonObject) throws JSONException {
        this.prov = jsonObject.getString(DistrictsTable.COLUMN_PROV);
        this.dist_id = jsonObject.getString(DistrictsTable.COLUMN_DIST_ID);
        this.admin_unit = jsonObject.getString(DistrictsTable.COLUMN_ADMIN_UNIT);
        return this;
    }

    public Districts HydrateDist(Cursor cursor) {
        this.prov = cursor.getString(cursor.getColumnIndex(DistrictsTable.COLUMN_PROV));
        this.dist_id = cursor.getString(cursor.getColumnIndex(DistrictsTable.COLUMN_DIST_ID));
        this.admin_unit = cursor.getString(cursor.getColumnIndex(DistrictsTable.COLUMN_ADMIN_UNIT));
        return this;
    }
}