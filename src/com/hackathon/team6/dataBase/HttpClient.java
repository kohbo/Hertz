package com.hackathon.team6.dataBase;

/**
 * Created by William on 1/24/2015.
 */
public class HttpClient {
    private static HttpClient ourInstance = new HttpClient();

    public static HttpClient getInstance() {
        return ourInstance;
    }

    private HttpClient() {

    }

}
