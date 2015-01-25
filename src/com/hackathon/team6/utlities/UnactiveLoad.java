package com.hackathon.team6.utlities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.hackathon.team6.dataBase.ActivityWithLoading;

import java.lang.ref.WeakReference;

/**
 * Created by Colin on 1/25/2015.
 */
public class UnactiveLoad extends AsyncTask<Void, Void, Void> {

    WeakReference<ProgressDialog> toDismiss;
    WeakReference<ActivityWithLoading> onFinish;

    public UnactiveLoad(ActivityWithLoading home_page, ProgressDialog progressDialog) {
        super();
        toDismiss = new WeakReference<ProgressDialog>(progressDialog);
        onFinish = new WeakReference<ActivityWithLoading>(home_page);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e) {}
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ProgressDialog progressDialog = toDismiss.get();
        if(progressDialog != null){
            progressDialog.dismiss();
        }

        ActivityWithLoading home_page = onFinish.get();
        if(home_page != null){
            if(true){
                home_page.onFinishLoad();
            }
            else {
                home_page.onLoadFailed();
            }
        }
    }
}
