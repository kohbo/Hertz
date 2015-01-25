package com.hackathon.team6.utlities.image;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;

public class BitmapManager {

    public static BitmapWorkerTaskUri setImageView(ImageView imageView, Context context, Uri uri, int width, int height){
        imageView.setImageResource(android.R.color.transparent);
        BitmapWorkerTaskUri task = new BitmapWorkerTaskUri(imageView, context, width, height);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,uri);
        return task;
    }

}
