package com.hackathon.team6.dataBase;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.team6.dataBase.dataType.Equipment;
import com.hackathon.team6.dataBase.dataType.Transaction;
import com.hackathon.team6.dataBase.dataType.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;

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


    public static User parseUser(String s)throws JsonParseException, JsonMappingException {

        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        User myUser;
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);

        mapper.setVisibility(PropertyAccessor.ALL,
                JsonAutoDetect.Visibility.ANY);

        try {
            myUser = mapper.treeToValue(mapper.readTree(s), com.hackathon.team6.dataBase.dataType.User.class);

            return myUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Transaction parseTransaction(String s)throws JsonParseException, JsonMappingException{
        if (s == "") {
            return null;
        }

        Transaction trans = new Transaction();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            trans = mapper.treeToValue(mapper.readTree(s), Transaction.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trans;
    }

    public static List<Transaction> parseEquipment(String s)throws JsonParseException, JsonMappingException{
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);

        mapper.setVisibility(PropertyAccessor.ALL,
                JsonAutoDetect.Visibility.ANY);
        try {
            TypeFactory typeFactory = mapper.getTypeFactory();
            List<Transaction> someClassList =
                    mapper.readValue(s, typeFactory.constructCollectionType(List.class, Transaction.class));
            return someClassList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        //JsonParser.parseEquipment("{\"status\":0,\"data\":{\"assessment_id\":\"1\",\"ic\":\"000000001\",\"customer_id\":\"1\",\"created_by\":\"1\",\"image1\":\"http:\\/\\/kohding.net\\/hertz\\/images\\/1\\/IMG_20150124_200203.jpg\",\"image2\":\"http:\\/\\/kohding.net\\/hertz\\/images\\/1\\/IMG_20150124_200208.jpg\",\"image3\":\"http:\\/\\/kohding.net\\/hertz\\/images\\/1\\/IMG_20150124_200212.jpg\",\"image4\":\"http:\\/\\/kohding.net\\/hertz\\/images\\/1\\/IMG_20150124_200216.jpg\",\"image5\":null,\"image6\":null,\"image7\":null,\"image8\":null,\"image9\":null,\"image10\":null,\"image11\":null,\"image12\":null,\"type\":\"1\",\"loc_lat\":null,\"loc_long\":null,\"created_on\":\"2015-01-24 21:52:58\"}}");
    }

    public static Equipment PEquipment(String s, int id) {

        return null;
    }


//    public static User PUser(String s, int id, String pass) {
//        if (s == "") {
//            s = "{\"status\":0,\"data\":{\"name\":\"Ju nendez\",\"role\":\"1\"}}";
//            id=3;
//        }
//        char[] c = s.toCharArray();
//        String name = "";
//        int role;
//
//        if (c[10] != 0) {
//            int count = 29;
//
//            while (c[count] != '"') {
//                name = name + c[count];
//                count++;
//            }
//            role = Integer.parseInt(String.valueOf(c[count + 10]));
//
//        } else {
//            return null;
//        }
//        User user = new User(id);
//        user.setPassword(pass);
//        user.setName(name);
//        switch (role) {
//            case 1:
//                user.setCurrentRole(User.role.Retail);
//                break;
//
//            case 2:
//                user.setCurrentRole(User.role.Sales);
//                break;
//
//            case 3:
//                user.setCurrentRole(User.role.Service);
//                break;
//        }
//        return user;
//    }
}
