package edu.aku.hassannaqvi.blf_screening.ui.other;

import android.app.ActivityManager;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import edu.aku.hassannaqvi.blf_screening.R;
import edu.aku.hassannaqvi.blf_screening.core.AndroidDatabaseManager;
import edu.aku.hassannaqvi.blf_screening.core.MainApp;
import edu.aku.hassannaqvi.blf_screening.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.blf_screening.models.VersionApp;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionEN01Activity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionSFActivity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionSLActivity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionWFA01Activity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionWFA02Activity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionWFA03Activity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionWFA04Activity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionWFA05Activity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionWFB01Activity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionWFB02Activity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionWFCActivity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionWFDActivity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionWFEActivity;
import edu.aku.hassannaqvi.blf_screening.ui.sections.SectionWFFActivity;
import edu.aku.hassannaqvi.blf_screening.utils.AndroidUtilityKt;
import edu.aku.hassannaqvi.blf_screening.utils.AppUtilsKt;
import edu.aku.hassannaqvi.blf_screening.utils.CreateTable;
import edu.aku.hassannaqvi.blf_screening.utils.WarningActivityInterface;

import static edu.aku.hassannaqvi.blf_screening.core.MainApp.appInfo;

public class MainActivity extends AppCompatActivity implements WarningActivityInterface {

    static File file;
    ActivityMainBinding bi;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    String sysdateToday = new SimpleDateFormat("dd-MM-yy").format(new Date());
    SharedPreferences sharedPrefDownload;
    SharedPreferences.Editor editorDownload;
    DownloadManager downloadManager;
    String preVer = "", newVer = "";
    VersionApp versionApp;
    Long refID;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.getAction())) {

                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(sharedPrefDownload.getLong("refID", 0));

                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                assert downloadManager != null;
                Cursor cursor = downloadManager.query(query);
                if (cursor.moveToFirst()) {
                    int colIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                    if (DownloadManager.STATUS_SUCCESSFUL == cursor.getInt(colIndex)) {

                        editorDownload.putBoolean("flag", true);
                        editorDownload.commit();

                        Toast.makeText(context, "New App downloaded!!", Toast.LENGTH_SHORT).show();
                        bi.lblAppVersion.setText(new StringBuilder(getString(R.string.app_name) + " App New Version ").append(newVer).append("  Downloaded"));

                        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);

                        if (Objects.requireNonNull(taskInfo.get(0).topActivity).getClassName().equals(MainActivity.class.getName())) {
                            showDialog(newVer, preVer);
                        }
                    }
                }
            }
        }
    };
    private Boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);

/*        bi.srclog.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Screen Log", Toast.LENGTH_LONG).show();

            }
        });*/

       /* bi.txtinstalldate.setText(appInfo.getAppInfo());
        Collection<FormsSL> todaysForms = appInfo.getDbHelper().getTodayForms(sysdateToday);
        Collection<FormsSL> unsyncedForms = appInfo.getDbHelper().getUnsyncedForms();
        Collection<FormsSL> unclosedForms = appInfo.getDbHelper().getUnclosedForms();

        StringBuilder rSumText = new StringBuilder()
                .append("TODAY'S RECORDS SUMMARY\r\n")
                .append("=======================\r\n")
                .append("\r\n")
                .append("Total Forms Today" + "(").append(dtToday).append("): ").append(todaysForms.size()).append("\r\n");
        String TAG = "MainActivity";
        if (todaysForms.size() > 0) {
            String iStatus;
            rSumText.append("---------------------------------------------------------\r\n")
                    .append("[District   ][Ref. No][Name   ][FormsSL Status][Sync Status]\r\n")
                    .append("---------------------------------------------------------\r\n");

            for (FormsSL form : todaysForms) {
                Log.d(TAG, "onCreate: '" + form.getIstatus() + "'");
                switch (form.getIstatus()) {
                    case "1":
                        iStatus = " Complete                                          ";
                        break;
                    case "2":
                        iStatus = " Individual not identified                         ";
                        break;
                    case "3":
                        iStatus = " Household not identified                          ";
                        break;
                    case "4":
                        iStatus = " Locked                                            ";
                        break;
                    case "5":
                        iStatus = " No competentrespondent at home                    ";
                        break;
                    case "6":
                        iStatus = " Entire household absent for extended period of time";
                        break;
                    case "7":
                        iStatus = " Refused                                           ";
                        break;
                    case "8":
                        iStatus = " Phone could not be contacted                      ";
                        break;
                    case "96":
                        iStatus = " Other                                             ";
                        break;
                   *//* case "":
                        iStatus = " Open                                              ";
                        break;*//*
                    default:
                        iStatus = " - N/A -                                           " + form.getIstatus();
                }

                rSumText
                        .append(" ")
                        .append((form.getA05() + "             ").substring(0, 12))
                        .append((form.getRefno() + "         ").substring(0, 9))
                        .append((form.getA08() + "         ").substring(0, 9))
                        .append(iStatus.substring(0, 13))
                        .append(form.getSynced() == null ? "Not Synced" : "Synced    ")
                        .append("\r\n")
                        .append("---------------------------------------------------------\r\n");
            }
        }
        SharedPreferences syncPref = getSharedPreferences("src", Context.MODE_PRIVATE);
        rSumText.append("\r\nDEVICE INFORMATION\r\n")
                .append("  ========================================================\r\n")
                *//* .append("\t|| Open Forms: \t\t\t\t\t\t").append(String.format("%02d", unclosedForms.size()))
                 .append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t||\r\n")*//*
                .append("\t|| Unsynced Forms: \t\t\t\t").append(String.format("%02d", unsyncedForms.size()))
                .append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t||\r\n")
                .append("\t|| Last Data Download: \t\t").append(syncPref.getString("LastDataDownload", "Never Downloaded   "))
                .append("\t\t\t\t\t\t||\r\n")
                .append("\t|| Last Data Upload: \t\t\t").append(syncPref.getString("LastDataUpload", "Never Uploaded     "))
                .append("\t\t\t\t\t\t||\r\n")
                *//*  .append("\t|| Last Photo Upload: \t\t").append(syncPref.getString("LastPhotoUpload", "Never Uploaded     "))
                  .append("\t\t\t\t\t\t||\r\n")*//*
                .append("\t========================================================\r\n");
        bi.recordSummary.setText(rSumText);

        Log.d(TAG, "onCreate: " + rSumText);
        */
        if (MainApp.admin) {
            bi.databaseBtn.setVisibility(View.VISIBLE);
        } else {
            bi.databaseBtn.setVisibility(View.GONE);
        }

        // Auto download app
        sharedPrefDownload = getSharedPreferences("appDownload", MODE_PRIVATE);
        editorDownload = sharedPrefDownload.edit();
        versionApp = appInfo.getDbHelper().getVersionApp();
        if (versionApp.getVersioncode() != null) {

            preVer = appInfo.getVersionName() + "." + appInfo.getVersionCode();
            newVer = versionApp.getVersionname() + "." + versionApp.getVersioncode();

            if (appInfo.getVersionCode() < Integer.parseInt(versionApp.getVersioncode())) {
                bi.lblAppVersion.setVisibility(View.VISIBLE);

                String fileName = CreateTable.DATABASE_NAME.replace(".db", "-New-Apps");
                file = new File(Environment.getExternalStorageDirectory() + File.separator + fileName, versionApp.getPathname());

                if (file.exists()) {
                    bi.lblAppVersion.setText(new StringBuilder(getString(R.string.app_name) + " New Version ").append(newVer).append("  Downloaded"));
                    showDialog(newVer, preVer);
                } else {
                    NetworkInfo networkInfo = ((ConnectivityManager) Objects.requireNonNull(getSystemService(Context.CONNECTIVITY_SERVICE))).getActiveNetworkInfo();
                    if (networkInfo != null && networkInfo.isConnected()) {
                        bi.lblAppVersion.setText(new StringBuilder(getString(R.string.app_name) + " App New Version ").append(newVer).append("  Downloading.."));
                        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                        Uri uri = Uri.parse(MainApp._UPDATE_URL + versionApp.getPathname());
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setDestinationInExternalPublicDir(fileName, versionApp.getPathname())
                                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                                .setTitle("Downloading " + getString(R.string.app_name) + " App new App ver." + newVer);
                        refID = downloadManager.enqueue(request);

                        editorDownload.putLong("refID", refID);
                        editorDownload.putBoolean("flag", false);
                        editorDownload.apply();

                    } else {
                        bi.lblAppVersion.setText(new StringBuilder(getString(R.string.app_name) + " App New Version ").append(newVer).append("  Available..\n(Can't download.. Internet connectivity issue!!)"));
                    }
                }

            } else {
                bi.lblAppVersion.setVisibility(View.GONE);
                bi.lblAppVersion.setText(null);
            }
        }
        registerReceiver(broadcastReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

//        Testing visibility
        if (Integer.parseInt(appInfo.getVersionName().split("\\.")[0]) > 0) {
            bi.testing.setVisibility(View.GONE);
        } else {
            bi.testing.setVisibility(View.VISIBLE);
        }

    }

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.onSync:
                intent = new Intent(MainActivity.this, SyncActivity.class);
                break;
          *//*  case R.id.checkOpenForms:
                intent = new Intent(MainActivity.this, PendingFormsActivity.class);
                break;*//*
            case R.id.formsReportDate:
                intent = new Intent(MainActivity.this, FormsReportDate.class);
                break;
            case R.id.formsReportCluster:
                intent = new Intent(MainActivity.this, FormsReportCluster.class);
                break;
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public void callWarningActivity() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }

    private void showDialog(String newVer, String preVer) {
        AppUtilsKt.openWarningActivity(
                this,
                getString(R.string.app_name) + " APP is available!",
                getString(R.string.app_name) + " App Ver." + newVer + " is now available. Your are currently using older Ver." + preVer + ".\nInstall new version to use this app.",
                "Install",
                "Cancel"
        );
    }

    public void openSpecificActivity(View v) {
        Intent oF = null;
        switch (v.getId()) {
            case R.id.srclog:
                oF = new Intent(this, SectionSLActivity.class);
                break;
            case R.id.formScr:
                oF = new Intent(this, SectionSFActivity.class);
                break;
            case R.id.formEnr:
                oF = new Intent(this, SectionEN01Activity.class);
                break;
            case R.id.formWF:
                oF = new Intent(this, SectionWFA01Activity.class);
                break;
            case R.id.secWFA01:
                oF = new Intent(this, SectionWFA01Activity.class);
                break;
            case R.id.secWFA02:
                oF = new Intent(this, SectionWFA02Activity.class);
                break;
            case R.id.secWFA03:
                oF = new Intent(this, SectionWFA03Activity.class);
                break;
            case R.id.secWFA04:
                oF = new Intent(this, SectionWFA04Activity.class);
                break;
            case R.id.secWFA05:
                oF = new Intent(this, SectionWFA05Activity.class);
                break;
            case R.id.secWFB01:
                oF = new Intent(this, SectionWFB01Activity.class);
                break;
            case R.id.secWFB02:
                oF = new Intent(this, SectionWFB02Activity.class);
                break;
            case R.id.secWFC:
                oF = new Intent(this, SectionWFCActivity.class);
                break;
            case R.id.secWFD:
                oF = new Intent(this, SectionWFDActivity.class);
                break;
            case R.id.secWFE:
                oF = new Intent(this, SectionWFEActivity.class);
                break;
            case R.id.secWFF:
                oF = new Intent(this, SectionWFFActivity.class);
                break;
            case R.id.databaseBtn:
                oF = new Intent(this, AndroidDatabaseManager.class);
                break;
            case R.id.uploadData:
                if (!AndroidUtilityKt.isNetworkConnected(this)) {
                    Toast.makeText(this, "No network connection available!", Toast.LENGTH_SHORT).show();
                    return;
                }
                oF = new Intent(this, SyncActivity.class);
                break;
        }
        startActivity(oF);
    }

    public void toggleSummary(View view) {

        if (bi.recordSummary.getVisibility() == View.VISIBLE) {
            bi.recordSummary.setVisibility(View.GONE);
        } else {
            bi.recordSummary.setVisibility(View.VISIBLE);
        }
    }
}
