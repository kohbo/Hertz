package com.hackathon.team6.dataBase.dataType;

/**
 * Created by William on 1/24/2015.
 */
public class Image {


    private int id; //timeStamp
    private String path;



    /**
     * @param id
     */
    public Image(int id) {
        this.id = id;
    }


    /*
    * Getter's and Setter's
    */

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
