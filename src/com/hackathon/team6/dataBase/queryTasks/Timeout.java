package com.hackathon.team6.dataBase.queryTasks;

import android.app.Dialog;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by Colin on 1/25/2015.
 */
public class Timeout implements Runnable{

    WeakReference<Dialog> dialogWeakReference;
    WeakReference<ActivityWithLoading> activityWithLoadingWeakReference;
    int time;

    public Timeout(ActivityWithLoading activityWithLoading, Dialog dialog) {
        super();
        this.dialogWeakReference = new WeakReference<Dialog>(dialog);
        this.activityWithLoadingWeakReference = new WeakReference<ActivityWithLoading>(activityWithLoading);
    }

    public void run() {
        try{
            Dialog dialog = dialogWeakReference.get();
            ActivityWithLoading activity = activityWithLoadingWeakReference.get();

            if(dialog != null && activity != null) {
                dialog.dismiss();
                activity.timeOut();
            }
        }
        catch (Exception e){
            Log.d("DEBUG", "Exception caught on timeout");
        }
    }
}
