package edu.aku.hassannaqvi.matiari_cohorts.location

import android.content.Context
import android.content.SharedPreferences
import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.text.format.DateFormat
import edu.aku.hassannaqvi.matiari_cohorts.CONSTANTS

class GPSLocationListener(val context: Context) : LocationListener {
    override fun onLocationChanged(location: Location) {
        val sharedPref: SharedPreferences = context.getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val dt = DateFormat.format("dd-MM-yyyy HH:mm", sharedPref.getString("Time", "0")!!.toLong()).toString()

        val bestLocation = Location("storedProvider")
        bestLocation.accuracy = sharedPref.getString("Accuracy", "0")!!.toFloat()
        bestLocation.time = sharedPref.getString(dt, "0")!!.toLong()
        bestLocation.latitude = sharedPref.getString("Latitude", "0")!!.toFloat().toDouble()
        bestLocation.longitude = sharedPref.getString("Longitude", "0")!!.toFloat().toDouble()

        if (isBetterLocation(location, bestLocation)) {
            editor.putString("Longitude", location.longitude.toString())
            editor.putString("Latitude", location.latitude.toString())
            editor.putString("Accuracy", location.accuracy.toString())
            editor.putString("Time", location.time.toString())
            editor.putString("Elevation", location.altitude.toString())
            val date = DateFormat.format("dd-MM-yyyy HH:mm", location.time.toString().toLong()).toString()
            /*Toast.makeText(context,
                    "GPS Commit! LAT: " + location.longitude.toString() +
                            " LNG: " + location.latitude.toString() +
                            " Accuracy: " + location.accuracy.toString() +
                            " Time: " + date,
                    Toast.LENGTH_SHORT).show()*/
            editor.apply()
        }
    }

    private fun isBetterLocation(location: Location, currentBestLocation: Location?): Boolean {
        if (currentBestLocation == null) {
            // A new location is always better than no location
            return true
        }

        // Check whether the new location fix is newer or older
        val timeDelta = location.time - currentBestLocation.time
        val isSignificantlyNewer = timeDelta > CONSTANTS.TWO_MINUTES
        val isSignificantlyOlder = timeDelta < -CONSTANTS.TWO_MINUTES
        val isNewer = timeDelta > 0

        // If it's been more than two minutes since the current location, use the new location
        // because the user has likely moved
        if (isSignificantlyNewer) {
            return true

            // If the new location is more than two minutes older, it must be worse
        } else if (isSignificantlyOlder) {
            return false
        }

        // Check whether the new location fix is more or less accurate
        val accuracyDelta = (location.accuracy - currentBestLocation.accuracy).toInt()
        val isLessAccurate = accuracyDelta > 0
        val isMoreAccurate = accuracyDelta < 0
        val isSignificantlyLessAccurate = accuracyDelta > 200

        // Check if the old and new location are from the same provider
        val isFromSameProvider = isSameProvider(location.provider,
                currentBestLocation.provider)

        // Determine location quality using a combination of timeliness and accuracy
        return if (isMoreAccurate) {
            true
        } else if (isNewer && !isLessAccurate) {
            true
        } else isNewer && !isSignificantlyLessAccurate && isFromSameProvider
    }

    private fun isSameProvider(provider1: String?, provider2: String?): Boolean {
        return if (provider1 == null) {
            provider2 == null
        } else provider1 == provider2
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }

    override fun onProviderEnabled(provider: String) {
    }

    override fun onProviderDisabled(provider: String) {
    }
}