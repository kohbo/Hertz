package com.hackathon.team6.dataBase.queryTasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.hackathon.team6.activities.History_Activity;
import com.hackathon.team6.dataBase.DataBase;
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
        transactions = DataBase.getInstance().queryEquipment(eic);
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
                History_Activity.transactions = transactions;
                home_page.finishLoad(ActivityWithLoading.REQUEST_CODE_LIST);
            }
            else {
                home_page.failLoad();
            }
        }
    }
}
