package com.hackathon.team6.DataBase.DataType;

import java.util.ArrayList;

/**
 * Created by William on 1/24/2015.
 */
public class Transaction {
    int id;
    int type;
    int lastModified;
    User createdBy;
    User customer;
    User lastEditedBy;
    int minImages;
    ArrayList<Equipment> equipment;

    Transaction(int id) {
        //TODO Get Data From DataBase
    }


}
