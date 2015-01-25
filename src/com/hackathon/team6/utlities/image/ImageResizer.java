package com.hackathon.team6.utlities.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.InputStream;


//Class is used to get Bitmaps with a more accurate size of the container to avoid excessive memory usage
public class ImageResizer {

    public static Bitmap decodeSampledBitmapFromURI(Context context, Uri uri,
                                                         int reqWidth, int reqHeight) throws FileNotFoundException {

        InputStream input = null;

        try {
            // First decode with inJustDecodeBounds=true to check dimensions
            input = context.getContentResolver().openInputStream(uri);
        }
        catch (Exception e){
            Log.d("DEBUG","Exception e");
        }
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(input, null, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        input = context.getContentResolver().openInputStream(uri);
        return BitmapFactory.decodeStream(input, null, options);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
        //return BitmapFactory.decodeResource(res, resId);
    }

    /**
     *    To tell the decoder to subsample the image, loading a smaller version into memory,
     * set inSampleSize to true in your BitmapFactory.Options object. For example, an image with
     * resolution 2048x1536 that is decoded with an inSampleSize of 4 produces a bitmap of approximately 512x384.
     * Loading this into memory uses 0.75MB rather than 12MB for the full image (assuming a bitmap configuration of ARGB_8888).
     * Here’s a method to calculate a sample size value that is a power of two based on a target width and height:
     *
     */
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

}
