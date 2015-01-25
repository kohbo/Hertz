package com.hackathon.team6.activities;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.hackathon.team6.R;
import com.hackathon.team6.dataBase.queryTasks.ActivityWithLoading;
import com.hackathon.team6.dataBase.dataType.Transaction;
import com.hackathon.team6.dataBase.dataType.User;
import com.hackathon.team6.utlities.UnactiveLoad;
import com.hackathon.team6.utlities.Utilities;

public class Home_Page extends ActivityWithLoading {

    public static User userPassing;

    ImageView hertz_logo;

    TextView mUserIC;
    TextView mUserRole;
    //TextView number_of_pictures_field;
    Button mRentalButton;
    Button mReturnButton;
    Button mSalesButton;
    Button mFieldService;
    Button mEquipmentHistory;

    User user;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.Home_Page_Title);
        }

        hertz_logo = (ImageView) findViewById(R.id.HertzLogo);

        //buttons
        mRentalButton = (Button) findViewById(R.id.Rental);
        mReturnButton = (Button) findViewById(R.id.Return);
        mSalesButton = (Button) findViewById(R.id.Sales);
        mFieldService = (Button) findViewById(R.id.FieldService);
        mEquipmentHistory = (Button) findViewById(R.id.EquipmentHistory);
        mUserIC = (TextView) findViewById(R.id.home_page_user_id_textView);
        mUserRole = (TextView) findViewById(R.id.home_page_user_authorization_textView);

        user = userPassing;
        userPassing = null;

        if(user != null) {
            mUserIC.setText(getResources().getString(R.string.Home_Page_user_id_prefix) + " " + user.getId());
            mUserRole.setText(getResources().getString(R.string.Home_Page_user_role_prefix) + " " + user.getCurrentRole().toString());
        }

        mRentalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptForEIC();
            }
        });
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptForEIC();
            }
        });
        mSalesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptForEIC();
            }
        });
        mFieldService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptForEIC();
            }
        });
        mEquipmentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHistory(Transaction.type.Rental);
            }
        });

        disableButtonsByRole(user.getCurrentRole());
    }
    /*
    Generates report of type
     */
    protected void goToCapture(int eic, Transaction.type type){
        Intent intent = new Intent(this,Image_Capture.class);
        startActivity(intent);
    }

    protected void verifyEIC(int eic){
        ProgressDialog mDialog = startLoad();
        UnactiveLoad unactiveLoad = new UnactiveLoad(this,mDialog);
        tasks.add(unactiveLoad);
        unactiveLoad.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void onFinishLoad() {
        goToCapture(999999999, Transaction.type.Rental);
    }

    @Override
    public void onLoadFailed() {
        Utilities.showToast(this,R.string.Error_EIC_not_found);
    }

    @Override
    public void onTimeOut() {
        Utilities.showToast(this,R.string.Error_timeout);
        for(AsyncTask asyncTask : tasks){
            asyncTask.cancel(true);
        }
        tasks.clear();
    }

    private void promptForEIC(){
        String title = getResources().getString(R.string.Home_Page_Dialog_Capture_title);
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        alert.setView(input);
        alert.setTitle(title);
        alert.setNegativeButton(R.string.Home_Page_Dialog_Capture_negative, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });
        alert.setPositiveButton(R.string.Home_Page_Dialog_Capture_positive, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                verifyEIC(Integer.parseInt(input.getText().toString()));
            }
        });
        final AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    protected void goToHistory(Transaction.type type){
        Utilities.showToast(this,"Not yet implemented");
    }

    protected void disableButtonsByRole(User.role role){
        switch (role){
            case Retail:
                //mSalesButton.setVisibility(View.GONE);
                //mFieldService.setVisibility(View.GONE);
                break;
            case Sales:
                mRentalButton.setVisibility(View.GONE);
                mFieldService.setVisibility(View.GONE);
                break;
            case Service:
                mReturnButton.setVisibility(View.GONE);
                mRentalButton.setVisibility(View.GONE);
                mSalesButton.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }
}

