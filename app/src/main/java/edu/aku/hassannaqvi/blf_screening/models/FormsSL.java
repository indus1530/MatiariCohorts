package edu.aku.hassannaqvi.blf_screening.models;

import android.database.Cursor;

import androidx.lifecycle.LiveData;

import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.blf_screening.contracts.FormsSLContract.FormsSLTable;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsSL extends LiveData<FormsSL> {

    private final String projectName = "blf";
    public String sl2 = "";
    public String sl301 = "";
    public String sl302 = "";
    public String sl303 = "";
    public String sl4 = "";
    public String sl5 = "";
    public String sl601 = "";
    public String sl602 = "";
    public String sl701 = "";
    public String sl702 = "";
    public String sl703 = "";
    public String sl8 = "";
    public String sl9 = "";
    public String sl10 = "";
    public String sl11 = "";
    private String _ID = "";
    private String _UID = "";
    private String sysdate = "";
    private String username = ""; // Interviewer
    //   private String istatus = ""; // Interview Status
    //   private String istatus96x = ""; // Interview Status
/*
    private String endingdatetime = "";
*/
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String sL = ""; //SectionSL

    //For section selection
    private SectionSelection secSelection;


    public FormsSL() {
    }

    public SectionSelection getSecSelection() {
        return secSelection;
    }

    public void setSecSelection(SectionSelection secSelection) {
        this.secSelection = secSelection;
    }


    public String getSysdate() {
        return sysdate;
    }

    public void setSysdate(String sysdate) {
        this.sysdate = sysdate;
    }


    public String getUsername() {
        return username;
    }

    public FormsSL setUsername(String username) {
        this.username = username;
        return this;
    }


    public String getSl2() {
        return sl2;
    }

    public FormsSL setSl2(String sl2) {
        this.sl2 = sl2;
        return this;
    }

    public String getSl301() {
        return sl301;
    }

    public FormsSL setSl301(String sl301) {
        this.sl301 = sl301;
        return this;
    }

    public String getSl302() {
        return sl302;
    }

    public FormsSL setSl302(String sl302) {
        this.sl302 = sl302;
        return this;
    }

    public String getSl303() {
        return sl303;
    }

    public FormsSL setSl303(String sl303) {
        this.sl303 = sl303;
        return this;
    }

    public String getSl4() {
        return sl4;
    }

    public FormsSL setSl4(String sl4) {
        this.sl4 = sl4;
        return this;
    }

    public String getSl5() {
        return sl5;
    }

    public FormsSL setSl5(String sl5) {
        this.sl5 = sl5;
        return this;
    }

    public String getSl601() {
        return sl601;
    }

    public FormsSL setSl601(String sl601) {
        this.sl601 = sl601;
        return this;
    }

    public String getSl602() {
        return sl602;
    }

    public FormsSL setSl602(String sl602) {
        this.sl602 = sl602;
        return this;
    }

    public String getSl701() {
        return sl701;
    }

    public FormsSL setSl701(String sl701) {
        this.sl701 = sl701;
        return this;
    }

    public String getSl702() {
        return sl702;
    }

    public FormsSL setSl702(String sl702) {
        this.sl702 = sl702;
        return this;
    }

    public String getSl703() {
        return sl703;
    }

    public FormsSL setSl703(String sl703) {
        this.sl703 = sl703;
        return this;
    }

    public String getSl8() {
        return sl8;
    }

    public FormsSL setSl8(String sl8) {
        this.sl8 = sl8;
        return this;
    }

    public String getSl9() {
        return sl9;
    }

    public FormsSL setSl9(String sl9) {
        this.sl9 = sl9;
        return this;
    }

    public String getSl10() {
        return sl10;
    }

    public FormsSL setSl10(String sl10) {
        this.sl10 = sl10;
        return this;
    }

    public String getSl11() {
        return sl11;
    }

    public FormsSL setSl11(String sl11) {
        this.sl11 = sl11;
        return this;
    }


    public String getsL() {
        return sL;
    }

    public void setsL(String sL) {
        this.sL = sL;
    }


    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }
/*

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }


    public String getIstatus96x() {
        return istatus96x;
    }

    public void setIstatus96x(String istatus96x) {
        this.istatus96x = istatus96x;
    }
*/
/*

    public String getEndingdatetime() {
        return endingdatetime;
    }

    public void setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }

*/

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }


    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }


    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }


    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }


    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }


    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }


    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }


    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;

    }


    public FormsSL Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsSLTable.COLUMN_ID);
        this._UID = jsonObject.getString(FormsSLTable.COLUMN_UID);
        this.sysdate = jsonObject.getString(FormsSLTable.COLUMN_SYSDATE);

     /*   this.istatus = jsonObject.getString(FormsSLTable.COLUMN_ISTATUS);
        this.istatus96x = jsonObject.getString(FormsSLTable.COLUMN_ISTATUS96x);*/
/*
        this.endingdatetime = jsonObject.getString(FormsSLTable.COLUMN_ENDINGDATETIME);
*/
        this.gpsLat = jsonObject.getString(FormsSLTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsSLTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsSLTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsSLTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsSLTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsSLTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsSLTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsSLTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsSLTable.COLUMN_SYNCED_DATE);

        this.sL = jsonObject.getString(FormsSLTable.COLUMN_SL);

        return this;

    }

    public FormsSL Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_UID));
        this.sysdate = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_SYSDATE));

       /* this.istatus = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_ISTATUS));
        this.istatus96x = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_ISTATUS96x));*/
/*
        this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_ENDINGDATETIME));
*/
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_DEVICETAGID));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_APPVERSION));
        sLHydrate(cursor.getString(cursor.getColumnIndex(FormsSLTable.COLUMN_SL)));


        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, FormsSL.class);
    }


    public String sLtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("sl2", sl2)
                    .put("sl301", sl301)
                    .put("username", username)
                    .put("sl302", sl302)
                    .put("sl303", sl303)
                    .put("sl4", sl4)
                    .put("sl5", sl5)
                    .put("sl601", sl601)
                    .put("sl602", sl602)
                    .put("sl701", sl701)
                    .put("sl702", sl702)
                    .put("sl703", sl703)
                    .put("sl8", sl8)
                    .put("sl9", sl9)
                    .put("sl10", sl10)
                    .put("sl11", sl11);


        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(FormsSLTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);

            json.put(FormsSLTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
            json.put(FormsSLTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
           /* json.put(FormsSLTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
            json.put(FormsSLTable.COLUMN_ISTATUS96x, this.istatus96x == null ? JSONObject.NULL : this.istatus96x);*/
/*
            json.put(FormsSLTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
*/
            json.put(FormsSLTable.COLUMN_SL, new JSONObject(sLtoString()));

          /*  if (this.sF != null && !this.sF.equals("")) {
                json.put(FormsSLTable.COLUMN_SF, new JSONObject(this.sF));
            }

            if (this.sL != null && !this.sL.equals("")) {
                json.put(FormsSLTable.COLUMN_SL, new JSONObject(this.sL));
            }*/

            json.put(FormsSLTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
            json.put(FormsSLTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
            json.put(FormsSLTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
            json.put(FormsSLTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
            json.put(FormsSLTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
            json.put(FormsSLTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
            json.put(FormsSLTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void sLHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.sl2 = json.getString("sl2");
                this.username = json.getString("username");
                this.sl301 = json.getString("sl301");
                this.sl302 = json.getString("sl302");
                this.sl303 = json.getString("sl303");
                this.sl4 = json.getString("sl4");
                this.sl5 = json.getString("sl5");
                this.sl601 = json.getString("sl601");
                this.sl602 = json.getString("sl602");
                this.sl701 = json.getString("sl701");
                this.sl702 = json.getString("sl702");
                this.sl703 = json.getString("sl703");
                this.sl8 = json.getString("sl8");
                this.sl9 = json.getString("sl9");
                this.sl10 = json.getString("sl10");
                this.sl11 = json.getString("sl11");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
