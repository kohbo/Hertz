package com.hackathon.team6.dataBase.queryTasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.hackathon.team6.dataBase.dataType.Transaction;

import java.lang.ref.WeakReference;

/**
 * Created by Colin on 1/25/2015.
 */
public class getTransactionsWorker extends AsyncTask<Void, Void, Void> {

    WeakReference<ProgressDialog> toDismiss;
    WeakReference<ActivityWithLoading> onFinish;

    int eic;
    Transaction transaction;

    public getTransactionsWorker(ActivityWithLoading home_page, ProgressDialog progressDialog, int eic) {
        super();
        toDismiss = new WeakReference<ProgressDialog>(progressDialog);
        onFinish = new WeakReference<ActivityWithLoading>(home_page);
        this.eic = eic;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        //transaction = DataBase.validateUser(id,pass);
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
            if(transaction != null){
                //Image_Capture.transactionPassing = transaction;
                home_page.finishLoad(ActivityWithLoading.REQUEST_CODE_TRANSACTION);
            }
            else {
                home_page.failLoad();
            }
        }
    }
}
