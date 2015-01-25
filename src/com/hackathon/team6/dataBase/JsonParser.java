package com.hackathon.team6.dataBase;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.team6.dataBase.dataType.Equipment;
import com.hackathon.team6.dataBase.dataType.User;

import java.io.IOException;

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

    int i;
    public static User parseUser(String s) {

        return new User(2);
    }

    public static Equipment parseEquipment(String s){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(s);
            JsonNode dataNode = rootNode.path("data");
            System.out.println(dataNode.asText());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Equipment(2);
    }

    public static void main(String[] args){
        JsonParser.parseEquipment("{\"status\":0,\"data\":{\"assessment_id\":\"1\",\"ic\":\"000000001\",\"customer_id\":\"1\",\"created_by\":\"1\",\"image1\":\"http:\\/\\/kohding.net\\/hertz\\/images\\/1\\/IMG_20150124_200203.jpg\",\"image2\":\"http:\\/\\/kohding.net\\/hertz\\/images\\/1\\/IMG_20150124_200208.jpg\",\"image3\":\"http:\\/\\/kohding.net\\/hertz\\/images\\/1\\/IMG_20150124_200212.jpg\",\"image4\":\"http:\\/\\/kohding.net\\/hertz\\/images\\/1\\/IMG_20150124_200216.jpg\",\"image5\":null,\"image6\":null,\"image7\":null,\"image8\":null,\"image9\":null,\"image10\":null,\"image11\":null,\"image12\":null,\"type\":\"1\",\"loc_lat\":null,\"loc_long\":null,\"created_on\":\"2015-01-24 21:52:58\"}}");

    }

    public static Equipment PEquipment(String s, int id) {

        return null;
    }


    public static User PUser(String s, int id, String pass) {
        if (s == "") {
            s = "{\"status\":0,\"data\":{\"name\":\"Ju nendez\",\"role\":\"1\"}}";
            id=3;
        }
        char[] c = s.toCharArray();
        String name = "";
        int role;

        if (c[10] != 0) {
            int count = 29;

            while (c[count] != '"') {
                name = name + c[count];
                count++;
            }
            role = Integer.parseInt(String.valueOf(c[count + 10]));

        } else {
            return null;
        }
        User user = new User(id);
        user.setPassword(pass);
        user.setName(name);
        switch (role) {
            case 1:
                user.setCurrentRole(User.role.Retail);
                break;

            case 2:
                user.setCurrentRole(User.role.Sales);
                break;

            case 3:
                user.setCurrentRole(User.role.Service);
                break;
        }
        return user;
    }
}
