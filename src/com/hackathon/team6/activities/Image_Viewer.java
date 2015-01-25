package com.hackathon.team6.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.hackathon.team6.R;
import com.hackathon.team6.dataBase.dataType.Image;
import com.hackathon.team6.dataBase.dataType.Transaction;
import com.hackathon.team6.utlities.Utilities;
import com.hackathon.team6.utlities.adapters.GridViewAdapter;
import com.hackathon.team6.utlities.gps.GPSActivity;
import com.hackathon.team6.utlities.image.Image_Activity;
import com.hackathon.team6.utlities.image.PictureFileManager;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by brian on 1/24/2015.
 */
public class Image_Viewer extends Image_Activity {

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


        mSubmit.setText(View.GONE);

        mGPS.setText(getResources().getString(R.string.Viewer_Screen_long_prefix) + " " + transaction.getLoc_lat() +
                "\n" +
                getResources().getString(R.string.Viewer_Screen_long_prefix) + " " + transaction.getLoc_long());

        updateCount();

        if(transaction != null && transaction.getCurrentType() != null){
            mRental.setText(transaction.getCurrentType().name);
        }

        mPictureGridView.setAdapter(new GridViewAdapter(this,transaction,false,this));
    }

    //temp
    private void showToast(String message){
        Utilities.showToast(this, message);
    }

    @Override
    public void updateCount(){
        String line1 = transaction.getImages().size() + "/" + Transaction.MAX_PICTURES + " " +
                getResources().getString(R.string.Capture_Screen_image_count_postfix);
        String line2 = transaction.getMinImages() + " min for " + transaction.getCurrentType().name;
        mImagesCaptured.setText(line1 + "\n" + line2);
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
