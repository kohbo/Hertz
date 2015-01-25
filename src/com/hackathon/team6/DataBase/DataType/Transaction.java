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

    public void setLoc_lat(float loc_lat) {
        this.loc_lat = loc_lat;
    }

    public void setLoc_long(float loc_long) {
        this.loc_long = loc_long;
    }

    public ArrayList<Image> getImages() {
        ArrayList<Image> images = new ArrayList();
        images.add(new Image(image1));
        images.add(new Image(image2));
        images.add(new Image(image3));
        images.add(new Image(image4));
        images.add(new Image(image5));
        images.add(new Image(image6));
        images.add(new Image(image7));
        images.add(new Image(image8));
        images.add(new Image(image9));
        images.add(new Image(image10));
        images.add(new Image(image11));
        images.add(new Image(image12));
        return images;
    }

    public void setImages(ArrayList<Image> images){
        this.images = images;
    }

    public int getImageListSize(){
        int c = 0;
        for(Image s : images) {
            if(!s.getloc().equals("null")){
                c++;
            }
        }
        return c;
    }

    public void setCurrentType(type t){
        currentType = t;
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


}
