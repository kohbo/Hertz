package com.hackathon.team6.dataBase.dataType;

import android.net.Uri;

/**
 * Created by William on 1/24/2015.
 */
public class Image {

    private int id; //timeStamp
    private Uri uri;

    /**
     * @param id
     */
    public Image(int id, Uri uri) {
        this.id = id;
        this.uri = uri;
    }


    /*
    * Getter's and Setter's
    */

    public int getId() {
        return id;
    }

    public Uri getUri() {
        return uri;
    }
}
