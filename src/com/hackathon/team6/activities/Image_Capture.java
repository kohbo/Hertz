package com.hackathon.team6.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.hackathon.team6.R;
import com.hackathon.team6.dataBase.dataType.Image;
import com.hackathon.team6.dataBase.dataType.Transaction;
import com.hackathon.team6.utlities.Utilities;
import com.hackathon.team6.utlities.adapters.GridViewAdapter;
import com.hackathon.team6.utlities.gps.GPSActivity;
import com.hackathon.team6.utlities.image.PictureFileManager;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by brian on 1/24/2015.
 */
public class Image_Capture extends GPSActivity {

    public static Transaction transactionPassing;

    Transaction transaction;

    Button mSubmit;
    TextView mIC_Number;
    TextView mGPS;
    TextView mRental;
    TextView mImagesCaptured;
    GridView mPictureGridView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagecapture);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.Capture_Screen_Title);
        }

        mIC_Number = (TextView) findViewById(R.id.image_capture_ic_number);

        //TODO
        transaction = new Transaction(0);
        transaction.setImages(new ArrayList<Image>());
        transaction.setCurrentType(Transaction.type.Rental);
        mIC_Number.setText("999-99-9999");
        //TODO



        mSubmit = (Button)findViewById(R.id.image_capture_submit_button);
        mRental = (TextView) findViewById(R.id.image_capture_rental_type);
        mImagesCaptured = (TextView) findViewById(R.id.image_capture_images_captured);
        mPictureGridView = (GridView) findViewById(R.id.image_capture_gridView);
        mGPS = (TextView)findViewById(R.id.image_capture_gps);

        if(transaction.getLoc_lat() == 0) {
            setNewGPS(mGPS, transaction);
        }

        updateCount();

        if(transaction != null && transaction.getCurrentType() != null){
            mRental.setText(transaction.getCurrentType().name);
        }

        mPictureGridView.setAdapter(new GridViewAdapter(this,transaction));
        mPictureGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    openImageIntent();
                }
                else {
                    showToast("Clicked on picture" + i);
                }
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitReport();
            }
        });
    }

    //temp
    private void showToast(String message){
        Utilities.showToast(this, message);
    }

    private void updateCount(){
        mImagesCaptured.setText(transaction.getImageListSize() + " " + getResources().getString(R.string.Capture_Screen_image_count_postfix));
    }

    protected void submitReport(){
        Utilities.showToast(this, R.string.Capture_Screen_success);
        Intent intent = new Intent(this,Home_Page.class);
        startActivity(intent);
    }

    @Override
    protected void saveImage(Uri uri) {
        transaction.getImages().add(new Image((int)System.currentTimeMillis(),uri));
        updateCount();
    }

    @Override
    protected String getSaveDir() {
        return PictureFileManager.getDir() + transaction.getId() + File.separator;
    }
}
