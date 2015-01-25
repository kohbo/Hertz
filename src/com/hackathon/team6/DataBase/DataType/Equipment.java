package com.hackathon.team6.dataBase.dataType;

import java.util.ArrayList;

/**
 * Created by William on 1/24/2015.
 */
public class Equipment {

    private int id;
    private ArrayList<Image[]> images;
    private ArrayList<Transaction> transactions;


    public Equipment(int id) {
        this.id = id;
        //TODO Get Data From DataBase
    }

    /*
    * Getter's and Setter's
    */

    public int getId() {
        return id;
    }

    public ArrayList<Image[]> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image[]> images) {
        this.images = images;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
