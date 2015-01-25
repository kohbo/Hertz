package com.hackathon.team6.dataBase.dataType;

/**
 * Created by William on 1/24/2015.
 */
public class User {

    private int status;

    public int getStatus() {return status; }

    private data data;
    public static class data{
        private String name;
        private int role;
        public String getName(){return name;}
        public int getRole(){return role;}

    }
    public data getData(){return data;}
}
