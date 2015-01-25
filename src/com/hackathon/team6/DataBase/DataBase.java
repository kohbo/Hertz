package com.hackathon.team6.dataBase;

import com.hackathon.team6.dataBase.dataType.Equipment;
import com.hackathon.team6.dataBase.dataType.Image;
import com.hackathon.team6.dataBase.dataType.Transaction;
import com.hackathon.team6.dataBase.dataType.User;

/**
 * Created by William on 1/24/2015.
 */
public class DataBase {

    public DataBase() {

    }

    private void init() {

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
    public static boolean validateUser(int id, String password) {
        boolean result = true;
        //TODO Check For valid User
        if (result) {
            return true;
        } else {
            return false;
        }
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

        Transaction transaction = new Transaction(id);


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

        Image image = new Image(id);
        return image;
    }

}
