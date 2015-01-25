package com.hackathon.team6.utlities;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Utilities {

    /**
     * Checks if the android device has a network service active
     * @param context   context of application needed for the check
     * @return          boolean value if network is active
     */
    public static boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, int id) {
        Toast.makeText(context, context.getResources().getString(id), Toast.LENGTH_SHORT).show();
    }

    /**
     * Formats a GPS string as a two line string
     * @return  the string
     */
    public static String formatGPSString(float latitude, float longitude){
        String line1 = "Latitude: " + latitude;
        String line2 = "Longitude: " + longitude;
        return line1 + "\n" + line2;
    }

}
