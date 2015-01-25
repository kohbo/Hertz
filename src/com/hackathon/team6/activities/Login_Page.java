package com.hackathon.team6.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.hackathon.team6.R;
import com.hackathon.team6.dataBase.ActivityWithLoading;
import com.hackathon.team6.dataBase.DataBase;
import com.hackathon.team6.dataBase.dataType.User;
import com.hackathon.team6.utlities.Utilities;

/**
 * Created by Colin on 1/24/2015.
 */
public class Login_Page extends ActivityWithLoading {

    Button mLoginButton;
    EditText mUserField;
    EditText mPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loginscreen);

        mLoginButton = (Button)findViewById(R.id.login_page_button);
        mUserField = (EditText)findViewById(R.id.login_page_id_editText);
        mPasswordField = (EditText)findViewById(R.id.login_page_password_editText);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHomePage();
            }
        });
    }

    protected void goToHomePage(){
        int userIdNumber;
        String userId = mUserField.getText().toString();
        String password = mPasswordField.getText().toString();

        if(userId.equals("")){
            Utilities.showToast(this,R.string.Error_empty_username);
            return;
        }

        try {
            userIdNumber = Integer.parseInt(userId);
        }catch (NumberFormatException e){
            Utilities.showToast(this,R.string.Error_invalid_id_format);
            return;
        }

        if(password.equals("")){
            Utilities.showToast(this,R.string.Error_empty_password);
            return;
        }

        if(!Utilities.isOnline(this)) {
            Utilities.showToast(this,R.string.Error_no_connection);
            return;
        }

        User user = DataBase.validateUser(userIdNumber,password);
        if(user == null){
            Utilities.showToast(this,R.string.Error_invalid_id_password);
            return;
        }

        Home_Page.userPassing = user;
        Intent intent = new Intent(this,Home_Page.class);
        startActivity(intent);

    }

    @Override
    public void onFinishLoad() {

    }

    @Override
    public void onLoadFailed() {
        Utilities.showToast(this,R.string.Error_invalid_id_password);
    }

    @Override
    public void onTimeOut() {
        Utilities.showToast(this,R.string.Error_timeout);
    }
}
