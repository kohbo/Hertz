package com.hackathon.team6.activities;

import android.app.ActionBar;
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
import com.hackathon.team6.utlities.image.PictureFileManager;

import java.io.File;

/**
 * Created by brian on 1/24/2015.
 */
public class Image_Capture extends GPSActivity {

    public static Transaction transaction;
    public static Transaction.type type;

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


        mSubmit = (Button) findViewById(R.id.image_capture_submit_button);
        mRental = (TextView) findViewById(R.id.image_capture_rental_type);
        mImagesCaptured = (TextView) findViewById(R.id.image_capture_images_captured);
        mPictureGridView = (GridView) findViewById(R.id.image_capture_gridView);
        mGPS = (TextView) findViewById(R.id.image_capture_gps);

        if (transaction.getLoc_lat() == 0) {
            setNewGPS(mGPS, transaction);
        }

        updateCount();

        if (transaction != null && transaction.getCurrentType() != null) {
            mRental.setText(transaction.getCurrentType().name);
            transaction.setCurrentType(type);
        }


        mPictureGridView.setAdapter(new GridViewAdapter(this, transaction, true, this));

        mPictureGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    if(transaction.getUris().size() < Transaction.MAX_PICTURES){
                        openImageIntent();
                    } else {
                        Utilities.showToast(getApplicationContext(), R.string.Error_max_pictures);
                    }
                } else {
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
    private void showToast(String message) {
        Utilities.showToast(this, message);
    }

    @Override
    public void updateCount(){
        String line1 = transaction.getUris().size() + "/" + Transaction.MAX_PICTURES + " " +

                getResources().getString(R.string.Capture_Screen_image_count_postfix);
        String line2 = transaction.getMinImages() + " min for " + transaction.getCurrentType().name;
        mImagesCaptured.setText(line1 + "\n" + line2);
    }

    protected void submitReport(){
        if(transaction.getUris().size() > transaction.getMinImages()){
            Utilities.showToast(this, R.string.Capture_Screen_success);
            finish();
        } else {
            Utilities.showToast(this, R.string.Error_min_pictures);
        }
    }

    @Override
    protected void saveImage(Uri uri) {
        transaction.getUris().add(uri);
        updateCount();
    }

    @Override
    protected String getSaveDir() {
        return PictureFileManager.getDir() + transaction.getId() + File.separator;
    }
}
