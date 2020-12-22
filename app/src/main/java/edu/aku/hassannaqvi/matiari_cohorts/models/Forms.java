package edu.aku.hassannaqvi.matiari_cohorts.models;

import android.database.Cursor;

import androidx.lifecycle.LiveData;

import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.matiari_cohorts.contracts.FormsContract.FormsTable;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class Forms extends LiveData<Forms> {

    private final String projectName = "matiari_cohorts";

    public String mc01 = "";
    public String mc02 = "";
    public String mc03 = "";
    public String mc04 = "";
    public String mc05 = "";
    public String mc06 = "";
    public String mc07 = "";
    public String mc08 = "";
    public String mc09 = "";
    public String mc10 = "";
    public String mc11 = "";
    public String mc12 = "";
    public String mc1301 = "";
    public String mc1302 = "";
    public String mc14 = "";
    public String mc15 = "";
    public String mc16 = "";
    public String mc17 = "";
    public String mc18 = "";
    public String mc1898x = "";
    public String mc19 = "";
    public String mc2001 = "";
    public String mc2002 = "";
    public String mc21 = "";
    public String mc22 = "";
    public String mc23 = "";
    public String mc24 = "";
    public String mc25 = "";
    public String mc26 = "";
    public String mcrem = "";
    private String _ID = "";
    private String child_id = "";
    private String _UID = "";
    private String sysdate = "";
    private String username = ""; // Interviewer
    private String istatus = ""; // Interview Status
    private String istatus96x = ""; // Interview Status
    private String endingdatetime = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String sA = "";
    private String sF = "";
    private String sL = "";
    private String village_code = "";


    public Forms() {
    }


    public String getMc01() {
        return mc01;
    }

    public void setMc01(String mc01) {
        this.mc01 = mc01;
    }

    public String getMc02() {
        return mc02;
    }

    public void setMc02(String mc02) {
        this.mc02 = mc02;
    }

    public String getMc03() {
        return mc03;
    }

    public void setMc03(String mc03) {
        this.mc03 = mc03;
    }

    public String getMc04() {
        return mc04;
    }

    public void setMc04(String mc04) {
        this.mc04 = mc04;
    }

    public String getMc05() {
        return mc05;
    }

    public void setMc05(String mc05) {
        this.mc05 = mc05;
    }

    public String getMc06() {
        return mc06;
    }

    public void setMc06(String mc06) {
        this.mc06 = mc06;
    }

    public String getMc07() {
        return mc07;
    }

    public void setMc07(String mc07) {
        this.mc07 = mc07;
    }

    public String getMc08() {
        return mc08;
    }

    public void setMc08(String mc08) {
        this.mc08 = mc08;
    }

    public String getMc09() {
        return mc09;
    }

    public void setMc09(String mc09) {
        this.mc09 = mc09;
    }

    public String getMc10() {
        return mc10;
    }

    public void setMc10(String mc10) {
        this.mc10 = mc10;
    }

    public String getMc11() {
        return mc11;
    }

    public void setMc11(String mc11) {
        this.mc11 = mc11;
    }

    public String getMc12() {
        return mc12;
    }

    public void setMc12(String mc12) {
        this.mc12 = mc12;
    }

    public String getMc1301() {
        return mc1301;
    }

    public void setMc1301(String mc1301) {
        this.mc1301 = mc1301;
    }

    public String getMc1302() {
        return mc1302;
    }

    public void setMc1302(String mc1302) {
        this.mc1302 = mc1302;
    }

    public String getMc14() {
        return mc14;
    }

    public void setMc14(String mc14) {
        this.mc14 = mc14;
    }

    public String getMc15() {
        return mc15;
    }

    public void setMc15(String mc15) {
        this.mc15 = mc15;
    }

    public String getMc16() {
        return mc16;
    }

    public void setMc16(String mc16) {
        this.mc16 = mc16;
    }

    public String getMc17() {
        return mc17;
    }

    public void setMc17(String mc17) {
        this.mc17 = mc17;
    }

    public String getMc18() {
        return mc18;
    }

    public void setMc18(String mc18) {
        this.mc18 = mc18;
    }

    public String getMc1898x() {
        return mc1898x;
    }

    public void setMc1898x(String mc1898x) {
        this.mc1898x = mc1898x;
    }

    public String getMc19() {
        return mc19;
    }

    public void setMc19(String mc19) {
        this.mc19 = mc19;
    }

    public String getMc2001() {
        return mc2001;
    }

    public void setMc2001(String mc2001) {
        this.mc2001 = mc2001;
    }

    public String getMc2002() {
        return mc2002;
    }

    public void setMc2002(String mc2002) {
        this.mc2002 = mc2002;
    }

    public String getMc21() {
        return mc21;
    }

    public void setMc21(String mc21) {
        this.mc21 = mc21;
    }

    public String getMc22() {
        return mc22;
    }

    public void setMc22(String mc22) {
        this.mc22 = mc22;
    }

    public String getMc23() {
        return mc23;
    }

    public void setMc23(String mc23) {
        this.mc23 = mc23;
    }

    public String getMc24() {
        return mc24;
    }

    public void setMc24(String mc24) {
        this.mc24 = mc24;
    }

    public String getMc25() {
        return mc25;
    }

    public void setMc25(String mc25) {
        this.mc25 = mc25;
    }

    public String getMc26() {
        return mc26;
    }

    public void setMc26(String mc26) {
        this.mc26 = mc26;
    }

    public String getMcrem() {
        return mcrem;
    }

    public void setMcrem(String mcrem) {
        this.mcrem = mcrem;
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

    public Forms setUsername(String username) {
        this.username = username;
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


    public String getChild_id() {
        return child_id;
    }

    public void setChild_id(String child_id) {
        this.child_id = child_id;
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


    public String getEndingdatetime() {
        return endingdatetime;
    }

    public void setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }

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


    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }


    public String getsF() {
        return sF;
    }

    public void setsF(String sF) {
        this.sF = sF;
    }

    public String getsL() {
        return sL;
    }

    public void setsL(String sL) {
        this.sL = sL;
    }


    public String getVillage_code() {
        return village_code;
    }

    public void setVillage_code(String village_code) {
        this.village_code = village_code;
    }


    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }


    public Forms Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsTable.COLUMN_ID);
        this.child_id = jsonObject.getString(FormsTable.COLUMN_ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN_UID);
        this.sysdate = jsonObject.getString(FormsTable.COLUMN_SYSDATE);
        this.username = jsonObject.getString(FormsTable.COLUMN_USERNAME);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus96x = jsonObject.getString(FormsTable.COLUMN_ISTATUS96x);
        this.endingdatetime = jsonObject.getString(FormsTable.COLUMN_ENDINGDATETIME);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.sA = jsonObject.getString(FormsTable.COLUMN_SA);
        this.sF = jsonObject.getString(FormsTable.COLUMN_sF);
        this.sL = jsonObject.getString(FormsTable.COLUMN_sL);
        this.village_code = jsonObject.getString(FormsTable.COLUMN_VILLAGE_CODE);


        return this;

    }

    public Forms Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ID));
        this.child_id = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.sysdate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYSDATE));
        this.username = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USERNAME));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus96x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS96x));
        this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ENDINGDATETIME));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APPVERSION));
        this.village_code = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_VILLAGE_CODE));

        sAHydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, Forms.class);
    }


    public String sAtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("mc01", mc01)
                    .put("mc02", mc02)
                    .put("mc03", mc03)
                    .put("mc04", mc04)
                    .put("mc05", mc05)
                    .put("mc06", mc06)
                    .put("mc07", mc07)
                    .put("mc08", mc08)
                    .put("mc09", mc09)
                    .put("mc10", mc10)
                    .put("mc11", mc11)
                    .put("mc12", mc12)
                    .put("mc1301", mc1301)
                    .put("mc1302", mc1302)
                    .put("mc14", mc14)
                    .put("mc15", mc15)
                    .put("mc16", mc16)
                    .put("mc17", mc17)
                    .put("mc18", mc18)
                    .put("mc1898x", mc1898x)
                    .put("mc19", mc19)
                    .put("mc2001", mc2001)
                    .put("mc2002", mc2002)
                    .put("mc21", mc21)
                    .put("mc22", mc22)
                    .put("mc23", mc23)
                    .put("mc24", mc24)
                    .put("mc25", mc25)
                    .put("mc26", mc26)
                    .put("mcrem", mcrem)
                    .put("username", username);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(FormsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
            json.put(FormsTable.COLUMN_CHILD_ID, this.child_id == null ? JSONObject.NULL : this.child_id);
            json.put(FormsTable.COLUMN_VILLAGE_CODE, this.village_code == null ? JSONObject.NULL : this.village_code);
            json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
            json.put(FormsTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
            json.put(FormsTable.COLUMN_USERNAME, this.username == null ? JSONObject.NULL : this.username);
            json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
            json.put(FormsTable.COLUMN_ISTATUS96x, this.istatus96x == null ? JSONObject.NULL : this.istatus96x);
            json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
            json.put(FormsTable.COLUMN_SA, new JSONObject(sAtoString()));
            if (this.sF != null && !this.sF.equals("")) {
                json.put(FormsTable.COLUMN_sF, new JSONObject(this.sF));
            }

            if (this.sL != null && !this.sL.equals("")) {
                json.put(FormsTable.COLUMN_sL, new JSONObject(this.sL));
            }
            json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
            json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
            json.put(FormsTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
            json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
            json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
            json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
            json.put(FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    private void sAHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.mc01 = json.getString("mc01");
                this.mc02 = json.getString("mc02");
                this.mc03 = json.getString("mc03");
//                this.mc04 = json.getString("mc04");
//                this.mc05 = json.getString("mc05");
                this.mc06 = json.getString("mc06");
                this.mc07 = json.getString("mc07");
                this.mc08 = json.getString("mc08");
                this.mc09 = json.getString("mc09");
                this.mc10 = json.getString("mc10");
                this.mc11 = json.getString("mc11");
                this.mc12 = json.getString("mc12");
                this.mc1301 = json.getString("mc1301");
                this.mc1302 = json.getString("mc1302");
                this.mc14 = json.getString("mc14");
                this.mc15 = json.getString("mc15");
                this.mc16 = json.getString("mc16");
                this.mc17 = json.getString("mc17");
                this.mc18 = json.getString("mc18");
                this.mc1898x = json.getString("mc1898x");
                this.mc19 = json.getString("mc19");
                this.mc2001 = json.getString("mc2001");
                this.mc2002 = json.getString("mc2002");
                this.mc21 = json.getString("mc21");
                this.mc22 = json.getString("mc22");
                this.mc23 = json.getString("mc23");
                this.mc24 = json.getString("mc24");
                this.mc25 = json.getString("mc25");
//                this.mc26 = json.getString("mc26");
                this.mcrem = json.getString("mcrem");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
