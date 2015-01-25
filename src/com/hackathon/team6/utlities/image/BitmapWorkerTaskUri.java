package com.hackathon.team6.utlities.image;


import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;


public class BitmapWorkerTaskUri extends AsyncTask<Uri, Void, Bitmap> {

    private final WeakReference<ImageView> imageViewReference;
    private Context context;
    final int height;
    final int width;

    public BitmapWorkerTaskUri(ImageView imageView, Context context, int width, int height) {
        // Use a WeakReference to ensure the ImageView can be garbage collected
        imageViewReference = new WeakReference<ImageView>(imageView);
        this.context = context;
        this.height = height;
        this.width = width;
    }

    // Decode image in background.
    @Override
    protected Bitmap doInBackground(Uri... params) {
        Uri data = params[0];
        Bitmap toReturn = null;

        try {
            toReturn = ImageResizer.decodeSampledBitmapFromURI(context, data, width, height);
        } catch (FileNotFoundException e) {
            Log.d("DEBUG", "File Not Found Caught");
        }

        return toReturn;
    }

    // Once complete, see if ImageView is still around and set bitmap.
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageResource(0);
                imageView.setImageBitmap(bitmap);
            }
        }
    }


}

