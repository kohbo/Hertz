package com.hackathon.team6.dataBase.dataType;

/**
 * Created by William on 1/24/2015.
 */
public class User {


    private int id;
    private String password;
    private String Name;
    private role currentRole;

    private enum role {
        Retail,
        Sales,
        Service
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

}
