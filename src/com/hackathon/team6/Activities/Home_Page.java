package com.hackathon.team6.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.hackathon.team6.R;
import com.hackathon.team6.dataBase.dataType.Transaction;
import com.hackathon.team6.utlities.Utilities;

public class Home_Page extends Activity {

    ImageView hertz_logo;
    EditText IC_Num;
    //TextView number_of_pictures_field;
    Button mRentalButton;
    Button mReturnButton;
    Button mSalesButton;
    Button mFieldService;
    Button mEquipmentHistory;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        hertz_logo = (ImageView) findViewById(R.id.HertzLogo);
        IC_Num = (EditText) findViewById(R.id.IC_num);
        //buttons
        mRentalButton = (Button) findViewById(R.id.Rental);
        mReturnButton = (Button) findViewById(R.id.Return);
        mSalesButton = (Button) findViewById(R.id.Sales);
        mFieldService = (Button) findViewById(R.id.FieldService);
        mEquipmentHistory = (Button) findViewById(R.id.EquipmentHistory);

        mRentalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rentReport();
            }
        });
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnReport();
            }
        });
        mSalesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salesReport();
            }
        });
        mFieldService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldServiceReport();
            }
        });
        mEquipmentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equipmentHistoryReport();
            }
        });

}
    /*
    Generates report of type
     */
    protected void rentReport() {
        Utilities.showToast(this,R.string.Error_HomePage);
        Intent intent = new Intent(this,Image_Capture.class);
        intent.putExtra("type", Transaction.type.Rental.name);
        startActivity(intent);
    }
    protected void returnReport() {
        Utilities.showToast(this,R.string.Error_HomePage);
        Intent intent = new Intent(this,Image_Capture.class);
        intent.putExtra("type", Transaction.type.Return.name);
        startActivity(intent);
    }
    protected void salesReport() {
        Utilities.showToast(this,R.string.Error_HomePage);
        Intent intent = new Intent(this,Image_Capture.class);
        intent.putExtra("type", Transaction.type.Sales.name);
        startActivity(intent);
    }
    protected void fieldServiceReport() {
        Utilities.showToast(this,R.string.Error_HomePage);
        Intent intent = new Intent(this,Image_Capture.class);
        intent.putExtra("type", Transaction.type.FieldService.name);
        startActivity(intent);
    }
    protected void equipmentHistoryReport() {
        Utilities.showToast(this,R.string.Error_HomePage);
        //Intent intent = new Intent(this,Image_Capture.class);
        //startActivity(intent);
    }
}

