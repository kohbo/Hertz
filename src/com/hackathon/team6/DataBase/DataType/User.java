package com.hackathon.team6.DataBase.DataType;

import java.util.ArrayList;

/**
 * Created by William on 1/24/2015.
 */

public class User {


    private int id;
    private String password;
    private String Name;
    private role currentRole;
    private ArrayList<Transaction> tranactions;

    private enum role {
        Customer,
        Sales,
        Repair
    }

    public User(int id) {
        this.id = id;

        //TODO Get Data From DataBase


    }

    /*
    * Getter's and Setter's
    */

    public int getId() {
        return id;
    }

    public role getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(role currentRole) {
        this.currentRole = currentRole;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Transaction> getTranactions() {
        return tranactions;
    }

    public void setTranactions(ArrayList<Transaction> tranactions) {
        this.tranactions = tranactions;
    }
}
