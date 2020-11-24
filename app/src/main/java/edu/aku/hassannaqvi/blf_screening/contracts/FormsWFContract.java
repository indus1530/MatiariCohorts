package edu.aku.hassannaqvi.blf_screening.contracts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsWFContract {

    public static String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.blf.screening";

    public static abstract class FormsWFTable implements BaseColumns {
        public static final String TABLE_NAME = "formsWf";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_SYSDATE = "sysdate";
        //  public static final String COLUMN_ISTATUS = "istatus";
        //    public static final String COLUMN_ISTATUS96x = "istatus96x";
        //  public static final String COLUMN_ENDINGDATETIME = "endingdatetime";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDATE = "gpsdate";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_SWFA01 = "sWFA01";
        public static final String COLUMN_SWFA02 = "sWFA02";
        public static final String COLUMN_SWFA03 = "sWFA03";
        public static final String COLUMN_SWFA04 = "sWFA04";
        public static final String COLUMN_SWFA05 = "sWFA05";
        public static final String COLUMN_SWFB01 = "sWFB01";
        public static final String COLUMN_SWFB02 = "sWFB02";
        public static final String COLUMN_SWFC = "sWFC";
        public static final String COLUMN_SWFD = "sWFD";
        public static final String COLUMN_SWFE = "sWFE";
        public static final String COLUMN_SWFF = "sWFF";
        public static String PATH = "formswf";
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH;
        public static Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY)
                .buildUpon().appendPath(PATH).build();
        public static String SERVER_URL = "sync.php";


        public static String getMovieKeyFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        public static Uri buildUriWithId(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
