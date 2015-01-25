package com.hackathon.team6.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.hackathon.team6.R;

public class Home_Page extends Activity {

    ImageView hertz_logo;
    EditText IC_Num;
    //TextView number_of_pictures_field;
    Button rental;
    Button returnButton;
    Button sales;
    Button field_service;
    Button equipment_history;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        hertz_logo = (ImageView)findViewById(R.id.HertzLogo);
        IC_Num = (EditText)findViewById(R.id.IC_num);
        //buttons
        rental = (Button)findViewById(R.id.Rental);
        returnButton = (Button)findViewById(R.id.Return);
        sales = (Button)findViewById(R.id.Sales);
        field_service = (Button)findViewById(R.id.FieldService);
        equipment_history = (Button)findViewById(R.id.EquipmentHistory);

    }


}
