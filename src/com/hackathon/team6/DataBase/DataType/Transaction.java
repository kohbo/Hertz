package com.hackathon.team6.DataBase.DataType;

import java.util.ArrayList;

/**
 * Created by William on 1/24/2015.
 */
public class Transaction {
    int id;

    enum type {
        Rental,
        Return,
        Sales,
        FieldService
    }

    type currentType;

    String lastModified;

    User createdBy;
    User customer;
    User lastEditedBy;

    int minImages;
    ArrayList<Equipment> equipment;

    public Transaction(int id) {

        //TODO Get Data From DataBase

    }

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
