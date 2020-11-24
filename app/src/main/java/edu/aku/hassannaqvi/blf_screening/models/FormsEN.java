package edu.aku.hassannaqvi.blf_screening.models;

import android.database.Cursor;

import androidx.lifecycle.LiveData;

import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.blf_screening.contracts.FormsENContract.FormsS3Table;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsEN extends LiveData<FormsEN> {

    private final String projectName = "blf";
    public String s1q1 = "";
    public String s1q2 = "";
    public String s1q3 = "";
    public String s1q4 = "";
    public String s1q501 = "";
    public String s1q502 = "";
    public String s1q6 = "";
    public String s1q7 = "";
    public String s1q8 = "";
    public String s1q9 = "";
    public String s1q10 = "";
    public String s1q11 = "";
    public String s1q12 = "";
    public String s1q13 = "";
    public String s1q14 = "";
    public String s1q15 = "";
    public String s1q16 = "";
    public String s1q17 = "";
    public String s1q18 = "";
    public String s1q1802x = "";
    public String s1q1901 = "";
    public String s1q1902 = "";
    public String s1q20 = "";
    public String s1q21 = "";
    public String s1q22 = "";
    public String s1q2301 = "";
    public String s1q2302 = "";
    public String s2q1 = "";
    public String s2q2 = "";
    public String s2q3 = "";
    public String s2q4 = "";
    public String s2q5 = "";
    public String s3q1 = "";
    public String s3q2 = "";
    public String s3q2096x = "";
    public String s3q3 = "";
    public String s3q4 = "";
    public String s3q401 = "";
    public String s3q402 = "";
    public String s3q403 = "";
    public String s3q496 = "";
    public String s3q496x = "";
    public String s3q5 = "";
    public String s3q596x = "";
    public String s3q6 = "";
    public String s3q601 = "";
    public String s3q602 = "";
    public String s3q603 = "";
    public String s3q604 = "";
    public String s3q605 = "";
    public String s3q696 = "";
    public String s3q696x = "";
    public String s3q7 = "";
    public String s3q8 = "";
    public String s3q801 = "";
    public String s3q802 = "";
    public String s3q803 = "";
    public String s3q896 = "";
    public String s3q896x = "";
    public String s3q9 = "";

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
    private String secEN = ""; // Enrolment

    //For section selection
    private SectionSelection secSelection;


    public FormsEN() {
    }

    public String getS1q1() {
        return s1q1;
    }

    public void setS1q1(String s1q1) {
        this.s1q1 = s1q1;
    }


    public String getS1q2() {
        return s1q2;
    }

    public void setS1q2(String s1q2) {
        this.s1q2 = s1q2;
    }


    public String getS1q3() {
        return s1q3;
    }

    public void setS1q3(String s1q3) {
        this.s1q3 = s1q3;
    }


    public String getS1q4() {
        return s1q4;
    }

    public void setS1q4(String s1q4) {
        this.s1q4 = s1q4;
    }


    public String getS1q501() {
        return s1q501;
    }

    public void setS1q501(String s1q501) {
        this.s1q501 = s1q501;
    }


    public String getS1q502() {
        return s1q502;
    }

    public void setS1q502(String s1q502) {
        this.s1q502 = s1q502;
    }


    public String getS1q6() {
        return s1q6;
    }

    public void setS1q6(String s1q6) {
        this.s1q6 = s1q6;
    }


    public String getS1q7() {
        return s1q7;
    }

    public void setS1q7(String s1q7) {
        this.s1q7 = s1q7;
    }


    public String getS1q8() {
        return s1q8;
    }

    public void setS1q8(String s1q8) {
        this.s1q8 = s1q8;
    }


    public String getS1q9() {
        return s1q9;
    }

    public void setS1q9(String s1q9) {
        this.s1q9 = s1q9;
    }


    public String getS1q10() {
        return s1q10;
    }

    public void setS1q10(String s1q10) {
        this.s1q10 = s1q10;
    }


    public String getS1q11() {
        return s1q11;
    }

    public void setS1q11(String s1q11) {
        this.s1q11 = s1q11;
    }


    public String getS1q12() {
        return s1q12;
    }

    public void setS1q12(String s1q12) {
        this.s1q12 = s1q12;
    }


    public String getS1q13() {
        return s1q13;
    }

    public void setS1q13(String s1q13) {
        this.s1q13 = s1q13;
    }


    public String getS1q14() {
        return s1q14;
    }

    public void setS1q14(String s1q14) {
        this.s1q14 = s1q14;
    }


    public String getS1q15() {
        return s1q15;
    }

    public void setS1q15(String s1q15) {
        this.s1q15 = s1q15;
    }


    public String getS1q16() {
        return s1q16;
    }

    public void setS1q16(String s1q16) {
        this.s1q16 = s1q16;
    }


    public String getS1q17() {
        return s1q17;
    }

    public void setS1q17(String s1q17) {
        this.s1q17 = s1q17;
    }


    public String getS1q18() {
        return s1q18;
    }

    public void setS1q18(String s1q18) {
        this.s1q18 = s1q18;
    }


    public String getS1q1802x() {
        return s1q1802x;
    }

    public void setS1q1802x(String s1q1802x) {
        this.s1q1802x = s1q1802x;
    }


    public String getS1q1901() {
        return s1q1901;
    }

    public void setS1q1901(String s1q1901) {
        this.s1q1901 = s1q1901;
    }


    public String getS1q1902() {
        return s1q1902;
    }

    public void setS1q1902(String s1q1902) {
        this.s1q1902 = s1q1902;
    }


    public String getS1q20() {
        return s1q20;
    }

    public void setS1q20(String s1q20) {
        this.s1q20 = s1q20;
    }


    public String getS1q21() {
        return s1q21;
    }

    public void setS1q21(String s1q21) {
        this.s1q21 = s1q21;
    }


    public String getS1q22() {
        return s1q22;
    }

    public void setS1q22(String s1q22) {
        this.s1q22 = s1q22;
    }


    public String getS1q2301() {
        return s1q2301;
    }

    public void setS1q2301(String s1q2301) {
        this.s1q2301 = s1q2301;
    }


    public String getS1q2302() {
        return s1q2302;
    }

    public void setS1q2302(String s1q2302) {
        this.s1q2302 = s1q2302;
    }


    public String getS2q1() {
        return s2q1;
    }

    public void setS2q1(String s2q1) {
        this.s2q1 = s2q1;
    }


    public String getS2q2() {
        return s2q2;
    }

    public void setS2q2(String s2q2) {
        this.s2q2 = s2q2;
    }


    public String getS2q3() {
        return s2q3;
    }

    public void setS2q3(String s2q3) {
        this.s2q3 = s2q3;
    }


    public String getS2q4() {
        return s2q4;
    }

    public void setS2q4(String s2q4) {
        this.s2q4 = s2q4;
    }


    public String getS2q5() {
        return s2q5;
    }

    public void setS2q5(String s2q5) {
        this.s2q5 = s2q5;
    }


    public String getS3q1() {
        return s3q1;
    }

    public void setS3q1(String s3q1) {
        this.s3q1 = s3q1;
    }


    public String getS3q2() {
        return s3q2;
    }

    public void setS3q2(String s3q2) {
        this.s3q2 = s3q2;
    }


    public String getS3q2096x() {
        return s3q2096x;
    }

    public void setS3q2096x(String s3q2096x) {
        this.s3q2096x = s3q2096x;
    }


    public String getS3q3() {
        return s3q3;
    }

    public void setS3q3(String s3q3) {
        this.s3q3 = s3q3;
    }


    public String getS3q4() {
        return s3q4;
    }

    public void setS3q4(String s3q4) {
        this.s3q4 = s3q4;
    }


    public String getS3q401() {
        return s3q401;
    }

    public void setS3q401(String s3q401) {
        this.s3q401 = s3q401;
    }


    public String getS3q402() {
        return s3q402;
    }

    public void setS3q402(String s3q402) {
        this.s3q402 = s3q402;
    }


    public String getS3q403() {
        return s3q403;
    }

    public void setS3q403(String s3q403) {
        this.s3q403 = s3q403;
    }


    public String getS3q496() {
        return s3q496;
    }

    public void setS3q496(String s3q496) {
        this.s3q496 = s3q496;
    }


    public String getS3q496x() {
        return s3q496x;
    }

    public void setS3q496x(String s3q496x) {
        this.s3q496x = s3q496x;
    }


    public String getS3q5() {
        return s3q5;
    }

    public void setS3q5(String s3q5) {
        this.s3q5 = s3q5;
    }


    public String getS3q596x() {
        return s3q596x;
    }

    public void setS3q596x(String s3q596x) {
        this.s3q596x = s3q596x;
    }


    public String getS3q6() {
        return s3q6;
    }

    public void setS3q6(String s3q6) {
        this.s3q6 = s3q6;
    }


    public String getS3q601() {
        return s3q601;
    }

    public void setS3q601(String s3q601) {
        this.s3q601 = s3q601;
    }


    public String getS3q602() {
        return s3q602;
    }

    public void setS3q602(String s3q602) {
        this.s3q602 = s3q602;
    }


    public String getS3q603() {
        return s3q603;
    }

    public void setS3q603(String s3q603) {
        this.s3q603 = s3q603;
    }


    public String getS3q604() {
        return s3q604;
    }

    public void setS3q604(String s3q604) {
        this.s3q604 = s3q604;
    }


    public String getS3q605() {
        return s3q605;
    }

    public void setS3q605(String s3q605) {
        this.s3q605 = s3q605;
    }


    public String getS3q696() {
        return s3q696;
    }

    public void setS3q696(String s3q696) {
        this.s3q696 = s3q696;
    }


    public String getS3q696x() {
        return s3q696x;
    }

    public void setS3q696x(String s3q696x) {
        this.s3q696x = s3q696x;
    }


    public String getS3q7() {
        return s3q7;
    }

    public void setS3q7(String s3q7) {
        this.s3q7 = s3q7;
    }


    public String getS3q8() {
        return s3q8;
    }

    public void setS3q8(String s3q8) {
        this.s3q8 = s3q8;
    }


    public String getS3q801() {
        return s3q801;
    }

    public void setS3q801(String s3q801) {
        this.s3q801 = s3q801;
    }


    public String getS3q802() {
        return s3q802;
    }

    public void setS3q802(String s3q802) {
        this.s3q802 = s3q802;
    }


    public String getS3q803() {
        return s3q803;
    }

    public void setS3q803(String s3q803) {
        this.s3q803 = s3q803;
    }


    public String getS3q896() {
        return s3q896;
    }

    public void setS3q896(String s3q896) {
        this.s3q896 = s3q896;
    }


    public String getS3q896x() {
        return s3q896x;
    }

    public void setS3q896x(String s3q896x) {
        this.s3q896x = s3q896x;
    }


    public String getS3q9() {
        return s3q9;
    }

    public void setS3q9(String s3q9) {
        this.s3q9 = s3q9;
    }


    public String getSecEN() {
        return secEN;
    }

    public void setSecEN(String secEN) {
        this.secEN = secEN;
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

    public FormsEN setUsername(String username) {
        this.username = username;
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

    public FormsEN setSf20(String sf17) {
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


    public FormsEN Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsS3Table.COLUMN_ID);
        this._UID = jsonObject.getString(FormsS3Table.COLUMN_UID);
        this.sysdate = jsonObject.getString(FormsS3Table.COLUMN_SYSDATE);

        //   this.istatus = jsonObject.getString(FormsS3Table.COLUMN_ISTATUS);
        //    this.istatus96x = jsonObject.getString(FormsS3Table.COLUMN_ISTATUS96x);
        //  this.endingdatetime = jsonObject.getString(FormsS3Table.COLUMN_ENDINGDATETIME);
        this.gpsLat = jsonObject.getString(FormsS3Table.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsS3Table.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsS3Table.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsS3Table.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsS3Table.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsS3Table.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsS3Table.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsS3Table.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsS3Table.COLUMN_SYNCED_DATE);

        this.secEN = jsonObject.getString(FormsS3Table.COLUMN_EN);

        return this;

    }

    public FormsEN Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_UID));
        this.sysdate = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_SYSDATE));

        //   this.istatus = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_ISTATUS));
        //   this.istatus96x = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_ISTATUS96x));
        //     this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_ENDINGDATETIME));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_DEVICETAGID));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_APPVERSION));
        s3Hydrate(cursor.getString(cursor.getColumnIndex(FormsS3Table.COLUMN_EN)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, FormsEN.class);
    }


    public String s3toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("s1q1", s1q1)
                    .put("username", username)
                    .put("s1q2", s1q2)
                    .put("s1q3", s1q3)
                    .put("s1q4", s1q4)
                    .put("s1q501", s1q501)
                    .put("s1q502", s1q502)
                    .put("s1q6", s1q6)
                    .put("s1q7", s1q7)
                    .put("s1q8", s1q8)
                    .put("s1q9", s1q9)
                    .put("s1q10", s1q10)
                    .put("s1q11", s1q11)
                    .put("s1q12", s1q12)
                    .put("s1q13", s1q13)
                    .put("s1q14", s1q14)
                    .put("s1q15", s1q15)
                    .put("s1q16", s1q16)
                    .put("s1q17", s1q17)
                    .put("s1q18", s1q18)
                    .put("s1q1802x", s1q1802x)
                    .put("s1q1901", s1q1901)
                    .put("s1q1902", s1q1902)
                    .put("s1q20", s1q20)
                    .put("s1q21", s1q21)
            //        .put("s1q22", s1q22)
                    .put("s1q2301", s1q2301)
                    .put("s1q2302", s1q2302)
                    .put("s2q1", s2q1)
                    .put("s2q2", s2q2)
                    .put("s2q3", s2q3)
                    .put("s2q4", s2q4)
                    .put("s2q5", s2q5)
                    .put("s3q1", s3q1)
                    .put("s3q2", s3q2)
                    .put("s3q2096x", s3q2096x)
                    .put("s3q3", s3q3)
                    .put("s3q4", s3q4)
                    .put("s3q401", s3q401)
                    .put("s3q402", s3q402)
                    .put("s3q403", s3q403)
                    .put("s3q496", s3q496)
                    .put("s3q496x", s3q496x)
                    .put("s3q5", s3q5)
                    .put("s3q596x", s3q596x)
                    .put("s3q6", s3q6)
                    .put("s3q601", s3q601)
                    .put("s3q602", s3q602)
                    .put("s3q603", s3q603)
                    .put("s3q604", s3q604)
                    .put("s3q605", s3q605)
                    .put("s3q696", s3q696)
                    .put("s3q696x", s3q696x)
                    .put("s3q7", s3q7)
                    .put("s3q8", s3q8)
                    .put("s3q801", s3q801)
                    .put("s3q802", s3q802)
                    .put("s3q803", s3q803)
                    .put("s3q896", s3q896)
                    .put("s3q896x", s3q896x)
                    .put("s3q9", s3q9);


        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(FormsS3Table.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);

            json.put(FormsS3Table.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
            json.put(FormsS3Table.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
            //        json.put( FormsS3Table.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
            //       json.put( FormsS3Table.COLUMN_ISTATUS96x, this.istatus96x == null ? JSONObject.NULL : this.istatus96x);
            //   json.put( FormsS3Table.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
            json.put(FormsS3Table.COLUMN_EN, new JSONObject(s3toString()));

            json.put(FormsS3Table.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
            json.put(FormsS3Table.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
            json.put(FormsS3Table.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
            json.put(FormsS3Table.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
            json.put(FormsS3Table.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
            json.put(FormsS3Table.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
            json.put(FormsS3Table.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

            if (this.secEN != null && !this.secEN.equals("")) {
                json.put(FormsS3Table.COLUMN_EN, new JSONObject(this.secEN));
            }

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void s3Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.s1q1 = json.getString("s1q1");
                this.username = json.getString("username");
                this.s1q2 = json.getString("s1q2");
                this.s1q3 = json.getString("s1q3");
                this.s1q4 = json.getString("s1q4");
                this.s1q501 = json.getString("s1q501");
                this.s1q502 = json.getString("s1q502");
                this.s1q6 = json.getString("s1q6");
                this.s1q7 = json.getString("s1q7");
                this.s1q8 = json.getString("s1q8");
                this.s1q9 = json.getString("s1q9");
                this.s1q10 = json.getString("s1q10");
                this.s1q11 = json.getString("s1q11");
                this.s1q12 = json.getString("s1q12");
                this.s1q13 = json.getString("s1q13");
                this.s1q14 = json.getString("s1q14");
                this.s1q15 = json.getString("s1q15");
                this.s1q16 = json.getString("s1q16");
                this.s1q17 = json.getString("s1q17");
                this.s1q18 = json.getString("s1q18");
                this.s1q1802x = json.getString("s1q1802x");
                this.s1q1901 = json.getString("s1q1901");
                this.s1q1902 = json.getString("s1q1902");
                this.s1q20 = json.getString("s1q20");
                this.s1q21 = json.getString("s1q21");
                //    this.s1q22 = json.getString("s1q22");
                this.s1q2301 = json.getString("s1q2301");
                this.s1q2302 = json.getString("s1q2302");
                this.s2q1 = json.getString("s2q1");
                this.s2q2 = json.getString("s2q2");
                this.s2q3 = json.getString("s2q3");
                this.s2q4 = json.getString("s2q4");
                this.s2q5 = json.getString("s2q5");
                this.s3q1 = json.getString("s3q1");
                this.s3q2 = json.getString("s3q2");
                this.s3q2096x = json.getString("s3q2096x");
                this.s3q3 = json.getString("s3q3");
                this.s3q401 = json.getString("s3q401");
                this.s3q402 = json.getString("s3q402");
                this.s3q403 = json.getString("s3q403");
                this.s3q496 = json.getString("s3q496");
                this.s3q496x = json.getString("s3q496x");
                this.s3q5 = json.getString("s3q5");
                this.s3q596x = json.getString("s3q596x");
                this.s3q601 = json.getString("s3q601");
                this.s3q602 = json.getString("s3q602");
                this.s3q603 = json.getString("s3q603");
                this.s3q604 = json.getString("s3q604");
                this.s3q605 = json.getString("s3q605");
                this.s3q696 = json.getString("s3q696");
                this.s3q696x = json.getString("s3q696x");
                this.s3q7 = json.getString("s3q7");
                this.s3q801 = json.getString("s3q801");
                this.s3q802 = json.getString("s3q802");
                this.s3q803 = json.getString("s3q803");
                this.s3q896 = json.getString("s3q896");
                this.s3q896x = json.getString("s3q896x");
                this.s3q9 = json.getString("s3q9");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
