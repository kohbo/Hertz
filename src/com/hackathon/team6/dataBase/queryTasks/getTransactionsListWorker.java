package com.hackathon.team6.dataBase.queryTasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.hackathon.team6.dataBase.dataType.Transaction;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Colin on 1/25/2015.
 */
public class getTransactionsListWorker extends AsyncTask<Void, Void, Void> {

    WeakReference<ProgressDialog> toDismiss;
    WeakReference<ActivityWithLoading> onFinish;

    int eic;
    List<Transaction> transactions;

    public getTransactionsListWorker(ActivityWithLoading home_page, ProgressDialog progressDialog, int eic) {
        super();
        toDismiss = new WeakReference<ProgressDialog>(progressDialog);
        onFinish = new WeakReference<ActivityWithLoading>(home_page);
        this.eic = eic;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        //transactions = DataBase.validateUser(id,pass);
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
            if(transactions != null){
                //Image_Capture.transactionPassing = transaction;
                home_page.finishLoad();
            }
            else {
                home_page.failLoad();
            }
        }
    }
}
