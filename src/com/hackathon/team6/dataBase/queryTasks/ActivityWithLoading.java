package com.hackathon.team6.dataBase.queryTasks;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Colin on 1/25/2015.
 */
public abstract class ActivityWithLoading extends Activity {

    public static final int TIMEOUT = 5000;

    protected List<AsyncTask> tasks;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasks = new ArrayList<AsyncTask>();
    }

    @Override
    protected void onStop() {
        if(tasks != null){
            stopAllTasks();
        }
        super.onStop();
    }

    protected void stopAllTasks(){
        for(AsyncTask asyncTask : tasks){
            asyncTask.cancel(true);
        }
        tasks.clear();
    }

    protected ProgressDialog startLoad(){
        ProgressDialog mDialog = new ProgressDialog(this);
        mDialog.setMessage("Querying Server...");
        mDialog.setCancelable(false);
        mDialog.show();
        setTimeout(TIMEOUT,mDialog);
        return mDialog;
    }

    public void setTimeout(long time, final Dialog d){
        handler = new Handler();
        runnable = new Timeout(this, d);
        handler.postDelayed(runnable, time);
    }

    protected void removeTimer(){
        if(handler != null && runnable != null){
            Log.d("DEBUG", "Callback Removed");
            handler.removeCallbacks(runnable);
        }
    }

    public void finishLoad(){
        removeTimer();
        onFinishLoad();
    }

    public void failLoad(){
        removeTimer();
        onLoadFailed();
    }

    protected abstract void onFinishLoad();
    protected abstract void onLoadFailed();
    protected abstract void onTimeOut();

}
