package com.hackathon.team6.dataBase;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.hackathon.team6.dataBase.queryTasks.Timeout;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Colin on 1/25/2015.
 */
public abstract class ActivityWithLoading extends Activity {

    public static final int TIMEOUT = 5000;

    protected List<AsyncTask> tasks;

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
        new Handler().postDelayed(new Timeout(this,d), time);
    }

    public abstract void onFinishLoad();
    public abstract void onLoadFailed();
    public abstract void onTimeOut();

}
