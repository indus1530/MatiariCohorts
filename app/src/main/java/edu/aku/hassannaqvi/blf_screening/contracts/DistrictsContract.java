package edu.aku.hassannaqvi.blf_screening.contracts;


import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class DistrictsContract {
    private static final String TAG = "Districts_CONTRACT";
    public static String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.mi_covid";

    public static abstract class DistrictsTable implements BaseColumns {

        public static final String TABLE_NAME = "districts";

        public static final String _ID = "_id";
        public static final String COLUMN_PROV = "prov";
        public static final String COLUMN_DIST_ID = "dist_id";
        public static final String COLUMN_ADMIN_UNIT = "admin_unit";

        public static String PATH = "districts";

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH;
        public static Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY)
                .buildUpon().appendPath(PATH).build();

        public static String getMovieKeyFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        public static Uri buildUriWithId(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}