package edu.aku.hassannaqvi.blf_screening.models;

import android.database.Cursor;

import androidx.lifecycle.LiveData;

import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.blf_screening.contracts.FormsWFContract.FormsWFTable;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsWF extends LiveData<FormsWF> {

    private final String projectName = "blf";

    public String wfa101 = "";
    public String wfa102 = "";
    public String wfa103 = "";
    public String wfa10401 = "";
    public String wfa10402 = "";
    public String wfa10403 = "";
    public String wfa10404 = "";
    public String wfa10405 = "";
    public String wfa105 = "";
    public String wfa106 = "";
    public String wfa10696x = "";
    public String wfa107 = "";
    public String wfa108 = "";
    public String wfa109 = "";
    public String wfa10996x = "";
    public String wfa11001 = "";
    public String wfa11002 = "";
    public String wfa11003 = "";
    public String wfa11004 = "";
    public String wfa11005 = "";
    public String wfa111 = "";
    public String wfa201 = "";
    public String wfa202 = "";
    public String wfa20201 = "";
    public String wfa20202 = "";
    public String wfa20203 = "";
    public String wfa20204 = "";
    public String wfa20205 = "";
    public String wfa20206 = "";
    public String wfa20296m = "";
    public String wfa20296mx = "";
    public String wfa20207 = "";
    public String wfa20208 = "";
    public String wfa20296b = "";
    public String wfa20296bx = "";
    public String wfa203 = "";
    public String wfa204 = "";
    public String wfa205 = "";
    public String wfa20596x = "";
    public String wfa206 = "";
    public String wfa20601 = "";
    public String wfa20602 = "";
    public String wfa20603 = "";
    public String wfa20604 = "";
    public String wfa20605 = "";
    public String wfa20606 = "";
    public String wfa20607 = "";
    public String wfa20608 = "";
    public String wfa20609 = "";
    public String wfa20696 = "";
    public String wfa20696x = "";
    public String wfa301 = "";
    public String wfa302 = "";
    public String wfa30301 = "";
    public String wfa30302 = "";
    public String wfa30303 = "";
    public String wfa304 = "";
    public String wfa305 = "";
    public String wfa30601 = "";
    public String wfa30602 = "";
    public String wfa30603 = "";
    public String wfa307 = "";
    public String wfa308 = "";
    public String wfa30901 = "";
    public String wfa30902 = "";
    public String wfa310 = "";
    public String wfa311 = "";
    public String wfa31201 = "";
    public String wfa31202 = "";
    public String wfa31203 = "";
    public String wfa313 = "";
    public String wfa314 = "";
    public String wfa31501 = "";
    public String wfa31502 = "";
    public String wfa316 = "";
    public String wfa317 = "";
    public String wfa318 = "";
    public String wfa319 = "";
    public String wfa320 = "";
    public String wfa321 = "";
    public String wfa322 = "";
    public String wfa32301 = "";
    public String wfa32302 = "";
    public String wfa32303 = "";
    public String wfa324 = "";
    public String wfa325 = "";
    public String wfa32601 = "";
    public String wfa32602 = "";
    public String wfa327 = "";
    public String wfa328 = "";
    public String wfa329 = "";
    public String wfa330 = "";
    public String wfa331 = "";
    public String wfa33201 = "";
    public String wfa33202 = "";
    public String wfa333 = "";
    public String wfa334 = "";
    public String wfa33501 = "";
    public String wfa33502 = "";
    public String wfa336 = "";
    public String wfa337 = "";
    public String wfa338 = "";
    public String wfa339 = "";
    public String wfa401 = "";
    public String wfa40201 = "";
    public String wfa40202 = "";
    public String wfa40203 = "";
    public String wfa403 = "";
    public String wfa40396x = "";
    public String wfa404 = "";
    public String wfa40402x = "";
    public String wfa40403x = "";
    public String wfa405 = "";
    public String wfa406 = "";
    public String wfa40701 = "";
    public String wfa40702 = "";
    public String wfa40703 = "";
    public String wfa40801 = "";
    public String wfa40803 = "";
    public String wfa40804 = "";
    public String wfa40805 = "";
    public String wfa409 = "";
    public String wfa40903x = "";
    public String wfa40904x = "";
    public String wfa40905x = "";
    public String wfa504 = "";
    public String wfa505 = "";
    public String wfa506 = "";
    public String wfa507 = "";
    public String wfa508 = "";
    public String wfa50801 = "";
    public String wfa50802 = "";
    public String wfa50803 = "";
    public String wfa50804 = "";
    public String wfa50805 = "";
    public String wfa509 = "";
    public String wfa50996x = "";
    public String wfa510 = "";
    public String wfa51096x = "";
    public String wfa511 = "";
    public String wfa51196x = "";
    public String wfa512 = "";
    public String wfa51296x = "";
    public String wfa513 = "";
    public String wfa51396x = "";
    public String wfa514 = "";
    public String wfa51401 = "";
    public String wfa51402 = "";
    public String wfa51403 = "";
    public String wfa51404 = "";
    public String wfa515 = "";
    public String wfa51596x = "";
    public String wfb101 = "";
    public String wfb102 = "";
    public String wfb10296x = "";
    public String wfb103 = "";
    public String wfb104 = "";
    public String wfb105 = "";
    public String wfi06 = "";
    public String wfi0601 = "";
    public String wfi07 = "";
    public String wfi0701 = "";
    public String wfi0702 = "";
    public String wfi0796 = "";
    public String wfi0796x = "";
    public String wfb1081a = "";
    public String wfb1081b = "";
    public String wfb1081c = "";
    public String wfb1081d = "";
    public String wfb1081d06x = "";
    public String wfb1081d96x = "";
    public String wfb201 = "";
    public String wfb202 = "";
    public String wfb203 = "";
    public String wfb20396x = "";
    public String wfb204 = "";
    public String wfb205 = "";
    public String wfb20596x = "";
    public String wfb206 = "";
    public String wfb207 = "";
    public String wfc101 = "";
    public String wfc10196x = "";
    public String wfc102 = "";
    public String wfc103 = "";
    public String wfc104 = "";
    public String wfd101 = "";
    public String wfd10102x = "";
    public String wfd102a;
    public String wfd102a01x;
    public String wfd102b;
    public String wfd102b01x;
    public String wfd102c;
    public String wfd102c01x;
    public String wfd102d;
    public String wfd102d01x;
    public String wfd102e;
    public String wfd102e01x;
    public String wfd102f;
    public String wfd102f01x;
    public String wfd102g;
    public String wfd102g01x;
    public String wfd102h;
    public String wfd102h01x;
    public String wfd102i;
    public String wfd102i01x;
    public String wfd102j;
    public String wfd102j01x;
    public String wfd102k;
    public String wfd102k01x;
    public String wfd102l;
    public String wfd102l01x;
    public String wfd102m;
    public String wfd102m01x;
    public String wfd102n;
    public String wfd102n01x;
    public String wfd102o;
    public String wfd102o01x;
    public String wfe101 = "";
    public String wfe10102x = "";
    public String wfe102 = "";
    public String wf101 = "";
    public String wf10102x = "";
    public String wfi02 = "";

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
    private String sWFA01 = "";
    private String sWFA02 = "";
    private String sWFA03 = "";
    private String sWFA04 = "";
    private String sWFA05 = "";
    private String sWFB01 = "";
    private String sWFB02 = "";
    private String sWFC = "";
    private String sWFD = "";
    private String sWFE = "";
    private String sWFF = "";

    //For section selection
    private SectionSelection secSelection;


    public FormsWF() {
    }


    public String getWfa101() {
        return wfa101;
    }

    public void setWfa101(String wfa101) {
        this.wfa101 = wfa101;
    }

    public String getWfa102() {
        return wfa102;
    }

    public void setWfa102(String wfa102) {
        this.wfa102 = wfa102;
    }

    public String getWfa103() {
        return wfa103;
    }

    public void setWfa103(String wfa103) {
        this.wfa103 = wfa103;
    }

    public String getWfa10401() {
        return wfa10401;
    }

    public void setWfa10401(String wfa10401) {
        this.wfa10401 = wfa10401;
    }

    public String getWfa10402() {
        return wfa10402;
    }

    public void setWfa10402(String wfa10402) {
        this.wfa10402 = wfa10402;
    }

    public String getWfa10403() {
        return wfa10403;
    }

    public void setWfa10403(String wfa10403) {
        this.wfa10403 = wfa10403;
    }

    public String getWfa10404() {
        return wfa10404;
    }

    public void setWfa10404(String wfa10404) {
        this.wfa10404 = wfa10404;
    }

    public String getWfa10405() {
        return wfa10405;
    }

    public void setWfa10405(String wfa10405) {
        this.wfa10405 = wfa10405;
    }

    public String getWfa105() {
        return wfa105;
    }

    public void setWfa105(String wfa105) {
        this.wfa105 = wfa105;
    }

    public String getWfa106() {
        return wfa106;
    }

    public void setWfa106(String wfa106) {
        this.wfa106 = wfa106;
    }

    public String getWfa10696x() {
        return wfa10696x;
    }

    public void setWfa10696x(String wfa10696x) {
        this.wfa10696x = wfa10696x;
    }

    public String getWfa107() {
        return wfa107;
    }

    public void setWfa107(String wfa107) {
        this.wfa107 = wfa107;
    }

    public String getWfa108() {
        return wfa108;
    }

    public void setWfa108(String wfa108) {
        this.wfa108 = wfa108;
    }

    public String getWfa109() {
        return wfa109;
    }

    public void setWfa109(String wfa109) {
        this.wfa109 = wfa109;
    }

    public String getWfa10996x() {
        return wfa10996x;
    }

    public void setWfa10996x(String wfa10996x) {
        this.wfa10996x = wfa10996x;
    }

    public String getWfa11001() {
        return wfa11001;
    }

    public void setWfa11001(String wfa11001) {
        this.wfa11001 = wfa11001;
    }

    public String getWfa11002() {
        return wfa11002;
    }

    public void setWfa11002(String wfa11002) {
        this.wfa11002 = wfa11002;
    }

    public String getWfa11003() {
        return wfa11003;
    }

    public void setWfa11003(String wfa11003) {
        this.wfa11003 = wfa11003;
    }

    public String getWfa11004() {
        return wfa11004;
    }

    public void setWfa11004(String wfa11004) {
        this.wfa11004 = wfa11004;
    }

    public String getWfa11005() {
        return wfa11005;
    }

    public void setWfa11005(String wfa11005) {
        this.wfa11005 = wfa11005;
    }

    public String getWfa111() {
        return wfa111;
    }

    public void setWfa111(String wfa111) {
        this.wfa111 = wfa111;
    }

    public String getWfa201() {
        return wfa201;
    }

    public void setWfa201(String wfa201) {
        this.wfa201 = wfa201;
    }

    public String getWfa202() {
        return wfa202;
    }

    public void setWfa202(String wfa202) {
        this.wfa202 = wfa202;
    }

    public String getWfa20201() {
        return wfa20201;
    }

    public void setWfa20201(String wfa20201) {
        this.wfa20201 = wfa20201;
    }

    public String getWfa20202() {
        return wfa20202;
    }

    public void setWfa20202(String wfa20202) {
        this.wfa20202 = wfa20202;
    }

    public String getWfa20203() {
        return wfa20203;
    }

    public void setWfa20203(String wfa20203) {
        this.wfa20203 = wfa20203;
    }

    public String getWfa20204() {
        return wfa20204;
    }

    public void setWfa20204(String wfa20204) {
        this.wfa20204 = wfa20204;
    }

    public String getWfa20205() {
        return wfa20205;
    }

    public void setWfa20205(String wfa20205) {
        this.wfa20205 = wfa20205;
    }

    public String getWfa20206() {
        return wfa20206;
    }

    public void setWfa20206(String wfa20206) {
        this.wfa20206 = wfa20206;
    }

    public String getWfa20296m() {
        return wfa20296m;
    }

    public void setWfa20296m(String wfa20296m) {
        this.wfa20296m = wfa20296m;
    }

    public String getWfa20296mx() {
        return wfa20296mx;
    }

    public void setWfa20296mx(String wfa20296mx) {
        this.wfa20296mx = wfa20296mx;
    }

    public String getWfa20207() {
        return wfa20207;
    }

    public void setWfa20207(String wfa20207) {
        this.wfa20207 = wfa20207;
    }

    public String getWfa20208() {
        return wfa20208;
    }

    public void setWfa20208(String wfa20208) {
        this.wfa20208 = wfa20208;
    }

    public String getWfa20296b() {
        return wfa20296b;
    }

    public void setWfa20296b(String wfa20296b) {
        this.wfa20296b = wfa20296b;
    }

    public String getWfa20296bx() {
        return wfa20296bx;
    }

    public void setWfa20296bx(String wfa20296bx) {
        this.wfa20296bx = wfa20296bx;
    }

    public String getWfa203() {
        return wfa203;
    }

    public void setWfa203(String wfa203) {
        this.wfa203 = wfa203;
    }

    public String getWfa204() {
        return wfa204;
    }

    public void setWfa204(String wfa204) {
        this.wfa204 = wfa204;
    }

    public String getWfa205() {
        return wfa205;
    }

    public void setWfa205(String wfa205) {
        this.wfa205 = wfa205;
    }

    public String getWfa20596x() {
        return wfa20596x;
    }

    public void setWfa20596x(String wfa20596x) {
        this.wfa20596x = wfa20596x;
    }

    public String getWfa206() {
        return wfa206;
    }

    public void setWfa206(String wfa206) {
        this.wfa206 = wfa206;
    }

    public String getWfa20601() {
        return wfa20601;
    }

    public void setWfa20601(String wfa20601) {
        this.wfa20601 = wfa20601;
    }

    public String getWfa20602() {
        return wfa20602;
    }

    public void setWfa20602(String wfa20602) {
        this.wfa20602 = wfa20602;
    }

    public String getWfa20603() {
        return wfa20603;
    }

    public void setWfa20603(String wfa20603) {
        this.wfa20603 = wfa20603;
    }

    public String getWfa20604() {
        return wfa20604;
    }

    public void setWfa20604(String wfa20604) {
        this.wfa20604 = wfa20604;
    }

    public String getWfa20605() {
        return wfa20605;
    }

    public void setWfa20605(String wfa20605) {
        this.wfa20605 = wfa20605;
    }

    public String getWfa20606() {
        return wfa20606;
    }

    public void setWfa20606(String wfa20606) {
        this.wfa20606 = wfa20606;
    }

    public String getWfa20607() {
        return wfa20607;
    }

    public void setWfa20607(String wfa20607) {
        this.wfa20607 = wfa20607;
    }

    public String getWfa20608() {
        return wfa20608;
    }

    public void setWfa20608(String wfa20608) {
        this.wfa20608 = wfa20608;
    }

    public String getWfa20609() {
        return wfa20609;
    }

    public void setWfa20609(String wfa20609) {
        this.wfa20609 = wfa20609;
    }

    public String getWfa20696() {
        return wfa20696;
    }

    public void setWfa20696(String wfa20696) {
        this.wfa20696 = wfa20696;
    }

    public String getWfa20696x() {
        return wfa20696x;
    }

    public void setWfa20696x(String wfa20696x) {
        this.wfa20696x = wfa20696x;
    }

    public String getWfa301() {
        return wfa301;
    }

    public void setWfa301(String wfa301) {
        this.wfa301 = wfa301;
    }

    public String getWfa302() {
        return wfa302;
    }

    public void setWfa302(String wfa302) {
        this.wfa302 = wfa302;
    }

    public String getWfa30301() {
        return wfa30301;
    }

    public void setWfa30301(String wfa30301) {
        this.wfa30301 = wfa30301;
    }

    public String getWfa30302() {
        return wfa30302;
    }

    public void setWfa30302(String wfa30302) {
        this.wfa30302 = wfa30302;
    }

    public String getWfa30303() {
        return wfa30303;
    }

    public void setWfa30303(String wfa30303) {
        this.wfa30303 = wfa30303;
    }

    public String getWfa304() {
        return wfa304;
    }

    public void setWfa304(String wfa304) {
        this.wfa304 = wfa304;
    }

    public String getWfa305() {
        return wfa305;
    }

    public void setWfa305(String wfa305) {
        this.wfa305 = wfa305;
    }

    public String getWfa30601() {
        return wfa30601;
    }

    public void setWfa30601(String wfa30601) {
        this.wfa30601 = wfa30601;
    }

    public String getWfa30602() {
        return wfa30602;
    }

    public void setWfa30602(String wfa30602) {
        this.wfa30602 = wfa30602;
    }

    public String getWfa30603() {
        return wfa30603;
    }

    public void setWfa30603(String wfa30603) {
        this.wfa30603 = wfa30603;
    }

    public String getWfa307() {
        return wfa307;
    }

    public void setWfa307(String wfa307) {
        this.wfa307 = wfa307;
    }

    public String getWfa308() {
        return wfa308;
    }

    public void setWfa308(String wfa308) {
        this.wfa308 = wfa308;
    }

    public String getWfa30901() {
        return wfa30901;
    }

    public void setWfa30901(String wfa30901) {
        this.wfa30901 = wfa30901;
    }

    public String getWfa30902() {
        return wfa30902;
    }

    public void setWfa30902(String wfa30902) {
        this.wfa30902 = wfa30902;
    }

    public String getWfa310() {
        return wfa310;
    }

    public void setWfa310(String wfa310) {
        this.wfa310 = wfa310;
    }

    public String getWfa311() {
        return wfa311;
    }

    public void setWfa311(String wfa311) {
        this.wfa311 = wfa311;
    }

    public String getWfa31201() {
        return wfa31201;
    }

    public void setWfa31201(String wfa31201) {
        this.wfa31201 = wfa31201;
    }

    public String getWfa31202() {
        return wfa31202;
    }

    public void setWfa31202(String wfa31202) {
        this.wfa31202 = wfa31202;
    }

    public String getWfa31203() {
        return wfa31203;
    }

    public void setWfa31203(String wfa31203) {
        this.wfa31203 = wfa31203;
    }

    public String getWfa313() {
        return wfa313;
    }

    public void setWfa313(String wfa313) {
        this.wfa313 = wfa313;
    }

    public String getWfa314() {
        return wfa314;
    }

    public void setWfa314(String wfa314) {
        this.wfa314 = wfa314;
    }

    public String getWfa31501() {
        return wfa31501;
    }

    public void setWfa31501(String wfa31501) {
        this.wfa31501 = wfa31501;
    }

    public String getWfa31502() {
        return wfa31502;
    }

    public void setWfa31502(String wfa31502) {
        this.wfa31502 = wfa31502;
    }

    public String getWfa316() {
        return wfa316;
    }

    public void setWfa316(String wfa316) {
        this.wfa316 = wfa316;
    }

    public String getWfa317() {
        return wfa317;
    }

    public void setWfa317(String wfa317) {
        this.wfa317 = wfa317;
    }

    public String getWfa318() {
        return wfa318;
    }

    public void setWfa318(String wfa318) {
        this.wfa318 = wfa318;
    }

    public String getWfa319() {
        return wfa319;
    }

    public void setWfa319(String wfa319) {
        this.wfa319 = wfa319;
    }

    public String getWfa320() {
        return wfa320;
    }

    public void setWfa320(String wfa320) {
        this.wfa320 = wfa320;
    }

    public String getWfa321() {
        return wfa321;
    }

    public void setWfa321(String wfa321) {
        this.wfa321 = wfa321;
    }

    public String getWfa322() {
        return wfa322;
    }

    public void setWfa322(String wfa322) {
        this.wfa322 = wfa322;
    }

    public String getWfa32301() {
        return wfa32301;
    }

    public void setWfa32301(String wfa32301) {
        this.wfa32301 = wfa32301;
    }

    public String getWfa32302() {
        return wfa32302;
    }

    public void setWfa32302(String wfa32302) {
        this.wfa32302 = wfa32302;
    }

    public String getWfa32303() {
        return wfa32303;
    }

    public void setWfa32303(String wfa32303) {
        this.wfa32303 = wfa32303;
    }

    public String getWfa324() {
        return wfa324;
    }

    public void setWfa324(String wfa324) {
        this.wfa324 = wfa324;
    }

    public String getWfa325() {
        return wfa325;
    }

    public void setWfa325(String wfa325) {
        this.wfa325 = wfa325;
    }

    public String getWfa32601() {
        return wfa32601;
    }

    public void setWfa32601(String wfa32601) {
        this.wfa32601 = wfa32601;
    }

    public String getWfa32602() {
        return wfa32602;
    }

    public void setWfa32602(String wfa32602) {
        this.wfa32602 = wfa32602;
    }

    public String getWfa327() {
        return wfa327;
    }

    public void setWfa327(String wfa327) {
        this.wfa327 = wfa327;
    }

    public String getWfa328() {
        return wfa328;
    }

    public void setWfa328(String wfa328) {
        this.wfa328 = wfa328;
    }

    public String getWfa329() {
        return wfa329;
    }

    public void setWfa329(String wfa329) {
        this.wfa329 = wfa329;
    }

    public String getWfa330() {
        return wfa330;
    }

    public void setWfa330(String wfa330) {
        this.wfa330 = wfa330;
    }

    public String getWfa331() {
        return wfa331;
    }

    public void setWfa331(String wfa331) {
        this.wfa331 = wfa331;
    }

    public String getWfa33201() {
        return wfa33201;
    }

    public void setWfa33201(String wfa33201) {
        this.wfa33201 = wfa33201;
    }

    public String getWfa33202() {
        return wfa33202;
    }

    public void setWfa33202(String wfa33202) {
        this.wfa33202 = wfa33202;
    }

    public String getWfa333() {
        return wfa333;
    }

    public void setWfa333(String wfa333) {
        this.wfa333 = wfa333;
    }

    public String getWfa334() {
        return wfa334;
    }

    public void setWfa334(String wfa334) {
        this.wfa334 = wfa334;
    }

    public String getWfa33501() {
        return wfa33501;
    }

    public void setWfa33501(String wfa33501) {
        this.wfa33501 = wfa33501;
    }

    public String getWfa33502() {
        return wfa33502;
    }

    public void setWfa33502(String wfa33502) {
        this.wfa33502 = wfa33502;
    }

    public String getWfa336() {
        return wfa336;
    }

    public void setWfa336(String wfa336) {
        this.wfa336 = wfa336;
    }

    public String getWfa337() {
        return wfa337;
    }

    public void setWfa337(String wfa337) {
        this.wfa337 = wfa337;
    }

    public String getWfa338() {
        return wfa338;
    }

    public void setWfa338(String wfa338) {
        this.wfa338 = wfa338;
    }

    public String getWfa339() {
        return wfa339;
    }

    public void setWfa339(String wfa339) {
        this.wfa339 = wfa339;
    }

    public String getWfa401() {
        return wfa401;
    }

    public void setWfa401(String wfa401) {
        this.wfa401 = wfa401;
    }

    public String getWfa40201() {
        return wfa40201;
    }

    public void setWfa40201(String wfa40201) {
        this.wfa40201 = wfa40201;
    }

    public String getWfa40202() {
        return wfa40202;
    }

    public void setWfa40202(String wfa40202) {
        this.wfa40202 = wfa40202;
    }

    public String getWfa40203() {
        return wfa40203;
    }

    public void setWfa40203(String wfa40203) {
        this.wfa40203 = wfa40203;
    }

    public String getWfa403() {
        return wfa403;
    }

    public void setWfa403(String wfa403) {
        this.wfa403 = wfa403;
    }

    public String getWfa40396x() {
        return wfa40396x;
    }

    public void setWfa40396x(String wfa40396x) {
        this.wfa40396x = wfa40396x;
    }

    public String getWfa404() {
        return wfa404;
    }

    public void setWfa404(String wfa404) {
        this.wfa404 = wfa404;
    }

    public String getWfa40402x() {
        return wfa40402x;
    }

    public void setWfa40402x(String wfa40402x) {
        this.wfa40402x = wfa40402x;
    }

    public String getWfa40403x() {
        return wfa40403x;
    }

    public void setWfa40403x(String wfa40403x) {
        this.wfa40403x = wfa40403x;
    }

    public String getWfa405() {
        return wfa405;
    }

    public void setWfa405(String wfa405) {
        this.wfa405 = wfa405;
    }

    public String getWfa406() {
        return wfa406;
    }

    public void setWfa406(String wfa406) {
        this.wfa406 = wfa406;
    }

    public String getWfa40701() {
        return wfa40701;
    }

    public void setWfa40701(String wfa40701) {
        this.wfa40701 = wfa40701;
    }

    public String getWfa40702() {
        return wfa40702;
    }

    public void setWfa40702(String wfa40702) {
        this.wfa40702 = wfa40702;
    }

    public String getWfa40703() {
        return wfa40703;
    }

    public void setWfa40703(String wfa40703) {
        this.wfa40703 = wfa40703;
    }

    public String getWfa40801() {
        return wfa40801;
    }

    public void setWfa40801(String wfa40801) {
        this.wfa40801 = wfa40801;
    }

    public String getWfa40803() {
        return wfa40803;
    }

    public void setWfa40803(String wfa40803) {
        this.wfa40803 = wfa40803;
    }

    public String getWfa40804() {
        return wfa40804;
    }

    public void setWfa40804(String wfa40804) {
        this.wfa40804 = wfa40804;
    }

    public String getWfa40805() {
        return wfa40805;
    }

    public void setWfa40805(String wfa40805) {
        this.wfa40805 = wfa40805;
    }

    public String getWfa409() {
        return wfa409;
    }

    public void setWfa409(String wfa409) {
        this.wfa409 = wfa409;
    }

    public String getWfa40903x() {
        return wfa40903x;
    }

    public void setWfa40903x(String wfa40903x) {
        this.wfa40903x = wfa40903x;
    }

    public String getWfa40904x() {
        return wfa40904x;
    }

    public void setWfa40904x(String wfa40904x) {
        this.wfa40904x = wfa40904x;
    }

    public String getWfa40905x() {
        return wfa40905x;
    }

    public void setWfa40905x(String wfa40905x) {
        this.wfa40905x = wfa40905x;
    }

    public String getWfa504() {
        return wfa504;
    }

    public void setWfa504(String wfa504) {
        this.wfa504 = wfa504;
    }

    public String getWfa505() {
        return wfa505;
    }

    public void setWfa505(String wfa505) {
        this.wfa505 = wfa505;
    }

    public String getWfa506() {
        return wfa506;
    }

    public void setWfa506(String wfa506) {
        this.wfa506 = wfa506;
    }

    public String getWfa507() {
        return wfa507;
    }

    public void setWfa507(String wfa507) {
        this.wfa507 = wfa507;
    }

    public String getWfa508() {
        return wfa508;
    }

    public void setWfa508(String wfa508) {
        this.wfa508 = wfa508;
    }

    public String getWfa50801() {
        return wfa50801;
    }

    public void setWfa50801(String wfa50801) {
        this.wfa50801 = wfa50801;
    }

    public String getWfa50802() {
        return wfa50802;
    }

    public void setWfa50802(String wfa50802) {
        this.wfa50802 = wfa50802;
    }

    public String getWfa50803() {
        return wfa50803;
    }

    public void setWfa50803(String wfa50803) {
        this.wfa50803 = wfa50803;
    }

    public String getWfa50804() {
        return wfa50804;
    }

    public void setWfa50804(String wfa50804) {
        this.wfa50804 = wfa50804;
    }

    public String getWfa50805() {
        return wfa50805;
    }

    public void setWfa50805(String wfa50805) {
        this.wfa50805 = wfa50805;
    }

    public String getWfa509() {
        return wfa509;
    }

    public void setWfa509(String wfa509) {
        this.wfa509 = wfa509;
    }

    public String getWfa50996x() {
        return wfa50996x;
    }

    public void setWfa50996x(String wfa50996x) {
        this.wfa50996x = wfa50996x;
    }

    public String getWfa510() {
        return wfa510;
    }

    public void setWfa510(String wfa510) {
        this.wfa510 = wfa510;
    }

    public String getWfa51096x() {
        return wfa51096x;
    }

    public void setWfa51096x(String wfa51096x) {
        this.wfa51096x = wfa51096x;
    }

    public String getWfa511() {
        return wfa511;
    }

    public void setWfa511(String wfa511) {
        this.wfa511 = wfa511;
    }

    public String getWfa51196x() {
        return wfa51196x;
    }

    public void setWfa51196x(String wfa51196x) {
        this.wfa51196x = wfa51196x;
    }

    public String getWfa512() {
        return wfa512;
    }

    public void setWfa512(String wfa512) {
        this.wfa512 = wfa512;
    }

    public String getWfa51296x() {
        return wfa51296x;
    }

    public void setWfa51296x(String wfa51296x) {
        this.wfa51296x = wfa51296x;
    }

    public String getWfa513() {
        return wfa513;
    }

    public void setWfa513(String wfa513) {
        this.wfa513 = wfa513;
    }

    public String getWfa51396x() {
        return wfa51396x;
    }

    public void setWfa51396x(String wfa51396x) {
        this.wfa51396x = wfa51396x;
    }

    public String getWfa514() {
        return wfa514;
    }

    public void setWfa514(String wfa514) {
        this.wfa514 = wfa514;
    }

    public String getWfa51401() {
        return wfa51401;
    }

    public void setWfa51401(String wfa51401) {
        this.wfa51401 = wfa51401;
    }

    public String getWfa51402() {
        return wfa51402;
    }

    public void setWfa51402(String wfa51402) {
        this.wfa51402 = wfa51402;
    }

    public String getWfa51403() {
        return wfa51403;
    }

    public void setWfa51403(String wfa51403) {
        this.wfa51403 = wfa51403;
    }

    public String getWfa51404() {
        return wfa51404;
    }

    public void setWfa51404(String wfa51404) {
        this.wfa51404 = wfa51404;
    }

    public String getWfa515() {
        return wfa515;
    }

    public void setWfa515(String wfa515) {
        this.wfa515 = wfa515;
    }

    public String getWfa51596x() {
        return wfa51596x;
    }

    public void setWfa51596x(String wfa51596x) {
        this.wfa51596x = wfa51596x;
    }

    public String getWfb101() {
        return wfb101;
    }

    public void setWfb101(String wfb101) {
        this.wfb101 = wfb101;
    }

    public String getWfb102() {
        return wfb102;
    }

    public void setWfb102(String wfb102) {
        this.wfb102 = wfb102;
    }

    public String getWfb10296x() {
        return wfb10296x;
    }

    public void setWfb10296x(String wfb10296x) {
        this.wfb10296x = wfb10296x;
    }

    public String getWfb103() {
        return wfb103;
    }

    public void setWfb103(String wfb103) {
        this.wfb103 = wfb103;
    }

    public String getWfb104() {
        return wfb104;
    }

    public void setWfb104(String wfb104) {
        this.wfb104 = wfb104;
    }

    public String getWfb105() {
        return wfb105;
    }

    public void setWfb105(String wfb105) {
        this.wfb105 = wfb105;
    }

    public String getWfi06() {
        return wfi06;
    }

    public void setWfi06(String wfi06) {
        this.wfi06 = wfi06;
    }

    public String getWfi0601() {
        return wfi0601;
    }

    public void setWfi0601(String wfi0601) {
        this.wfi0601 = wfi0601;
    }

    public String getWfi07() {
        return wfi07;
    }

    public void setWfi07(String wfi07) {
        this.wfi07 = wfi07;
    }

    public String getWfi0701() {
        return wfi0701;
    }

    public void setWfi0701(String wfi0701) {
        this.wfi0701 = wfi0701;
    }

    public String getWfi0702() {
        return wfi0702;
    }

    public void setWfi0702(String wfi0702) {
        this.wfi0702 = wfi0702;
    }

    public String getWfi0796() {
        return wfi0796;
    }

    public void setWfi0796(String wfi0796) {
        this.wfi0796 = wfi0796;
    }

    public String getWfi0796x() {
        return wfi0796x;
    }

    public void setWfi0796x(String wfi0796x) {
        this.wfi0796x = wfi0796x;
    }

    public String getWfb1081a() {
        return wfb1081a;
    }

    public void setWfb1081a(String wfb1081a) {
        this.wfb1081a = wfb1081a;
    }

    public String getWfb1081b() {
        return wfb1081b;
    }

    public void setWfb1081b(String wfb1081b) {
        this.wfb1081b = wfb1081b;
    }

    public String getWfb1081c() {
        return wfb1081c;
    }

    public void setWfb1081c(String wfb1081c) {
        this.wfb1081c = wfb1081c;
    }

    public String getWfb1081d() {
        return wfb1081d;
    }

    public void setWfb1081d(String wfb1081d) {
        this.wfb1081d = wfb1081d;
    }

    public String getWfb1081d06x() {
        return wfb1081d06x;
    }

    public void setWfb1081d06x(String wfb1081d06x) {
        this.wfb1081d06x = wfb1081d06x;
    }

    public String getWfb1081d96x() {
        return wfb1081d96x;
    }

    public void setWfb1081d96x(String wfb1081d96x) {
        this.wfb1081d96x = wfb1081d96x;
    }

    public String getWfb201() {
        return wfb201;
    }

    public void setWfb201(String wfb201) {
        this.wfb201 = wfb201;
    }

    public String getWfb202() {
        return wfb202;
    }

    public void setWfb202(String wfb202) {
        this.wfb202 = wfb202;
    }

    public String getWfb203() {
        return wfb203;
    }

    public void setWfb203(String wfb203) {
        this.wfb203 = wfb203;
    }

    public String getWfb20396x() {
        return wfb20396x;
    }

    public void setWfb20396x(String wfb20396x) {
        this.wfb20396x = wfb20396x;
    }

    public String getWfb204() {
        return wfb204;
    }

    public void setWfb204(String wfb204) {
        this.wfb204 = wfb204;
    }

    public String getWfb205() {
        return wfb205;
    }

    public void setWfb205(String wfb205) {
        this.wfb205 = wfb205;
    }

    public String getWfb20596x() {
        return wfb20596x;
    }

    public void setWfb20596x(String wfb20596x) {
        this.wfb20596x = wfb20596x;
    }

    public String getWfb206() {
        return wfb206;
    }

    public void setWfb206(String wfb206) {
        this.wfb206 = wfb206;
    }

    public String getWfb207() {
        return wfb207;
    }

    public void setWfb207(String wfb207) {
        this.wfb207 = wfb207;
    }

    public String getWfc101() {
        return wfc101;
    }

    public void setWfc101(String wfc101) {
        this.wfc101 = wfc101;
    }

    public String getWfc10196x() {
        return wfc10196x;
    }

    public void setWfc10196x(String wfc10196x) {
        this.wfc10196x = wfc10196x;
    }

    public String getWfc102() {
        return wfc102;
    }

    public void setWfc102(String wfc102) {
        this.wfc102 = wfc102;
    }

    public String getWfc103() {
        return wfc103;
    }

    public void setWfc103(String wfc103) {
        this.wfc103 = wfc103;
    }

    public String getWfc104() {
        return wfc104;
    }

    public void setWfc104(String wfc104) {
        this.wfc104 = wfc104;
    }

    public String getWfd101() {
        return wfd101;
    }

    public void setWfd101(String wfd101) {
        this.wfd101 = wfd101;
    }

    public String getWfd10102x() {
        return wfd10102x;
    }

    public void setWfd10102x(String wfd10102x) {
        this.wfd10102x = wfd10102x;
    }

    public String getWfd102a() {
        return wfd102a;
    }

    public void setWfd102a(String wfd102a) {
        this.wfd102a = wfd102a;
    }

    public String getWfd102a01x() {
        return wfd102a01x;
    }

    public void setWfd102a01x(String wfd102a01x) {
        this.wfd102a01x = wfd102a01x;
    }

    public String getWfd102b() {
        return wfd102b;
    }

    public void setWfd102b(String wfd102b) {
        this.wfd102b = wfd102b;
    }

    public String getWfd102b01x() {
        return wfd102b01x;
    }

    public void setWfd102b01x(String wfd102b01x) {
        this.wfd102b01x = wfd102b01x;
    }

    public String getWfd102c() {
        return wfd102c;
    }

    public void setWfd102c(String wfd102c) {
        this.wfd102c = wfd102c;
    }

    public String getWfd102c01x() {
        return wfd102c01x;
    }

    public void setWfd102c01x(String wfd102c01x) {
        this.wfd102c01x = wfd102c01x;
    }

    public String getWfd102d() {
        return wfd102d;
    }

    public void setWfd102d(String wfd102d) {
        this.wfd102d = wfd102d;
    }

    public String getWfd102d01x() {
        return wfd102d01x;
    }

    public void setWfd102d01x(String wfd102d01x) {
        this.wfd102d01x = wfd102d01x;
    }

    public String getWfd102e() {
        return wfd102e;
    }

    public void setWfd102e(String wfd102e) {
        this.wfd102e = wfd102e;
    }

    public String getWfd102e01x() {
        return wfd102e01x;
    }

    public void setWfd102e01x(String wfd102e01x) {
        this.wfd102e01x = wfd102e01x;
    }

    public String getWfd102f() {
        return wfd102f;
    }

    public void setWfd102f(String wfd102f) {
        this.wfd102f = wfd102f;
    }

    public String getWfd102f01x() {
        return wfd102f01x;
    }

    public void setWfd102f01x(String wfd102f01x) {
        this.wfd102f01x = wfd102f01x;
    }

    public String getWfd102g() {
        return wfd102g;
    }

    public void setWfd102g(String wfd102g) {
        this.wfd102g = wfd102g;
    }

    public String getWfd102g01x() {
        return wfd102g01x;
    }

    public void setWfd102g01x(String wfd102g01x) {
        this.wfd102g01x = wfd102g01x;
    }

    public String getWfd102h() {
        return wfd102h;
    }

    public void setWfd102h(String wfd102h) {
        this.wfd102h = wfd102h;
    }

    public String getWfd102h01x() {
        return wfd102h01x;
    }

    public void setWfd102h01x(String wfd102h01x) {
        this.wfd102h01x = wfd102h01x;
    }

    public String getWfd102i() {
        return wfd102i;
    }

    public void setWfd102i(String wfd102i) {
        this.wfd102i = wfd102i;
    }

    public String getWfd102i01x() {
        return wfd102i01x;
    }

    public void setWfd102i01x(String wfd102i01x) {
        this.wfd102i01x = wfd102i01x;
    }

    public String getWfd102j() {
        return wfd102j;
    }

    public void setWfd102j(String wfd102j) {
        this.wfd102j = wfd102j;
    }

    public String getWfd102j01x() {
        return wfd102j01x;
    }

    public void setWfd102j01x(String wfd102j01x) {
        this.wfd102j01x = wfd102j01x;
    }

    public String getWfd102k() {
        return wfd102k;
    }

    public void setWfd102k(String wfd102k) {
        this.wfd102k = wfd102k;
    }

    public String getWfd102k01x() {
        return wfd102k01x;
    }

    public void setWfd102k01x(String wfd102k01x) {
        this.wfd102k01x = wfd102k01x;
    }

    public String getWfd102l() {
        return wfd102l;
    }

    public void setWfd102l(String wfd102l) {
        this.wfd102l = wfd102l;
    }

    public String getWfd102l01x() {
        return wfd102l01x;
    }

    public void setWfd102l01x(String wfd102l01x) {
        this.wfd102l01x = wfd102l01x;
    }

    public String getWfd102m() {
        return wfd102m;
    }

    public void setWfd102m(String wfd102m) {
        this.wfd102m = wfd102m;
    }

    public String getWfd102m01x() {
        return wfd102m01x;
    }

    public void setWfd102m01x(String wfd102m01x) {
        this.wfd102m01x = wfd102m01x;
    }

    public String getWfd102n() {
        return wfd102n;
    }

    public void setWfd102n(String wfd102n) {
        this.wfd102n = wfd102n;
    }

    public String getWfd102n01x() {
        return wfd102n01x;
    }

    public void setWfd102n01x(String wfd102n01x) {
        this.wfd102n01x = wfd102n01x;
    }

    public String getWfd102o() {
        return wfd102o;
    }

    public void setWfd102o(String wfd102o) {
        this.wfd102o = wfd102o;
    }

    public String getWfd102o01x() {
        return wfd102o01x;
    }

    public void setWfd102o01x(String wfd102o01x) {
        this.wfd102o01x = wfd102o01x;
    }

    public String getWfe101() {
        return wfe101;
    }

    public void setWfe101(String wfe101) {
        this.wfe101 = wfe101;
    }

    public String getWfe10102x() {
        return wfe10102x;
    }

    public void setWfe10102x(String wfe10102x) {
        this.wfe10102x = wfe10102x;
    }

    public String getWfe102() {
        return wfe102;
    }

    public void setWfe102(String wfe102) {
        this.wfe102 = wfe102;
    }

    public String getWf101() {
        return wf101;
    }

    public void setWf101(String wf101) {
        this.wf101 = wf101;
    }

    public String getWf10102x() {
        return wf10102x;
    }

    public void setWf10102x(String wf10102x) {
        this.wf10102x = wf10102x;
    }

    public String getWfi02() {
        return wfi02;
    }

    public void setWfi02(String wfi02) {
        this.wfi02 = wfi02;
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

    public FormsWF setUsername(String username) {
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


    public String getsWFA01() {
        return sWFA01;
    }

    public void setsWFA01(String sWFA01) {
        this.sWFA01 = sWFA01;
    }


    public String getsWFA02() {
        return sWFA02;
    }

    public void setsWFA02(String sWFA02) {
        this.sWFA02 = sWFA02;
    }


    public String getsWFA03() {
        return sWFA03;
    }

    public void setsWFA03(String sWFA03) {
        this.sWFA03 = sWFA03;
    }


    public String getsWFA04() {
        return sWFA04;
    }

    public void setsWFA04(String sWFA04) {
        this.sWFA04 = sWFA04;
    }


    public String getsWFA05() {
        return sWFA05;
    }

    public void setsWFA05(String sWFA05) {
        this.sWFA05 = sWFA05;
    }


    public String getsWFB01() {
        return sWFB01;
    }

    public void setsWFB01(String sWFB01) {
        this.sWFB01 = sWFB01;
    }


    public String getsWFB02() {
        return sWFB02;
    }

    public void setsWFB02(String sWFB02) {
        this.sWFB02 = sWFB02;
    }


    public String getsWFC() {
        return sWFC;
    }

    public void setsWFC(String sWFC) {
        this.sWFC = sWFC;
    }


    public String getsWFD() {
        return sWFD;
    }

    public void setsWFD(String sWFD) {
        this.sWFD = sWFD;
    }


    public String getsWFE() {
        return sWFE;
    }

    public void setsWFE(String sWFE) {
        this.sWFE = sWFE;
    }


    public String getsWFF() {
        return sWFF;
    }

    public void setsWFF(String sWFF) {
        this.sWFF = sWFF;
    }


    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;

    }


    public FormsWF Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsWFTable.COLUMN_ID);
        this._UID = jsonObject.getString(FormsWFTable.COLUMN_UID);
        this.sysdate = jsonObject.getString(FormsWFTable.COLUMN_SYSDATE);
        //   this.istatus = jsonObject.getString(FormsWFTable.COLUMN_ISTATUS);
        //    this.istatus96x = jsonObject.getString(FormsWFTable.COLUMN_ISTATUS96x);
        //  this.endingdatetime = jsonObject.getString(FormsWFTable.COLUMN_ENDINGDATETIME);
        this.gpsLat = jsonObject.getString(FormsWFTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsWFTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsWFTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsWFTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsWFTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsWFTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsWFTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsWFTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsWFTable.COLUMN_SYNCED_DATE);
        this.sWFA01 = jsonObject.getString(FormsWFTable.COLUMN_SWFA01);
        this.sWFA02 = jsonObject.getString(FormsWFTable.COLUMN_SWFA02);
        this.sWFA03 = jsonObject.getString(FormsWFTable.COLUMN_SWFA03);
        this.sWFA04 = jsonObject.getString(FormsWFTable.COLUMN_SWFA04);
        this.sWFA05 = jsonObject.getString(FormsWFTable.COLUMN_SWFA05);
        this.sWFB01 = jsonObject.getString(FormsWFTable.COLUMN_SWFB01);
        this.sWFB02 = jsonObject.getString(FormsWFTable.COLUMN_SWFB02);
        this.sWFC = jsonObject.getString(FormsWFTable.COLUMN_SWFC);
        this.sWFD = jsonObject.getString(FormsWFTable.COLUMN_SWFD);
        this.sWFE = jsonObject.getString(FormsWFTable.COLUMN_SWFE);
        this.sWFF = jsonObject.getString(FormsWFTable.COLUMN_SWFF);

        return this;

    }

    public FormsWF Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_UID));
        this.sysdate = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SYSDATE));
        //   this.istatus = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_ISTATUS));
        //   this.istatus96x = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_ISTATUS96x));
        //     this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_ENDINGDATETIME));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_DEVICETAGID));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_APPVERSION));

        sWFA01Hydrate(cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SWFA01)));
        sWFA02Hydrate(cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SWFA02)));
        sWFA03Hydrate(cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SWFA03)));
        sWFA04Hydrate(cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SWFA04)));
        sWFA05Hydrate(cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SWFA05)));
        sWFB01Hydrate(cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SWFB01)));
        sWFB02Hydrate(cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SWFB02)));
        sWFCHydrate(cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SWFC)));
        sWFDHydrate(cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SWFD)));
        sWFEHydrate(cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SWFE)));
        sWFFHydrate(cursor.getString(cursor.getColumnIndex(FormsWFTable.COLUMN_SWFF)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, FormsWF.class);
    }


    public String sWFA01toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("wfa101", wfa101)
                    .put("wfa102", wfa102)
                    .put("wfa103", wfa103)
                    .put("wfa10401", wfa10401)
                    .put("wfa10402", wfa10402)
                    .put("wfa10403", wfa10403)
                    .put("wfa10404", wfa10404)
                    .put("wfa10405", wfa10405)
                    .put("wfa105", wfa105)
                    .put("wfa106", wfa106)
                    .put("wfa10696x", wfa10696x)
                    .put("wfa107", wfa107)
                    .put("wfa108", wfa108)
                    .put("wfa109", wfa109)
                    .put("wfa10996x", wfa10996x)
                    .put("wfa11001", wfa11001)
                    .put("wfa11002", wfa11002)
                    .put("wfa11003", wfa11003)
                    .put("wfa11004", wfa11004)
                    .put("wfa11005", wfa11005)
                    .put("wfa111", wfa111);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public String sWFA02toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("wfa201", wfa201)
                    .put("wfa202", wfa202)
                    .put("wfa20201", wfa20201)
                    .put("wfa20202", wfa20202)
                    .put("wfa20203", wfa20203)
                    .put("wfa20204", wfa20204)
                    .put("wfa20205", wfa20205)
                    .put("wfa20206", wfa20206)
                    .put("wfa20296m", wfa20296m)
                    .put("wfa20296mx", wfa20296mx)
                    .put("wfa20207", wfa20207)
                    .put("wfa20208", wfa20208)
                    .put("wfa20296b", wfa20296b)
                    .put("wfa20296bx", wfa20296bx)
                    .put("wfa203", wfa203)
                    .put("wfa204", wfa204)
                    .put("wfa205", wfa205)
                    .put("wfa20596x", wfa20596x)
                    .put("wfa206", wfa206)
                    .put("wfa20601", wfa20601)
                    .put("wfa20602", wfa20602)
                    .put("wfa20603", wfa20603)
                    .put("wfa20604", wfa20604)
                    .put("wfa20605", wfa20605)
                    .put("wfa20606", wfa20606)
                    .put("wfa20607", wfa20607)
                    .put("wfa20608", wfa20608)
                    .put("wfa20609", wfa20609)
                    .put("wfa20696", wfa20696)
                    .put("wfa20696x", wfa20696x);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public String sWFA03toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("wfa301", wfa301)
                    .put("wfa302", wfa302)
                    .put("wfa30301", wfa30301)
                    .put("wfa30302", wfa30302)
                    .put("wfa30303", wfa30303)
                    .put("wfa304", wfa304)
                    .put("wfa305", wfa305)
                    .put("wfa30601", wfa30601)
                    .put("wfa30602", wfa30602)
                    .put("wfa30603", wfa30603)
                    .put("wfa307", wfa307)
                    .put("wfa308", wfa308)
                    .put("wfa30901", wfa30901)
                    .put("wfa30902", wfa30902)
                    .put("wfa310", wfa310)
                    .put("wfa311", wfa311)
                    .put("wfa31201", wfa31201)
                    .put("wfa31202", wfa31202)
                    .put("wfa31203", wfa31203)
                    .put("wfa313", wfa313)
                    .put("wfa314", wfa314)
                    .put("wfa31501", wfa31501)
                    .put("wfa31502", wfa31502)
                    .put("wfa316", wfa316)
                    .put("wfa317", wfa317)
                    .put("wfa318", wfa318)
                    .put("wfa319", wfa319)
                    .put("wfa320", wfa320)
                    .put("wfa321", wfa321)
                    .put("wfa322", wfa322)
                    .put("wfa32301", wfa32301)
                    .put("wfa32302", wfa32302)
                    .put("wfa32303", wfa32303)
                    .put("wfa324", wfa324)
                    .put("wfa325", wfa325)
                    .put("wfa32601", wfa32601)
                    .put("wfa32602", wfa32602)
                    .put("wfa327", wfa327)
                    .put("wfa328", wfa328)
                    .put("wfa329", wfa329)
                    .put("wfa330", wfa330)
                    .put("wfa331", wfa331)
                    .put("wfa33201", wfa33201)
                    .put("wfa33202", wfa33202)
                    .put("wfa333", wfa333)
                    .put("wfa334", wfa334)
                    .put("wfa33501", wfa33501)
                    .put("wfa33502", wfa33502)
                    .put("wfa336", wfa336)
                    .put("wfa337", wfa337)
                    .put("wfa338", wfa338)
                    .put("wfa339", wfa339);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public String sWFA04toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("wfa401", wfa401)
                    .put("wfa40201", wfa40201)
                    .put("wfa40202", wfa40202)
                    .put("wfa40203", wfa40203)
                    .put("wfa403", wfa403)
                    .put("wfa40396x", wfa40396x)
                    .put("wfa404", wfa404)
                    .put("wfa40402x", wfa40402x)
                    .put("wfa40403x", wfa40403x)
                    .put("wfa405", wfa405)
                    .put("wfa406", wfa406)
                    .put("wfa40701", wfa40701)
                    .put("wfa40702", wfa40702)
                    .put("wfa40703", wfa40703)
                    .put("wfa40801", wfa40801)
                    .put("wfa40803", wfa40803)
                    .put("wfa40804", wfa40804)
                    .put("wfa40805", wfa40805)
                    .put("wfa409", wfa409)
                    .put("wfa40903x", wfa40903x)
                    .put("wfa40904x", wfa40904x)
                    .put("wfa40905x", wfa40905x);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public String sWFA05toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("wfa504", wfa504)
                    .put("wfa505", wfa505)
                    .put("wfa506", wfa506)
                    .put("wfa507", wfa507)
                    .put("wfa508", wfa508)
                    .put("wfa50801", wfa50801)
                    .put("wfa50802", wfa50802)
                    .put("wfa50803", wfa50803)
                    .put("wfa50804", wfa50804)
                    .put("wfa50805", wfa50805)
                    .put("wfa509", wfa509)
                    .put("wfa50996x", wfa50996x)
                    .put("wfa510", wfa510)
                    .put("wfa51096x", wfa51096x)
                    .put("wfa511", wfa511)
                    .put("wfa51196x", wfa51196x)
                    .put("wfa512", wfa512)
                    .put("wfa51296x", wfa51296x)
                    .put("wfa513", wfa513)
                    .put("wfa51396x", wfa51396x)
                    .put("wfa514", wfa514)
                    .put("wfa51401", wfa51401)
                    .put("wfa51402", wfa51402)
                    .put("wfa51403", wfa51403)
                    .put("wfa51404", wfa51404)
                    .put("wfa515", wfa515)
                    .put("wfa51596x", wfa51596x);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public String sWFB01toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("wfb101", wfb101)
                    .put("wfb102", wfb102)
                    .put("wfb10296x", wfb10296x)
                    .put("wfb103", wfb103)
                    .put("wfb104", wfb104)
                    .put("wfb105", wfb105)
                    .put("wfi06", wfi06)
                    .put("wfi0601", wfi0601)
                    .put("wfi07", wfi07)
                    .put("wfi0701", wfi0701)
                    .put("wfi0702", wfi0702)
                    .put("wfi0796", wfi0796)
                    .put("wfi0796x", wfi0796x)
                    .put("wfb1081a", wfb1081a)
                    .put("wfb1081b", wfb1081b)
                    .put("wfb1081c", wfb1081c)
                    .put("wfb1081d", wfb1081d)
                    .put("wfb1081d06x", wfb1081d06x)
                    .put("wfb1081d96x", wfb1081d96x);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public String sWFB02toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("wfb201", wfb201)
                    .put("wfb202", wfb202)
                    .put("wfb203", wfb203)
                    .put("wfb20396x", wfb20396x)
                    .put("wfb204", wfb204)
                    .put("wfb205", wfb205)
                    .put("wfb20596x", wfb20596x)
                    .put("wfb206", wfb206)
                    .put("wfb207", wfb207);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public String sWFCtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("wfc101", wfc101)
                    .put("wfc10196x", wfc10196x)
                    .put("wfc102", wfc102)
                    .put("wfc103", wfc103)
                    .put("wfc104", wfc104);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public String sWFDtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("wfd101", wfd101)
                    .put("wfd102a", wfd102a)
                    .put("wfd102a01x", wfd102a01x)
                    .put("wfd102b", wfd102b)
                    .put("wfd102b01x", wfd102b01x)
                    .put("wfd102c", wfd102c)
                    .put("wfd102c01x", wfd102c01x)
                    .put("wfd102d", wfd102d)
                    .put("wfd102d01x", wfd102d01x)
                    .put("wfd102e", wfd102e)
                    .put("wfd102e01x", wfd102e01x)
                    .put("wfd102f", wfd102f)
                    .put("wfd102f01x", wfd102f01x)
                    .put("wfd102g", wfd102g)
                    .put("wfd102g01x", wfd102g01x)
                    .put("wfd102h", wfd102h)
                    .put("wfd102h01x", wfd102h01x)
                    .put("wfd102i", wfd102i)
                    .put("wfd102i01x", wfd102i01x)
                    .put("wfd102j", wfd102j)
                    .put("wfd102j01x", wfd102j01x)
                    .put("wfd102k", wfd102k)
                    .put("wfd102k01x", wfd102k01x)
                    .put("wfd102l", wfd102l)
                    .put("wfd102l01x", wfd102l01x)
                    .put("wfd102m", wfd102m)
                    .put("wfd102m01x", wfd102m01x)
                    .put("wfd102n", wfd102n)
                    .put("wfd102n01x", wfd102n01x)
                    .put("wfd102o", wfd102o)
                    .put("wfd102o01x", wfd102o01x);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public String sWFEtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("wfe101", wfe101)
                    .put("wfe10102x", wfe10102x)
                    .put("wfe102", wfe102);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }

    public String sWFFtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("wf101", wf101)
                    .put("wf10102x", wf10102x)
                    .put("wfi02", wfi02);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(FormsWFTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);

            json.put(FormsWFTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
            json.put(FormsWFTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
            //        json.put(FormsWFTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
            //       json.put(FormsWFTable.COLUMN_ISTATUS96x, this.istatus96x == null ? JSONObject.NULL : this.istatus96x);
            //   json.put(FormsWFTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
            json.put(FormsWFTable.COLUMN_SWFA01, new JSONObject(sWFA01toString()));
            json.put(FormsWFTable.COLUMN_SWFA02, new JSONObject(sWFA02toString()));
            json.put(FormsWFTable.COLUMN_SWFA03, new JSONObject(sWFA03toString()));
            json.put(FormsWFTable.COLUMN_SWFA04, new JSONObject(sWFA04toString()));
            json.put(FormsWFTable.COLUMN_SWFA05, new JSONObject(sWFA05toString()));
            json.put(FormsWFTable.COLUMN_SWFB01, new JSONObject(sWFB01toString()));
            json.put(FormsWFTable.COLUMN_SWFB02, new JSONObject(sWFB02toString()));
            json.put(FormsWFTable.COLUMN_SWFC, new JSONObject(sWFCtoString()));
            json.put(FormsWFTable.COLUMN_SWFD, new JSONObject(sWFDtoString()));
            json.put(FormsWFTable.COLUMN_SWFE, new JSONObject(sWFEtoString()));
            json.put(FormsWFTable.COLUMN_SWFF, new JSONObject(sWFFtoString()));
            /*  if (this.sF != null && !this.sF.equals("")) {
                json.put(FormsWFTable.COLUMN_SF, new JSONObject(this.sF));
            }

            if (this.sL != null && !this.sL.equals("")) {
                json.put(FormsWFTable.COLUMN_SL, new JSONObject(this.sL));
            }*/
            json.put(FormsWFTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
            json.put(FormsWFTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
            json.put(FormsWFTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
            json.put(FormsWFTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
            json.put(FormsWFTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
            json.put(FormsWFTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
            json.put(FormsWFTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    private void sWFA01Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.wfa101 = json.getString("wfa101");
                this.wfa102 = json.getString("wfa102");
                this.wfa103 = json.getString("wfa103");
                this.wfa10401 = json.getString("wfa10401");
                this.wfa10402 = json.getString("wfa10402");
                this.wfa10403 = json.getString("wfa10403");
                this.wfa10404 = json.getString("wfa10404");
                this.wfa10405 = json.getString("wfa10405");
                this.wfa105 = json.getString("wfa105");
                this.wfa106 = json.getString("wfa106");
                this.wfa10696x = json.getString("wfa10696x");
                this.wfa107 = json.getString("wfa107");
                this.wfa108 = json.getString("wfa108");
                this.wfa109 = json.getString("wfa109");
                this.wfa10996x = json.getString("wfa10996x");
                this.wfa11001 = json.getString("wfa11001");
                this.wfa11002 = json.getString("wfa11002");
                this.wfa11003 = json.getString("wfa11003");
                this.wfa11004 = json.getString("wfa11004");
                this.wfa11005 = json.getString("wfa11005");
                this.wfa111 = json.getString("wfa111");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void sWFA02Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.wfa201 = json.getString("wfa201");
                this.wfa202 = json.getString("wfa202");
                this.wfa20201 = json.getString("wfa20201");
                this.wfa20202 = json.getString("wfa20202");
                this.wfa20203 = json.getString("wfa20203");
                this.wfa20204 = json.getString("wfa20204");
                this.wfa20205 = json.getString("wfa20205");
                this.wfa20206 = json.getString("wfa20206");
                this.wfa20296m = json.getString("wfa20296m");
                this.wfa20296mx = json.getString("wfa20296mx");
                this.wfa20207 = json.getString("wfa20207");
                this.wfa20208 = json.getString("wfa20208");
                this.wfa20296b = json.getString("wfa20296b");
                this.wfa20296bx = json.getString("wfa20296bx");
                this.wfa203 = json.getString("wfa203");
                this.wfa204 = json.getString("wfa204");
                this.wfa205 = json.getString("wfa205");
                this.wfa20596x = json.getString("wfa20596x");
                this.wfa206 = json.getString("wfa206");
                this.wfa20601 = json.getString("wfa20601");
                this.wfa20602 = json.getString("wfa20602");
                this.wfa20603 = json.getString("wfa20603");
                this.wfa20604 = json.getString("wfa20604");
                this.wfa20605 = json.getString("wfa20605");
                this.wfa20606 = json.getString("wfa20606");
                this.wfa20607 = json.getString("wfa20607");
                this.wfa20608 = json.getString("wfa20608");
                this.wfa20609 = json.getString("wfa20609");
                this.wfa20696 = json.getString("wfa20696");
                this.wfa20696x = json.getString("wfa20696x");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void sWFA03Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.wfa301 = json.getString("wfa301");
                this.wfa302 = json.getString("wfa302");
                this.wfa30301 = json.getString("wfa30301");
                this.wfa30302 = json.getString("wfa30302");
                this.wfa30303 = json.getString("wfa30303");
                this.wfa304 = json.getString("wfa304");
                this.wfa305 = json.getString("wfa305");
                this.wfa30601 = json.getString("wfa30601");
                this.wfa30602 = json.getString("wfa30602");
                this.wfa30603 = json.getString("wfa30603");
                this.wfa307 = json.getString("wfa307");
                this.wfa308 = json.getString("wfa308");
                this.wfa30901 = json.getString("wfa30901");
                this.wfa30902 = json.getString("wfa30902");
                this.wfa310 = json.getString("wfa310");
                this.wfa311 = json.getString("wfa311");
                this.wfa31201 = json.getString("wfa31201");
                this.wfa31202 = json.getString("wfa31202");
                this.wfa31203 = json.getString("wfa31203");
                this.wfa313 = json.getString("wfa313");
                this.wfa314 = json.getString("wfa314");
                this.wfa31501 = json.getString("wfa31501");
                this.wfa31502 = json.getString("wfa31502");
                this.wfa316 = json.getString("wfa316");
                this.wfa317 = json.getString("wfa317");
                this.wfa318 = json.getString("wfa318");
                this.wfa319 = json.getString("wfa319");
                this.wfa320 = json.getString("wfa320");
                this.wfa321 = json.getString("wfa321");
                this.wfa322 = json.getString("wfa322");
                this.wfa32301 = json.getString("wfa32301");
                this.wfa32302 = json.getString("wfa32302");
                this.wfa32303 = json.getString("wfa32303");
                this.wfa324 = json.getString("wfa324");
                this.wfa325 = json.getString("wfa325");
                this.wfa32601 = json.getString("wfa32601");
                this.wfa32602 = json.getString("wfa32602");
                this.wfa327 = json.getString("wfa327");
                this.wfa328 = json.getString("wfa328");
                this.wfa329 = json.getString("wfa329");
                this.wfa330 = json.getString("wfa330");
                this.wfa331 = json.getString("wfa331");
                this.wfa33201 = json.getString("wfa33201");
                this.wfa33202 = json.getString("wfa33202");
                this.wfa333 = json.getString("wfa333");
                this.wfa334 = json.getString("wfa334");
                this.wfa33501 = json.getString("wfa33501");
                this.wfa33502 = json.getString("wfa33502");
                this.wfa336 = json.getString("wfa336");
                this.wfa337 = json.getString("wfa337");
                this.wfa338 = json.getString("wfa338");
                this.wfa339 = json.getString("wfa339");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void sWFA04Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.wfa401 = json.getString("wfa401");
                this.wfa40201 = json.getString("wfa40201");
                this.wfa40202 = json.getString("wfa40202");
                this.wfa40203 = json.getString("wfa40203");
                this.wfa403 = json.getString("wfa403");
                this.wfa40396x = json.getString("wfa40396x");
                this.wfa404 = json.getString("wfa404");
                this.wfa40402x = json.getString("wfa40402x");
                this.wfa40403x = json.getString("wfa40403x");
                this.wfa405 = json.getString("wfa405");
                this.wfa406 = json.getString("wfa406");
                this.wfa40701 = json.getString("wfa40701");
                this.wfa40702 = json.getString("wfa40702");
                this.wfa40703 = json.getString("wfa40703");
                this.wfa40801 = json.getString("wfa40801");
                this.wfa40803 = json.getString("wfa40803");
                this.wfa40804 = json.getString("wfa40804");
                this.wfa40805 = json.getString("wfa40805");
                this.wfa409 = json.getString("wfa409");
                this.wfa40903x = json.getString("wfa40903x");
                this.wfa40904x = json.getString("wfa40904x");
                this.wfa40905x = json.getString("wfa40905x");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void sWFA05Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.wfa504 = json.getString("wfa504");
                this.wfa505 = json.getString("wfa505");
                this.wfa506 = json.getString("wfa506");
                this.wfa507 = json.getString("wfa507");
                this.wfa508 = json.getString("wfa508");
                this.wfa50801 = json.getString("wfa50801");
                this.wfa50802 = json.getString("wfa50802");
                this.wfa50803 = json.getString("wfa50803");
                this.wfa50804 = json.getString("wfa50804");
                this.wfa50805 = json.getString("wfa50805");
                this.wfa509 = json.getString("wfa509");
                this.wfa50996x = json.getString("wfa50996x");
                this.wfa510 = json.getString("wfa510");
                this.wfa51096x = json.getString("wfa51096x");
                this.wfa511 = json.getString("wfa511");
                this.wfa51196x = json.getString("wfa51196x");
                this.wfa512 = json.getString("wfa512");
                this.wfa51296x = json.getString("wfa51296x");
                this.wfa513 = json.getString("wfa513");
                this.wfa51396x = json.getString("wfa51396x");
                this.wfa514 = json.getString("wfa514");
                this.wfa51401 = json.getString("wfa51401");
                this.wfa51402 = json.getString("wfa51402");
                this.wfa51403 = json.getString("wfa51403");
                this.wfa51404 = json.getString("wfa51404");
                this.wfa515 = json.getString("wfa515");
                this.wfa51596x = json.getString("wfa51596x");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void sWFB01Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.wfb101 = json.getString("wfb101");
                this.wfb102 = json.getString("wfb102");
                this.wfb10296x = json.getString("wfb10296x");
                this.wfb103 = json.getString("wfb103");
                this.wfb104 = json.getString("wfb104");
                this.wfb105 = json.getString("wfb105");
                this.wfi06 = json.getString("wfi06");
                this.wfi0601 = json.getString("wfi0601");
                this.wfi07 = json.getString("wfi07");
                this.wfi0701 = json.getString("wfi0701");
                this.wfi0702 = json.getString("wfi0702");
                this.wfi0796 = json.getString("wfi0796");
                this.wfi0796x = json.getString("wfi0796x");
                this.wfb1081a = json.getString("wfb1081a");
                this.wfb1081b = json.getString("wfb1081b");
                this.wfb1081c = json.getString("wfb1081c");
                this.wfb1081d = json.getString("wfb1081d");
                this.wfb1081d06x = json.getString("wfb1081d06x");
                this.wfb1081d96x = json.getString("wfb1081d96x");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void sWFB02Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.wfb201 = json.getString("wfb201");
                this.wfb202 = json.getString("wfb202");
                this.wfb203 = json.getString("wfb20396x");
                this.wfb20396x = json.getString("");
                this.wfb204 = json.getString("wfb204");
                this.wfb205 = json.getString("wfb205");
                this.wfb20596x = json.getString("wfb20596x");
                this.wfb206 = json.getString("wfb206");
                this.wfb207 = json.getString("wfb207");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void sWFCHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.wfc101 = json.getString("wfc101");
                this.wfc10196x = json.getString("wfc10196x");
                this.wfc102 = json.getString("wfc102");
                this.wfc103 = json.getString("wfc103");
                this.wfc104 = json.getString("wfc104");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void sWFDHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.wfd101 = json.getString("wfd101");
                this.wfd10102x = json.getString("wfd10102x");
                this.wfd102a = json.getString("wfd102a");
                this.wfd102a01x = json.getString("wfd102a01x");
                this.wfd102b = json.getString("wfd102b");
                this.wfd102b01x = json.getString("wfd102b01x");
                this.wfd102c = json.getString("wfd102c");
                this.wfd102c01x = json.getString("wfd102c01x");
                this.wfd102d = json.getString("wfd102d");
                this.wfd102d01x = json.getString("wfd102d01x");
                this.wfd102e = json.getString("wfd102e");
                this.wfd102e01x = json.getString("wfd102e01x");
                this.wfd102f = json.getString("wfd102f");
                this.wfd102f01x = json.getString("wfd102f01x");
                this.wfd102g = json.getString("wfd102g");
                this.wfd102g01x = json.getString("wfd102g01x");
                this.wfd102h = json.getString("wfd102h");
                this.wfd102h01x = json.getString("wfd102h01x");
                this.wfd102i = json.getString("wfd102i");
                this.wfd102i01x = json.getString("wfd102i01x");
                this.wfd102j = json.getString("wfd102j");
                this.wfd102j01x = json.getString("wfd102j01x");
                this.wfd102k = json.getString("wfd102k");
                this.wfd102k01x = json.getString("wfd102k01x");
                this.wfd102l = json.getString("wfd102l");
                this.wfd102l01x = json.getString("wfd102l01x");
                this.wfd102m = json.getString("wfd102m");
                this.wfd102m01x = json.getString("wfd102m01x");
                this.wfd102n = json.getString("wfd102n");
                this.wfd102n01x = json.getString("wfd102n01x");
                this.wfd102o = json.getString("wfd102o");
                this.wfd102o01x = json.getString("wfd102o01x");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void sWFEHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.wfe101 = json.getString("wfe101");
                this.wfe10102x = json.getString("wfe10102x");
                this.wfe102 = json.getString("wfe102");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void sWFFHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.wf101 = json.getString("wf101");
                this.wf10102x = json.getString("wf10102x");
                this.wfi02 = json.getString("wfi02");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
