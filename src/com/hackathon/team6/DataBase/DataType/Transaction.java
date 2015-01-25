package com.hackathon.team6.dataBase.dataType;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Transaction {

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

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }

    public String getImage4() {
        return image4;
    }

    public String getImage5() {
        return image5;
    }

    public String getImage6() {
        return image6;
    }

    public String getImage7() {
        return image7;
    }

    public String getImage8() {
        return image8;
    }

    public String getImage9() {
        return image9;
    }

    public String getImage10() {
        return image10;
    }

    public String getImage11() {
        return image11;
    }

    public String getImage12() {
        return image12;
    }

    public int getIc() {
        return ic;
    }
}