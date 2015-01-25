package com.hackathon.team6.dataBase.dataType;

import java.util.ArrayList;

/**
 * Created by William on 1/24/2015.
 */
public class Transaction {
    private int id;

    private enum type {
        Rental,
        Return,
        Sales,
        FieldService
    }

    private type currentType;

    private String lastModified;

    private User createdBy;
    private User customer;
    private User lastEditedBy;

    private int minImages;
    private ArrayList<Equipment> equipment;

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

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getLastEditedBy() {
        return lastEditedBy;
    }

    public void setLastEditedBy(User lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
    }

    public int getMinImages() {
        return minImages;
    }

    public void setMinImages(int minImages) {
        this.minImages = minImages;
    }

    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
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
