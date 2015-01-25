package com.hackathon.team6.dataBase;

import com.hackathon.team6.dataBase.dataType.User;

/**
 * Created by William on 1/25/2015.
 */
public class JsonParser {
    private static JsonParser ourInstance = new JsonParser();

    public static JsonParser getInstance() {
        return ourInstance;
    }

    private JsonParser() {
    }


    public static User parseUser(String s) {


        return new User(2);
    }


}
