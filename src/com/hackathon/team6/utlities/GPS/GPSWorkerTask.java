package com.hackathon.team6.utlities.gps;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.hackathon.team6.dataBase.dataType.Transaction;
import com.hackathon.team6.utlities.Utilities;

import java.lang.ref.WeakReference;

public class GPSWorkerTask extends AsyncTask<Void, Void, Void> {

    private final WeakReference<TextView> textViewReference;
    private final WeakReference<Transaction> objectReference;

    Context context;

    float latitude;
    float longitude;

    //The button is used if it needs to call the get address worker thread after this one
    public GPSWorkerTask(TextView textView, Transaction objectReference, Context context) {
        // Use a WeakReference to ensure the ImageView can be garbage collected
        this.textViewReference = new WeakReference<TextView>(textView);
        this.objectReference = new WeakReference<Transaction>(objectReference);
        this.context = context;
    }

    // Gets GPS info as a background task
    //waits until the GPS has been initialized in MyLocationManager
    @Override
    protected Void doInBackground(Void... voids) {

        MyLocationManager.lock.lock();
        try {
            while(MyLocationManager.longitude == 0){
                MyLocationManager.noGPS.await();
            }
            this.longitude = (float)MyLocationManager.longitude;
            this.latitude = (float)MyLocationManager.latitude;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            MyLocationManager.lock.unlock();
        }

        return null;
    }

    // Once complete, see if TextView and Object are still around and set coordinates.
    @Override
    protected void onPostExecute(Void aVoid) {
        final TextView textView = textViewReference.get();
        final Transaction transaction = objectReference.get();
        if (textView != null && transaction != null) {
            transaction.setLatLocation(latitude);
            transaction.setLongLocation(longitude);
            textView.setText(Utilities.formatGPSString(latitude,longitude));
        }

    }



}

