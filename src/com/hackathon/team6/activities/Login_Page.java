package com.hackathon.team6.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.hackathon.team6.R;
import com.hackathon.team6.utlities.Utilities;

/**
 * Created by Colin on 1/24/2015.
 */
public class Login_Page extends Activity {

    Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loginscreen);

        mLoginButton = (Button)findViewById(R.id.login_page_button);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHomePage();
            }
        });
    }

    protected void goToHomePage(){
        if(Utilities.isOnline(this)) {
            Intent intent = new Intent(this, Home_Page.class);
            startActivityForResult(intent, 0);
        }
        else {
            Utilities.showToast(this,R.string.Error_no_connection);
        }
    }
}
