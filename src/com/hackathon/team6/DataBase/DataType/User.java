package com.hackathon.team6.dataBase.dataType;

/**
 * Created by William on 1/24/2015.
 */
public class User {

    private int status;

    public int getStatus() {return status; }

    private data data;
    private String password;
    private int id;

    public enum role{
        Rental,
        Sales,
        Service
    }
    role myRole;

    public static class data{
        private String name;
        private int role;
        public String getName(){return name;}
        public int getRole(){return role;}

    }
    public data getData(){return data;}

    public void setData(User.data data) {
        this.data = data;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public role getMyRole() {
        return myRole;
    }

    public void setMyRole(role myRole) {
        this.myRole = myRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
