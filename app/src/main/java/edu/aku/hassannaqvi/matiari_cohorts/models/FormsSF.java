package edu.aku.hassannaqvi.matiari_cohorts.models;

import android.database.Cursor;

import androidx.lifecycle.LiveData;

import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.matiari_cohorts.contracts.FormsSFContract;
import edu.aku.hassannaqvi.matiari_cohorts.contracts.FormsSFContract.FormsSFTable;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsSF extends LiveData<FormsSF> {

    private final String projectName = "blf";
    public String sf101 = "";
    public String sf102 = "";
    public String sf103 = "";
    public String sf104 = "";
    public String sf105 = "";
    public String sf2 = "";
    public String sf3 = "";
    public String sf4 = "";
    public String sf5 = "";
    public String sf6 = "";
    public String sf6a01 = "";
    public String sf6a02 = "";
    public String sf701 = "";
    public String sf702 = "";
    public String sf8 = "";
    public String sf9 = "";
    public String sf10 = "";
    public String sf11 = "";
    public String sf12 = "";
    public String sf1296x = "";
    public String sf1301 = "";
    public String sf1302 = "";
    public String sf1303 = "";
    public String sf1304 = "";
    public String sf1305 = "";
    public String sf1306 = "";
    public String sf1307 = "";
    public String sf1308 = "";
    public String sf1309 = "";
    public String sf1396 = "";
    public String sf139601x = "";
    public String sf14 = "";
    public String sf1402x = "";
   /* public String sf1501 = "";
    public String sf1502 = "";
    public String sf1503 = "";
    public String sf1504 = "";
    public String sf1505 = "";
    public String sf1506 = "";
    public String sf1507 = "";
    public String sf1508 = "";
    public String sf1509 = "";*/
   public String sf16 = "";
    public String sf17 = "";
    public String sfFlag = "";
    public String sf18 = "";
    public String sf1901 = "";
/*
    public String sf1902 = "";
*/
public String sf20 = "";
    private String _ID = "";
    private String _UID = "";
    private String sysdate = "";
    private String username = ""; // Interviewer
    //  private String istatus = ""; // Interview Status
    //  private String istatus96x = ""; // Interview Status
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
    private String sF = ""; //SectionSF

    //For section selection
    private SectionSelection secSelection;


    public FormsSF() {
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

    public FormsSF setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getSf101() {
        return sf101;
    }

    public FormsSF setSf101(String sf101) {
        this.sf101 = sf101;
        return this;
    }

    public String getSf102() {
        return sf102;
    }

    public FormsSF setSf102(String sf102) {
        this.sf102 = sf102;
        return this;
    }

    public String getSf103() {
        return sf103;
    }

    public FormsSF setSf103(String sf103) {
        this.sf103 = sf103;
        return this;
    }

    public String getSf104() {
        return sf104;
    }

    public FormsSF setSf104(String sf104) {
        this.sf104 = sf104;
        return this;
    }

    public String getSf105() {
        return sf105;
    }

    public FormsSF setSf105(String sf105) {
        this.sf105 = sf105;
        return this;
    }

    public String getSf2() {
        return sf2;
    }

    public FormsSF setSf2(String sf2) {
        this.sf2 = sf2;
        return this;
    }

    public String getSf3() {
        return sf3;
    }

    public FormsSF setSf3(String sf3) {
        this.sf3 = sf3;
        return this;
    }

    public String getSf4() {
        return sf4;
    }

    public FormsSF setSf4(String sf4) {
        this.sf4 = sf4;
        return this;
    }

    public String getSf5() {
        return sf5;
    }

    public FormsSF setSf5(String sf5) {
        this.sf5 = sf5;
        return this;
    }

    public String getSf6() {
        return sf6;
    }

    public FormsSF setSf6(String sf6) {
        this.sf6 = sf6;
        return this;
    }

    public String getSf6a01() {
        return sf6a01;
    }

    public FormsSF setSf6a01(String sf6a01) {
        this.sf6a01 = sf6a01;
        return this;
    }

    public String getSf6a02() {
        return sf6a02;
    }

    public FormsSF setSf6a02(String sf6a02) {
        this.sf6a02 = sf6a02;
        return this;
    }

    public String getSf701() {
        return sf701;
    }

    public FormsSF setSf701(String sf701) {
        this.sf701 = sf701;
        return this;
    }

    public String getSf702() {
        return sf702;
    }

    public FormsSF setSf702(String sf702) {
        this.sf702 = sf702;
        return this;
    }

    public String getSf8() {
        return sf8;
    }

    public FormsSF setSf8(String sf8) {
        this.sf8 = sf8;
        return this;
    }

    public String getSf9() {
        return sf9;
    }

    public FormsSF setSf9(String sf9) {
        this.sf9 = sf9;
        return this;
    }

    public String getSf10() {
        return sf10;
    }

    public FormsSF setSf10(String sf10) {
        this.sf10 = sf10;
        return this;
    }

    public String getSf11() {
        return sf11;
    }

    public FormsSF setSf11(String sf11) {
        this.sf11 = sf11;
        return this;
    }

    public String getSf12() {
        return sf12;
    }

    public FormsSF setSf12(String sf12) {
        this.sf12 = sf12;
        return this;
    }

    public String getSf1296x() {
        return sf1296x;
    }

    public FormsSF setSf1296x(String sf1296x) {
        this.sf1296x = sf1296x;
        return this;
    }

    public String getSf1301() {
        return sf1301;
    }

    public FormsSF setSf1301(String sf1301) {
        this.sf1301 = sf1301;
        return this;
    }

    public String getSf1302() {
        return sf1302;
    }

    public FormsSF setSf1302(String sf1302) {
        this.sf1302 = sf1302;
        return this;
    }

    public String getSf1303() {
        return sf1303;
    }

    public FormsSF setSf1303(String sf1303) {
        this.sf1303 = sf1303;
        return this;
    }

    public String getSf1304() {
        return sf1304;
    }

    public FormsSF setSf1304(String sf1304) {
        this.sf1304 = sf1304;
        return this;
    }

    public String getSf1305() {
        return sf1305;
    }

    public FormsSF setSf1305(String sf1305) {
        this.sf1305 = sf1305;
        return this;
    }

    public String getSf1306() {
        return sf1306;
    }

    public FormsSF setSf1306(String sf1306) {
        this.sf1306 = sf1306;
        return this;
    }

    public String getSf1307() {
        return sf1307;
    }

    public FormsSF setSf1307(String sf1307) {
        this.sf1307 = sf1307;
        return this;
    }

    public String getSf1308() {
        return sf1308;
    }

    public FormsSF setSf1308(String sf1308) {
        this.sf1308 = sf1308;
        return this;
    }

    public String getSf1309() {
        return sf1309;
    }

    public FormsSF setSf1309(String sf1309) {
        this.sf1309 = sf1309;
        return this;
    }

    public String getSf1396() {
        return sf1396;
    }

    public FormsSF setSf1396(String sf1396) {
        this.sf1396 = sf1396;
        return this;
    }



    public String getSf139601x() {
        return sf139601x;
    }

    public void setSf139601x(String sf139601x) {
        this.sf139601x = sf139601x;
    }


    public String getSf14() {
        return sf14;
    }

    public FormsSF setSf14(String sf14) {
        this.sf14 = sf14;
        return this;
    }

    public String getSf1402x() {
        return sf1402x;
    }

    public FormsSF setSf1402x(String sf1402x) {
        this.sf1402x = sf1402x;
        return this;
    }
/*

    public String getSf1501() {
        return sf1501;
    }

    public FormsSF setSf1501(String sf1501) {
        this.sf1501 = sf1501;
        return this;
    }

    public String getSf1502() {
        return sf1502;
    }

    public FormsSF setSf1502(String sf1502) {
        this.sf1502 = sf1502;
        return this;
    }

    public String getSf1503() {
        return sf1503;
    }

    public FormsSF setSf1503(String sf1503) {
        this.sf1503 = sf1503;
        return this;
    }

    public String getSf1504() {
        return sf1504;
    }

    public FormsSF setSf1504(String sf1504) {
        this.sf1504 = sf1504;
        return this;
    }

    public String getSf1505() {
        return sf1505;
    }

    public FormsSF setSf1505(String sf1505) {
        this.sf1505 = sf1505;
        return this;
    }

    public String getSf1506() {
        return sf1506;
    }

    public FormsSF setSf1506(String sf1506) {
        this.sf1506 = sf1506;
        return this;
    }

    public String getSf1507() {
        return sf1507;
    }

    public FormsSF setSf1507(String sf1507) {
        this.sf1507 = sf1507;
        return this;
    }

    public String getSf1508() {
        return sf1508;
    }

    public FormsSF setSf1508(String sf1508) {
        this.sf1508 = sf1508;
        return this;
    }

    public String getSf1509() {
        return sf1509;
    }

    public FormsSF setSf1509(String sf1509) {
        this.sf1509 = sf1509;
        return this;
    }
*/

    public String getSf16() {
        return sf16;
    }

    public FormsSF setSf16(String sf16) {
        this.sf16 = sf16;
        return this;
    }

    public String getSf17() {
        return sf17;
    }

    public FormsSF setSf17(String sf17) {
        this.sf17 = sf17;
        return this;
    }

    public String getSfFlag() {
        return sfFlag;
    }

    public FormsSF setSfFlag(String sfFlag) {
        this.sfFlag = sfFlag;
        return this;
    }

    public String getSf18() {
        return sf18;
    }

    public FormsSF setSf18(String sf18) {
        this.sf18 = sf18;
        return this;
    }

    public String getSf1901() {
        return sf1901;
    }

    public FormsSF setSf1901(String sf1901) {
        this.sf1901 = sf1901;
        return this;
    }

   /* public String getSf1902() {
        return sf1902;
    }

    public FormsSF setSf1902(String sf1902) {
        this.sf1902 = sf1902;
        return this;
    }*/

    public String getSf20() {
        return sf20;
    }

    public FormsSF setSf20(String sf17) {
        this.sf20 = sf20;
        return this;
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

    /*public String getIstatus() {
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
    }*/

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


    public FormsSF Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsSFContract.FormsSFTable.COLUMN_ID);
        this._UID = jsonObject.getString(FormsSFTable.COLUMN_UID);
        this.sysdate = jsonObject.getString(FormsSFTable.COLUMN_SYSDATE);

        //   this.istatus = jsonObject.getString(FormsSFTable.COLUMN_ISTATUS);
        //    this.istatus96x = jsonObject.getString(FormsSFTable.COLUMN_ISTATUS96x);
        //  this.endingdatetime = jsonObject.getString(FormsSFTable.COLUMN_ENDINGDATETIME);
        this.gpsLat = jsonObject.getString(FormsSFTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsSFTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsSFTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsSFTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsSFTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsSFTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsSFTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsSFTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsSFTable.COLUMN_SYNCED_DATE);

        this.sF = jsonObject.getString(FormsSFTable.COLUMN_SF);

        return this;

    }

    public FormsSF Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_UID));
        this.sysdate = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_SYSDATE));

        //   this.istatus = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_ISTATUS));
        //   this.istatus96x = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_ISTATUS96x));
        //     this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_ENDINGDATETIME));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_DEVICETAGID));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_APPVERSION));
        sFHydrate(cursor.getString(cursor.getColumnIndex(FormsSFTable.COLUMN_SF)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, FormsSF.class);
    }


    public String sFtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("sf101", sf101)
                    .put("sf102", sf102)
                    .put("username", username)
                    .put("sf103", sf103)
                    .put("sf104", sf104)
                    .put("sf105", sf105)
                    .put("sf2", sf2)
                    .put("sf3 ", sf3)
                    .put("sf4 ", sf4)
                    .put("sf5 ", sf5)
                    .put("sf6 ", sf6)
                    .put("sf6a01 ", sf6a01)
                    .put("sf6a02 ", sf6a02)
                    .put("sf701", sf701)
                    .put("sf702", sf702)
                    .put("sf8", sf8)
                    .put("sf9", sf9)
                    .put("sf10", sf10)
                    .put("sf11", sf11)
                    .put("sf12", sf12)
                    .put("sf1296x", sf1296x)
                    .put("sf1301", sf1301)
                    .put("sf1302", sf1302)
                    .put("sf1303", sf1303)
                    .put("sf1304", sf1304)
                    .put("sf1305", sf1305)
                    .put("sf1306", sf1306)
                    .put("sf1307", sf1307)
                    .put("sf1308", sf1308)
                    .put("sf1309", sf1309)
                    .put("sf1396", sf1396)
                    .put("sf139601x", sf139601x)
                    .put("sf14", sf14)
                    .put("sf1402x", sf1402x)
                    /*  .put("sf1501", sf1501)
                      .put("sf1502", sf1502)
                      .put("sf1503", sf1503)
                      .put("sf1504", sf1504)
                      .put("sf1505", sf1505)
                      .put("sf1506", sf1506)
                      .put("sf1507", sf1507)
                      .put("sf1508", sf1508)
                      .put("sf1509", sf1509)*/
                    .put("sf16", sf16)
                    .put("sf17", sf17)
                    .put("sfFlag", sfFlag)
                    .put("sf18", sf18)
                    .put("sf1901", sf1901)
/*
                    .put("sf1902", sf1902)
*/
                    .put("sf20", sf20);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(FormsSFTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);

            json.put(FormsSFTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
            json.put(FormsSFTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
            //        json.put(FormsSFTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
            //       json.put(FormsSFTable.COLUMN_ISTATUS96x, this.istatus96x == null ? JSONObject.NULL : this.istatus96x);
            //   json.put(FormsSFTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
            json.put(FormsSFTable.COLUMN_SF, new JSONObject(sFtoString()));

          /*  if (this.sF != null && !this.sF.equals("")) {
                json.put(FormsSFTable.COLUMN_SF, new JSONObject(this.sF));
            }

            if (this.sL != null && !this.sL.equals("")) {
                json.put(FormsSFTable.COLUMN_SL, new JSONObject(this.sL));
            }*/

            json.put(FormsSFTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
            json.put(FormsSFTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
            json.put(FormsSFTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
            json.put(FormsSFTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
            json.put(FormsSFTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
            json.put(FormsSFTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
            json.put(FormsSFTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void sFHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.sf101 = json.getString("sf101");
                this.sf102 = json.getString("sf102");
                this.username = json.getString("username");
                this.sf103 = json.getString("sf103");
                this.sf104 = json.getString("sf104");
                this.sf105 = json.getString("sf105");
                this.sf2 = json.getString("sf2");
                this.sf3 = json.getString("sf3");
                this.sf4 = json.getString("sf4");
                this.sf5 = json.getString("sf5");
                this.sf6 = json.getString("sf6");
                this.sf6a01 = json.getString("sf6a01");
                this.sf6a02 = json.getString("sf6a02");
                this.sf701 = json.getString("sf701");
                this.sf702 = json.getString("sf702");
                this.sf8 = json.getString("sf8");
                this.sf9 = json.getString("sf9");
                this.sf10 = json.getString("sf10");
                this.sf11 = json.getString("sf11");
                this.sf12 = json.getString("sf12");
                this.sf1296x = json.getString("sf1296x");
                this.sf1301 = json.getString("sf1301");
                this.sf1302 = json.getString("sf1302");
                this.sf1303 = json.getString("sf1303");
                this.sf1304 = json.getString("sf1304");
                this.sf1305 = json.getString("sf1305");
                this.sf1306 = json.getString("sf1306");
                this.sf1307 = json.getString("sf1307");
                this.sf1308 = json.getString("sf1308");
                this.sf1309 = json.getString("sf1309");
                this.sf1396 = json.getString("sf1396");
                this.sf139601x = json.getString("sf139601x");
                this.sf14 = json.getString("sf14");
                this.sf1402x = json.getString("sf1402x");
             /*   this.sf1501 = json.getString("sf1501");
                this.sf1502 = json.getString("sf1502");
                this.sf1503 = json.getString("sf1503");
                this.sf1504 = json.getString("sf1504");
                this.sf1505 = json.getString("sf1505");
                this.sf1506 = json.getString("sf1506");
                this.sf1507 = json.getString("sf1507");
                this.sf1508 = json.getString("sf1508");
                this.sf1509 = json.getString("sf1509");*/
                this.sf16 = json.getString("sf16");
                this.sf17 = json.getString("sf17");
                this.sfFlag = json.getString("sfFlag");
                this.sf18 = json.getString("sf18");
                this.sf1901 = json.getString("sf1901");
/*
                this.sf1902 = json.getString("sf1902");
*/
                this.sf20 = json.getString("sf20");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
