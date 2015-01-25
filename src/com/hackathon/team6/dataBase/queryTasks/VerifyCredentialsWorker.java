package com.hackathon.team6.dataBase.queryTasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.hackathon.team6.activities.Home_Page;
import com.hackathon.team6.dataBase.DataBase;
import com.hackathon.team6.dataBase.dataType.User;

import java.lang.ref.WeakReference;

/**
 * Created by Colin on 1/25/2015.
 */
public class VerifyCredentialsWorker extends AsyncTask<Void, Void, Void> {

    WeakReference<ProgressDialog> toDismiss;
    WeakReference<ActivityWithLoading> onFinish;

    int id;
    String pass;
    User user;

    public VerifyCredentialsWorker(ActivityWithLoading home_page, ProgressDialog progressDialog, int id, String pass) {
        super();
        toDismiss = new WeakReference<ProgressDialog>(progressDialog);
        onFinish = new WeakReference<ActivityWithLoading>(home_page);
        this.id = id;
        this.pass = pass;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        user = DataBase.validateUser(id, pass);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ProgressDialog progressDialog = toDismiss.get();
        if (progressDialog != null) {
            progressDialog.dismiss();
        }

        ActivityWithLoading home_page = onFinish.get();
        if (home_page != null) {
            if (user != null) {
                Home_Page.user = user;
                home_page.finishLoad(ActivityWithLoading.REQUEST_CODE_USER);
            } else {
                home_page.failLoad();
            }
        }
    }
}
