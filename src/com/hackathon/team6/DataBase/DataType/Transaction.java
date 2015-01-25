package com.hackathon.team6.dataBase.dataType;

import java.util.ArrayList;

public class Transaction{

    private int assessment_id;

    public enum type {
        Rental("Rental"),
        Return("Return"),
        Sales("Sales"),
        FieldService("Field Services");

        public String name;

        type(String name) {
            this.name = name;
        }
    }

    private type currentType;
    private int created_by;

    private int ic;

    float loc_lat;
    float loc_long;

    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String image6;
    private String image7;
    private String image8;
    private String image9;
    private String image10;
    private String image11;
    private String image12;

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
        this.assessment_id = id;
        //TODO Get Data From DataBase
    }

    /*
    * Getter's and Setter's
    */
    public int getId() {
        return assessment_id;
    }

    public type getCurrentType() {
        return currentType;
    }

    public int getCreated_by() {
        return created_by;
    }

    public float getLoc_lat() {
        return loc_lat;
    }

    public float getLoc_long() {
        return loc_long;
    }

    public int getMinImages() {
        return minImages;
    }

    public int getIc() {
        return ic;
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
