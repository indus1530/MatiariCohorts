package edu.aku.hassannaqvi.matiari_cohorts.workers;

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

import edu.aku.hassannaqvi.matiari_cohorts.R;
import edu.aku.hassannaqvi.matiari_cohorts.core.DatabaseHelper;
import edu.aku.hassannaqvi.matiari_cohorts.core.MainApp;

import static edu.aku.hassannaqvi.matiari_cohorts.utils.CreateTable.PROJECT_NAME;

public class FetchUsersWorker extends Worker {

    private static final Object APP_NAME = PROJECT_NAME;
    private final String TAG = "FetchUsersWorker()";
    HttpURLConnection urlConnection;
    private Context mContext;
    private URL serverURL = null;
    private ProgressDialog pd;
    private int length;
    private Data data;

    public FetchUsersWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
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

//      getStringExtra :: input data from calling code
//        String inputData = getInputData().getString("KEY_HERE");

        Log.d(TAG, "doInBackground: Starting");
        displayNotification("Users", "Starting Sync");

        StringBuilder result = new StringBuilder();

        URL url = null;
        try {
            Log.d(TAG, "doInBackground: Trying...");
            if (serverURL == null) {
                url = new URL("http://f38158/blf/api/getData.php");
            } else {
                url = serverURL;
            }
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


            DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
            JSONObject json = new JSONObject();
            try {
                json.put("table", "users");
                //json.put("select", "sl2, sl4, sl5, sf6a");
                //json.put("filter", "sl4 = '" + MainApp.sf2 + "'");
            } catch (JSONException e1) {
                e1.printStackTrace();
                Log.d(TAG, "doWork: " + e1.getMessage());
            }

            //================
            Log.d(TAG, "doWork: " + json);

            wr.writeBytes(String.valueOf(json));
            wr.flush();
            wr.close();
            Log.d(TAG, "doInBackground: " + urlConnection.getResponseCode());
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                displayNotification("Users", "Connection Established");

                length = urlConnection.getContentLength();

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    Log.i(TAG, "Users: " + line);
                    result.append(line);
                    displayNotification("Users", line);

                }
            }
        } catch (java.net.SocketTimeoutException e) {
            Log.d(TAG, "doWork (Timeout): " + e.getMessage());
            displayNotification("Users", "Timeout Error: " + e.getMessage());
            data = new Data.Builder()
                    .putString("error", String.valueOf(e.getMessage())).build();
            return Result.failure(data);

        } catch (IOException e) {
            Log.d(TAG, "doWork (IO Error): " + e.getMessage());
            displayNotification("Users", "IO Error: " + e.getMessage());
            data = new Data.Builder()
                    .putString("error", String.valueOf(e.getMessage())).build();

            return Result.failure(data);

        } finally {
//            urlConnection.disconnect();
        }

        Log.d(TAG, "onPostExecute: Starting");
        displayNotification("Users", "Received Data");
        //Do something with the JSON string
        Data data = null;
        if (result != null) {
            displayNotification("Users", "Starting Data Processing");

            displayNotification("Users", "Data Size: " + result.length());

            int retResult = updateDB(result.toString());

            return retResult > 0 ? Result.success() : Result.failure();


        } else {

            displayNotification("Users", "Error Received");
            return Result.failure();
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
            NotificationChannel channel = new NotificationChannel("simplifiedcoding", "simplifiedcoding", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), "simplifiedcoding")
                .setContentTitle(title)
                .setContentText(task)
                .setSmallIcon(R.mipmap.ic_launcher);

        final int maxProgress = 100;
        int curProgress = 0;
        notification.setProgress(length, curProgress, false);

        notificationManager.notify(1, notification.build());
    }

    private int updateDB(String result) {

        //Do something with the JSON string
        if (result != null) {
            if (result.length() > 0) {
                DatabaseHelper db = MainApp.appInfo.getDbHelper();
                try {
                    JSONArray jsonArray = new JSONArray();
                    int insertCount = 0;

                    jsonArray = new JSONArray(result);
                    insertCount = db.syncUser(jsonArray);


                    displayNotification("Users", "Received: " + jsonArray.length() + ", Saved: " + insertCount);
                    return insertCount;
                } catch (JSONException e) {
                    Log.d(TAG, "updateDB: " + e.getMessage());
                    displayNotification("Users", e.getMessage());

                }
            } else {

                displayNotification("Users", "Received: " + result.length() + "");


            }
        } else {

            displayNotification("Users", "Server not found!");

        }
        return 0;
    }


}