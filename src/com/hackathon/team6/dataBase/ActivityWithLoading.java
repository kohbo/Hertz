package com.hackathon.team6.dataBase;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Handler;
import android.util.Log;

/**
 * Created by Colin on 1/25/2015.
 */
public abstract class ActivityWithLoading extends Activity {

    public static final int TIMEOUT = 5000;

    protected ProgressDialog startLoad(){
        ProgressDialog mDialog = new ProgressDialog(this);
        mDialog.setMessage("Querying Server...");
        mDialog.setCancelable(false);
        mDialog.show();
        setTimeout(TIMEOUT,mDialog);
        return mDialog;
    }

    protected ProgressDialog startLoad(int timeOut){
        ProgressDialog mDialog = new ProgressDialog(this);
        mDialog.setMessage("Querying Server...");
        mDialog.setCancelable(false);
        mDialog.show();
        setTimeout(timeOut,mDialog);
        return mDialog;
    }

    public void setTimeout(long time, final Dialog d){
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try{
                    d.dismiss();
                    onTimeOut();
                }
                catch (Exception e){
                    Log.d("DEBUG","Exception caught on timeout");
                }
            }
        }, time);
    }

    public abstract void onFinishLoad();
    public abstract void onLoadFailed();
    public abstract void onTimeOut();

}
