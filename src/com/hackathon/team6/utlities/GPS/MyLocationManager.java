package com.hackathon.team6.utlities.gps;

import android.location.*;
import android.os.Bundle;
import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLocationManager implements LocationListener, GpsStatus.Listener {

    public static double latitude;
    public static double longitude;
    public static double altitude;



    public static boolean hasAltitude;

    //how many satellites are currently visible?
    //used for calculating if altitude is doable or if a Network Provider should be used
    public static int gpsSatsAvailable;

    public static Lock lock = new ReentrantLock();
    public static Condition noGPS = lock.newCondition();

    final private LocationManager locationManager;

    public MyLocationManager(LocationManager locationManager) {
        super();
        MyLocationManager.longitude = 0.0;
        MyLocationManager.latitude = 0.0;
        MyLocationManager.altitude = 0.0;
        MyLocationManager.hasAltitude = false;
        this.locationManager = locationManager;
    }

    @Override
    public void onLocationChanged(Location loc)
    {
        lock.lock();
        loc.getLatitude();
        loc.getLongitude();
        loc.getAltitude();
        latitude=loc.getLatitude();
        longitude=loc.getLongitude();
        altitude=loc.getAltitude();
        hasAltitude = loc.hasAltitude();
        noGPS.signal();
        lock.unlock();
    }

    @Override
    public void onGpsStatusChanged(final int event) {
        switch( event ) {
            // ...
            case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
                updateSats();
                break;
        }
    }

    /**
     * Set the no. of available satellites.
     */
    public void updateSats() {
        final GpsStatus gs = locationManager.getGpsStatus(null);
        int i = 0;
        final Iterator<GpsSatellite> it = gs.getSatellites().iterator();
        while( it.hasNext() ) {
            it.next();
            i += 1;
        }
        this.gpsSatsAvailable = i;
    }

    @Override
    public void onProviderDisabled(String provider)
    {
        //print "Currently GPS is Disabled";
    }
    @Override
    public void onProviderEnabled(String provider)
    {
        //print "GPS got Enabled";
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {
    }

}