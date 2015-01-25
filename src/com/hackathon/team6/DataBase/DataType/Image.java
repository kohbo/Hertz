package com.hackathon.team6.dataBase.dataType;

/**
 * Created by William on 1/24/2015.
 */
public class Image {


    private int id;
    private String Path;
    private String timeStamp;
    private String GPSCords;

    /**
     * @param id
     */
    Image(int id) {
        this.id = id;
    }


    /*
    * Getter's and Setter's
    */

    public int getId() {
        return id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getGPSCords() {
        return GPSCords;
    }

    public void setGPSCords(String GPSCords) {
        this.GPSCords = GPSCords;
    }
}
