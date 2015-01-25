package com.hackathon.team6.utlities.gps;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import com.hackathon.team6.R;
import com.hackathon.team6.dataBase.dataType.Transaction;
import com.hackathon.team6.utlities.Utilities;
import com.hackathon.team6.utlities.image.Image_Activity;

public abstract class GPSActivity extends Image_Activity {

    LocationManager mlocManager;
    LocationListener mlocListener;

    @Override
    protected void onStart() {
        super.onStart();
        initializeGPS();
    }

    @Override
    protected void onStop() {
        stopGPS();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setLoading(TextView tv){
        tv.setText(getResources().getString(R.string.Capture_Screen_GPS_loading));
    }

    protected void setNewGPS(TextView tv, Transaction transaction){
        setLoading(tv);
        GPSWorkerTask task = new GPSWorkerTask(tv,transaction,this);
        tasks.add(task);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private void initializeGPS(){

        mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        mlocListener = new MyLocationManager(mlocManager);

        String provider = null;

        if((mlocManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) && Utilities.isOnline(this))){
            provider = LocationManager.NETWORK_PROVIDER;
        }
        else if(mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            provider = LocationManager.GPS_PROVIDER;
        }
        else{
            Utilities.showToast(this,R.string.Error_GPS);
        }

        if(provider != null){
            Criteria criteria = new Criteria();
            mlocManager.requestLocationUpdates(provider , 0, 0, mlocListener);
        }

    }

    private void stopGPS(){
        if(mlocListener != null){
            mlocManager.removeUpdates(mlocListener);
        }
        mlocListener = null;
        mlocManager = null;
    }

}

