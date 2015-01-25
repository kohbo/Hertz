package com.hackathon.team6.utlities.image;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.widget.ImageView;
import com.hackathon.team6.utlities.gps.GPSActivity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Image_Activity extends GPSActivity {
    static private Uri outputFileUri;

    protected ArrayList<AsyncTask> tasks;
    final int PICTURE_URI_REQUEST = 1;

    private File dir;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        stopAllTasks();
        super.onStop();
    }

    protected void stopAllTasks(){
        for(AsyncTask asyncTask : tasks){
            asyncTask.cancel(true);
        }
        tasks.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasks = new ArrayList<AsyncTask>();
        dir = new File(PictureFileManager.getDir());
    }

    protected abstract void saveImage(Uri uri);

    private void setupOutputFileUri(){
        // Determine Uri of camera image to save.
        final String fname = "img_"+ System.currentTimeMillis() + ".jpg";
        final File sdImageMainDirectory = new File(dir, fname);
        outputFileUri = Uri.fromFile(sdImageMainDirectory);

    }

    public void openImageIntent() {
        setupOutputFileUri();

        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(captureIntent, PICTURE_URI_REQUEST);
    }

    protected void setImageViewPicture(Uri uri, ImageView iv){
        tasks.add(BitmapManager.setImageView(iv, this, uri, 400, 400));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == PICTURE_URI_REQUEST)
        {
            Uri selectedImageUri = outputFileUri;
            if(selectedImageUri != null){
                saveImage(selectedImageUri);
            }
        }

    }




}
