package com.hackathon.team6.dataBase.dataType;

/**
 * Created by brian on 1/25/2015.
 */
public class UserTwo {

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