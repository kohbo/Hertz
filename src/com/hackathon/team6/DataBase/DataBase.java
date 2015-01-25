package com.hackathon.team6.dataBase;

import com.hackathon.team6.DataBase.DataType.Equipment;
import com.hackathon.team6.DataBase.DataType.Image;
import com.hackathon.team6.DataBase.DataType.Transaction;
import com.hackathon.team6.DataBase.DataType.User;

/**
 * Created by William on 1/24/2015.
 */
public class DataBase {

    public DataBase() {
        init();
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
    public boolean updateUser(User user) {
        //TODO Update ALL User Data
        return true;
    }

    /**
     * Updates ALL Equipment Data
     *
     * @param equipment
     * @return T/F if Successful
     */
    public boolean updateEquipment(Equipment equipment) {
        //TODO Update ALL Equipment Data
        return true;
    }

    /**
     * Updates ALL Image Data
     *
     * @param image
     * @return T/F if Successful
     */
    public boolean updateImage(Image image) {
        //TODO Update ALL Image Data
        return true;
    }

    /**
     * Updates ALL Transaction Data
     *
     * @param transaction
     * @return T/F if Successful
     */
    public boolean updateTransaction(Transaction transaction) {
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
    public boolean validateUser(int id, String password) {
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
     * Queries User Data and Creates User Class
     *
     * @param id
     * @return
     */
    public User queryUser(int id) {

        User user = new User(id);


        return user;
    }


}
