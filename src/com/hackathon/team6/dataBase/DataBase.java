
        package com.hackathon.team6.dataBase;

        import com.hackathon.team6.dataBase.dataType.Equipment;
        import com.hackathon.team6.dataBase.dataType.Image;
        import com.hackathon.team6.dataBase.dataType.Transaction;
        import com.hackathon.team6.dataBase.dataType.User;
        import org.apache.http.HttpResponse;
        import org.apache.http.NameValuePair;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.entity.UrlEncodedFormEntity;
        import org.apache.http.client.methods.HttpGet;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.message.BasicNameValuePair;

        import java.io.*;
        import java.util.ArrayList;
        import java.util.List;

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
    private static final String url = "http://Kohding.net/hertz/";
    private static final String serverPass = "";

    HttpClient client;

    public DataBase() {
        client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);


    }

    public void  get(){
        HttpGet request = new HttpGet(url);


        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = null;
        try {
            rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuffer result = new StringBuffer();
        String line = "";
        try {
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    protected byte[] doInBackground(String... params) {
        String url = params[0];
        String name = params[1];

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("name", name));
        byte[] data = null;

        try {
            post.setEntity(new UrlEncodedFormEntity(paramList));
            HttpResponse resp = client.execute(post);
            InputStream is = resp.getEntity().getContent();
            int contentSize = (int) resp.getEntity().getContentLength();
            System.out.println("Content size ["+contentSize+"]");
            BufferedInputStream bis = new BufferedInputStream(is, 512);

            data = new byte[contentSize];
            int bytesRead = 0;
            int offset = 0;

            while (bytesRead != -1 && offset < contentSize) {
                bytesRead = bis.read(data, offset, contentSize - offset);
                offset += bytesRead;
            }
        }
        catch(Throwable t) {
            // Handle error here
            t.printStackTrace();
        }

        return data;
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
     * @return Valid Id/Password Combination
     */
    public static User validateUser(int id, String password) {
        String command = url+"/login.php?employee_id="+id+"&pass="+password;

        StringBuffer buffer = new StringBuffer();
        try {
            // Apache HTTP Reqeust
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(command);

            HttpResponse resp = client.execute(post);
            // We read the response
            InputStream is  = resp.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder str = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null){
                str.append(line + "\n");
            }
            is.close();
            buffer.append(str.toString());
            // Done!
        }
        catch(Throwable t) {
            t.printStackTrace();
        }

        return JsonParser.parseUser(buffer.toString());
    }

    /**
     * Queries User Data and Creates User Class
     *
     * @param id
     * @return
     */
    public User queryUser(int id) {
        User user = new User(id);
        return user;
    }

    /**
     * Queries Transaction Data and Creates Transaction Class
     *
     * @param id
     * @return
     */
    public Transaction queryTransaction(int id) {

//        Transaction transaction = new Transaction(id);


        return transaction;
    }

    /**
     * Queries  Equipment Data and Creates Equipment Class
     *
     * @param id
     * @return
     */
    public  Equipment queryEquipment(int id) {
        Equipment  equipment = new Equipment(id);
        return equipment;
    }

    /**
     * Queries Image Data and Creates Image Class
     *
     * @param id
     * @return
     */
    public Image queryImage(int id) {

        Image image = new Image(id,null);
        return image;
    }

}