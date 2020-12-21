package edu.aku.hassannaqvi.matiari_cohorts.ui.other;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import edu.aku.hassannaqvi.matiari_cohorts.CONSTANTS;
import edu.aku.hassannaqvi.matiari_cohorts.R;
import edu.aku.hassannaqvi.matiari_cohorts.adapter.SyncListAdapter;
import edu.aku.hassannaqvi.matiari_cohorts.contracts.FormsContract;
import edu.aku.hassannaqvi.matiari_cohorts.core.DatabaseHelper;
import edu.aku.hassannaqvi.matiari_cohorts.core.MainApp;
import edu.aku.hassannaqvi.matiari_cohorts.databinding.ActivitySyncBinding;
import edu.aku.hassannaqvi.matiari_cohorts.models.Forms;
import edu.aku.hassannaqvi.matiari_cohorts.models.SyncModel;
import edu.aku.hassannaqvi.matiari_cohorts.sync.GetAllData;
import edu.aku.hassannaqvi.matiari_cohorts.sync.SyncAllData;
import edu.aku.hassannaqvi.matiari_cohorts.sync.SyncAllPhotos;
import edu.aku.hassannaqvi.matiari_cohorts.sync.SyncDevice;

import static edu.aku.hassannaqvi.matiari_cohorts.utils.AppUtilsKt.dbBackup;
import static edu.aku.hassannaqvi.matiari_cohorts.utils.CreateTable.PROJECT_NAME;

public class SyncActivity extends AppCompatActivity implements SyncDevice.SyncDeviceInterface {
    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;
    DatabaseHelper db;
    SyncListAdapter syncListAdapter;
    ActivitySyncBinding bi;
    SyncModel model;
    SyncModel uploadmodel;
    List<SyncModel> list;
    List<SyncModel> uploadlist;
    Boolean listActivityCreated;
    Boolean uploadlistActivityCreated;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    private boolean sync_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_sync);
        bi.setCallback(this);
        list = new ArrayList<>();
        uploadlist = new ArrayList<>();
        //bi.noItem.setVisibility(View.VISIBLE);
        bi.noDataItem.setVisibility(View.VISIBLE);
        listActivityCreated = true;
        uploadlistActivityCreated = true;
        sharedPref = getSharedPreferences("src", MODE_PRIVATE);
        editor = sharedPref.edit();
        db = new DatabaseHelper(this);
        dbBackup(this);

        sync_flag = getIntent().getBooleanExtra(CONSTANTS.SYNC_LOGIN, false);

        bi.btnSync.setOnClickListener(v -> onSyncDataClick());
        bi.btnUpload.setOnClickListener(v -> syncServer());
        // setAdapter();
        setUploadAdapter();
    }

    public void onSyncDataClick() {

        bi.activityTitle.setText("Download Data");
        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (sync_flag) new SyncData(SyncActivity.this, MainApp.DIST_ID).execute(true);
            else new SyncDevice(SyncActivity.this, true).execute();
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }

    void setUploadAdapter() {
        syncListAdapter = new SyncListAdapter(uploadlist);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        bi.rvUploadList.setLayoutManager(mLayoutManager2);
        bi.rvUploadList.setItemAnimator(new DefaultItemAnimator());
        bi.rvUploadList.setAdapter(syncListAdapter);
        syncListAdapter.notifyDataSetChanged();
        if (syncListAdapter.getItemCount() > 0) {
            bi.noDataItem.setVisibility(View.GONE);
        } else {
            bi.noDataItem.setVisibility(View.VISIBLE);
        }
    }

    public void syncServer() {
        bi.activityTitle.setText("Upload Data");

//        if(true) return;

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            DatabaseHelper db = new DatabaseHelper(this);

            new SyncDevice(this, false).execute();
//  *******************************************************Forms*********************************
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Forms",
                    "updateSyncedForms",
                    Forms.class,
                    MainApp._HOST_URL + MainApp._SERVER_URL,
                    FormsContract.FormsTable.TABLE_NAME,
                    db.getUnsyncedForms(), 0, syncListAdapter, uploadlist
            ).execute();

            bi.noDataItem.setVisibility(View.GONE);

            uploadlistActivityCreated = false;

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastDataUpload", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            editor.apply();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void processFinish(boolean flag) {
        if (flag) {
            MainApp.appInfo.updateTagName(SyncActivity.this);
            new SyncData(SyncActivity.this, MainApp.DIST_ID).execute(sync_flag);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_OK);
        finish();
    }

    public void uploadPhotos(View view) {

        String fileName = "";
        String appFolder = PROJECT_NAME;

        File sdDir = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        Log.d("Files", "Path: " + sdDir);
        File directory = new File(String.valueOf(sdDir), appFolder);
        Log.d("Directory", "uploadPhotos: " + directory);
        if (directory.exists()) {
            File[] files = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return (file.getPath().endsWith(".jpg") || file.getPath().endsWith(".jpeg"));
                }
            });


            Log.d("Files", "Count: " + files.length);
            if (files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    Log.d("Files", "FileName:" + files[i].getName());
                    SyncAllPhotos syncAllPhotos = new SyncAllPhotos(files[i].getName(), this);
                    syncAllPhotos.execute();

                    try {
                        //3000 ms delay to process upload of next file.
                        Thread.sleep(3000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                editor.putString("LastPhotoUpload", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
                editor.apply();
            } else {
                Toast.makeText(this, "No photos to upload.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No photos were taken", Toast.LENGTH_SHORT).show();
        }

    }

    private class SyncData extends AsyncTask<Boolean, String, String> {

        private final Context mContext;
        private final String distID;

        private SyncData(Context mContext, String districtId) {
            this.mContext = mContext;
            this.distID = districtId;
        }

        @Override
        protected String doInBackground(Boolean... booleans) {
            runOnUiThread(() -> {

//                if (booleans[0]) {
//                  getting Users
                    if (listActivityCreated) {
                        model = new SyncModel();
                        model.setstatusID(0);
                        list.add(model);
                    }
                    new GetAllData(mContext, "Users", syncListAdapter, list).execute();

//                    Getting App Version
                    if (listActivityCreated) {
                        model = new SyncModel();
                        model.setstatusID(0);
                        list.add(model);
                    }
                    new GetAllData(mContext, "VersionApp", syncListAdapter, list).execute();

//                    Getting ChildList
                    if (listActivityCreated) {
                        model = new SyncModel();
                        model.setstatusID(0);
                        list.add(model);
                    }
                    new GetAllData(mContext, "ChildList", syncListAdapter, list).execute();

//                    Getting ChildList
                    if (listActivityCreated) {
                        model = new SyncModel();
                        model.setstatusID(0);
                        list.add(model);
                    }
                    new GetAllData(mContext, "Villages", syncListAdapter, list).execute();

//                }

                listActivityCreated = false;
            });

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(() -> {
                editor.putString("LastDataDownload", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).format(new Date()));
                editor.apply();
            }, 1200);
        }
    }
}
