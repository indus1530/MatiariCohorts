package edu.aku.hassannaqvi.blf_screening.workers;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.aku.hassannaqvi.blf_screening.R;
import edu.aku.hassannaqvi.blf_screening.core.MainApp;

import static edu.aku.hassannaqvi.blf_screening.utils.CreateTable.PROJECT_NAME;

public class DataUpWorkerSL extends Worker {

    private static final Object APP_NAME = PROJECT_NAME;
    private final String TAG = "DataWorker()";
    HttpURLConnection urlConnection;
    private Context mContext;
    private URL serverURL = null;
    private ProgressDialog pd;
    private int length;
    private Data data;

    public DataUpWorkerSL(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    /*
     * This method is responsible for doing the work
     * so whatever work that is needed to be performed
     * we will put it here
     *
     * For example, here I am calling the method displayNotification()
     * It will display a notification
     * So that we will understand the work is executed
     * */

    @NonNull
    @Override
    public Result doWork() {

        Log.d(TAG, "doWork: Starting");
        displayNotification("Screening Log", "Starting Sync");

        StringBuilder result = new StringBuilder();

        URL url = null;
        try {
            if (serverURL == null) {
                url = new URL("http://f38158/blf/api/scrlog.php");
            } else {
                url = serverURL;
            }
            Log.d(TAG, "doWork: Connecting...");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(100000 /* milliseconds */);
            urlConnection.setConnectTimeout(150000 /* milliseconds */);
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("charset", "utf-8");
            urlConnection.setUseCaches(false);
            urlConnection.connect();
            Log.d(TAG, "downloadURL: " + url);

            JSONArray jsonSync = new JSONArray();

            DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());

            JSONObject jsonTable = new JSONObject();
            JSONArray jsonParam = new JSONArray();

            jsonTable.put("table", "screenlog");
            jsonSync.put(MainApp.formsSL.toJSONObject());
            jsonParam
                    .put(jsonTable)
                    .put(jsonSync);

            Log.d(TAG, "Upload Begins: " + jsonParam.toString());


            wr.writeBytes(String.valueOf(jsonParam));
            wr.flush();
            wr.close();

            Log.d(TAG, "doInBackground: " + urlConnection.getResponseCode());

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Log.d(TAG, "Connection Response: " + urlConnection.getResponseCode());
                displayNotification("Screen Log", "Connection Established");

                length = urlConnection.getContentLength();
                Log.d(TAG, "Content Length: " + length);

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);

                }
                displayNotification("Screening Log", "Received Data");
                Log.d(TAG, "doWork(SL): " + result.toString());
            } else {

                Log.d(TAG, "Connection Response (Server Failure): " + urlConnection.getResponseCode());

                data = new Data.Builder()
                        .putString("error", String.valueOf(urlConnection.getResponseCode())).build();
                return Result.failure(data);
            }
        } catch (java.net.SocketTimeoutException e) {
            Log.d(TAG, "doWork (Timeout): " + e.getMessage());
            displayNotification("SL No", "Timeout Error: " + e.getMessage());
            data = new Data.Builder()
                    .putString("error", String.valueOf(e.getMessage())).build();
            return Result.failure(data);

        } catch (IOException | JSONException e) {
            Log.d(TAG, "doWork (IO Error): " + e.getMessage());
            displayNotification("SL No", "IO Error: " + e.getMessage());
            data = new Data.Builder()
                    .putString("error", String.valueOf(e.getMessage())).build();

            return Result.failure(data);

        } finally {
//            urlConnection.disconnect();
        }

        //Do something with the JSON string
        if (result != null) {
            displayNotification("SL NO", "Starting Data Processing");

            //String json = result.toString();
            /*if (json.length() > 0) {*/
            displayNotification("SL NO", "Data Size: " + result.length());


            // JSONArray jsonArray = new JSONArray(json);


            //JSONObject jsonObjectCC = jsonArray.getJSONObject(0);
            data = new Data.Builder()
                    .putString("slno", String.valueOf(result)).build();


            displayNotification("SL No", " SL NO received successfully");
            return Result.success(data);

        } else {
            data = new Data.Builder()
                    .putString("error", String.valueOf(result)).build();
            displayNotification("SL No", "Error Received");
            return Result.failure(data);
        }


    }

    /*
     * The method is doing nothing but only generating
     * a simple notification
     * If you are confused about it
     * you should check the Android Notification Tutorial
     * */
    private void displayNotification(String title, String task) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("scrlog", "BLF", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), "scrlog")
                .setContentTitle(title)
                .setContentText(task)
                .setSmallIcon(R.mipmap.ic_launcher);

        final int maxProgress = 100;
        int curProgress = 0;
        notification.setProgress(length, curProgress, false);

        notificationManager.notify(1, notification.build());
    }
}