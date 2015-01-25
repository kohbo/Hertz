package com.hackathon.team6.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.hackathon.team6.R;
import com.hackathon.team6.utlities.Utilities;

/**
 * Created by brian on 1/24/2015.
 */
public class Image_Capture extends Activity {
    Button mSubmit;
    TextView mIC_Number;
    TextView mRental;
    TextView mImagesCaptured;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loginscreen);

        mSubmit = (Button)findViewById(R.id.login_page_button);
        mIC_Number = (TextView) findViewById(R.id.image_capture_ICNumber);
        mRental = (TextView) findViewById(R.id.image_capture_rental_type);
        mImagesCaptured = (TextView) findViewById(R.id.image_capture_images_captured);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitReport();
            }
        });
    }
    protected void submitReport(){
        Utilities.showToast(this, R.string.Capture_Screen_success);
        Intent intent = new Intent(this,Home_Page.class);
        startActivity(intent);
    }
}
