package com.hackathon.team6.dataBase.dataType;

import java.util.ArrayList;

/**
 * Created by William on 1/24/2015.
 */
public class Transaction {
    private int id;

    public enum type {
        Rental ("Rental"),
        Return ("Return"),
        Sales ("Sales"),
        FieldService ("Field Services");

        public String name;
        type(String name){
            this.name = name;
        }
    }

    private type currentType;

    private String lastModified;

    private User createdBy;
    private User currentUser;
    private User lastEditedBy;
    private Equipment equipmentId;

    float latLocation;
    float longLocation;

    private ArrayList<Image> images;
    private int minImages;

    /**
     * New TransAction Constructor
     */
    public Transaction() {

    }

    /**
     * Past TransAction Constructor
     * @param id
     */
    public Transaction(int id) {
        this.id = id;
        //TODO Get Data From DataBase
    }

    /*
    * Getter's and Setter's
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public type getCurrentType() {
        return currentType;
    }

    public void setCurrentType(type currentType) {
        this.currentType = currentType;
        setMinNumberImage();
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getLastEditedBy() {
        return lastEditedBy;
    }

    public void setLastEditedBy(User lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
    }

    public float getLatLocation() {
        return latLocation;
    }

    public void setLatLocation(float latLocation) {
        this.latLocation = latLocation;
    }

    public float getLongLocation() {
        return longLocation;
    }

    public void setLongLocation(float longLocation) {
        this.longLocation = longLocation;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public int getMinImages() {
        return minImages;
    }

    private void setMinImages(int minImages) {
        this.minImages = minImages;
    }

    /*******************************************
     *
     * Utility Methods
     *
     ******************************************/

    /**
     * Sets Min Images based on Transaction Type
     */
    public void setMinNumberImage() {
        switch (currentType) {
            case Rental:
                minImages = 2;
                break;

            case Return:
                minImages = 4;
                break;

            case Sales:
                minImages = 6;
                break;

            case FieldService:
                minImages = 8;
                break;

            default:
                minImages = 12;
                break;
        }
    }

    public boolean completeTransaction(){
        return true;
    }
}
