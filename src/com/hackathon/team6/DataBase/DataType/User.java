package com.hackathon.team6.DataBase.DataType;

/**
 * Created by William on 1/24/2015.
 */

public class User {


    int id;
    String password;
    String Name;
    role currentRole;

    enum role {
        Customer,
        Sales,
        Repair
    }




    User(int id) {
        //TODO Get Data From DataBase
    }


}
