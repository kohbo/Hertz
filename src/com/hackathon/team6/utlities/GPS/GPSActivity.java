package com.hackathon.team6.utlities.gps;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import com.hackathon.team6.R;
import com.hackathon.team6.utlities.Utilities;

public abstract class GPSActivity extends Activity {

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

    protected void setLoading(TextView tv){
        tv.setText(getResources().getString(R.string.Capture_Screen_GPS_loading));
    }

    private void initializeGPS(){

        mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        mlocListener = new MyLocationManager(mlocManager);

        if(mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                (mlocManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) && Utilities.isOnline(this))){
            String provider;
            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_FINE);
            criteria.setHorizontalAccuracy(Criteria.ACCURACY_HIGH);
            criteria.setVerticalAccuracy(Criteria.ACCURACY_HIGH);
            criteria.setAltitudeRequired(true);
            provider = mlocManager.getBestProvider(criteria,true);
            mlocManager.requestLocationUpdates(provider , 0, 0, mlocListener);
        }
        else{
            Utilities.showToast(this,R.string.Error_GPS);
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

