package com.hackathon.team6.dataBase;

import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hackathon.team6.dataBase.dataType.Equipment;
import com.hackathon.team6.dataBase.dataType.Image;
import com.hackathon.team6.dataBase.dataType.Transaction;
import com.hackathon.team6.dataBase.dataType.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by William on 1/24/2015.
 */
public class DataBase   {

/*
    Host: http://kohding.net/hertz/
    Page
    get_ic_assessments.php
            ic
    get_assessment_info.php
            assessment_id
    login.php
            employee_id, pass
    new_assessment.php (Must be POST method request)
    employee_id, customer_id, ic, type, images
*/

    private static DataBase ourInstance = new DataBase();

    public static DataBase getInstance() {
        return ourInstance;
    }

    private DataBase() {

    }
    private static final String url = "http://Kohding.net/hertz/";

    private static String request(String command){
        StringBuffer buffer = new StringBuffer();
        try {
            // Apache HTTP Reqeust
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(command);

            HttpResponse resp = client.execute(post);
            // read the response
            InputStream is  = resp.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder str = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null){
                str.append(line + "\n");
            }
            is.close();
            buffer.append(str.toString());

        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        return buffer.toString();
    }


    /*********************************************
     *
     * Query Commands
     *
     *********************************************/

    /**
     * Checks for Valid User Login
     *
     * @param id       User ID
     * @param password User Password
     * @return User
     */
    public static User validateUser(int id, String password) {
        String command = url+"/login.php?employee_id="+id+"&pass="+password;
        return JsonParser.PUser(request(command), id, password);

        // return JsonParser.parseUser(request(command));
    }

    /**
     * Queries  Equipment Data and Creates Equipment Class
     *
     * @param id
     * @return
     */
    public  Equipment queryEquipment(int id) {
        String command = url+"get_ic_assessments.php?ic="+id;
        Equipment equipment = null;
        try {
            equipment = JsonParser.parseEquipment(request(command));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }

        return equipment;
    }


    /**
     * Queries Transaction Data and Creates Transaction Class
     *
     * @param id
     * @return
     */
    public Transaction queryTransaction(int id) {
        String command = url+"get_assessment_info.php?assessment_id="+id;
        try {
            return JsonParser.parseTransaction(request(command));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Queries Image Data and Creates Image Class
     *
     * @param id
     * @return
     */
    public Image queryImage(int id) {
        //Image image = new Image(id);
        return null;
    }





    /*********************************************
     *
     * Insert Commands
     *
     *********************************************/


    /**
     * Updates ALL User Data
     *
     * @param user
     * @return T/F if Successful
     */
    public static boolean updateUser(User user) {
        //TODO Update ALL User Data
        return true;
    }

    /**
     * Updates ALL Equipment Data
     *
     * @param equipment
     * @return T/F if Successful
     */
    public static boolean updateEquipment(Equipment equipment) {
        //TODO Update ALL Equipment Data
        return true;
    }

    /**
     * Updates ALL Image Data
     *
     * @param image
     * @return T/F if Successful
     */
    public static boolean updateImage(Image image) {
        //TODO Update ALL Image Data
        return true;
    }

    /**
     * Updates ALL Transaction Data
     *
     * @param transaction
     * @return T/F if Successful
     */
    public static boolean updateTransaction(Transaction transaction) {

        //TODO Update ALL Transaction Data
        return true;
    }


}