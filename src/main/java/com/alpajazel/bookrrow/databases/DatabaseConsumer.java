package com.alpajazel.bookrrow.databases;

import com.alpajazel.bookrrow.models.Consumer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Class that connect to postgresql server.
 * Give query and get result which is related to consumer table in the schema
 *
 * @author Reja Aji Saputra
 * @version 1.0.0
 * @since 2019-05-10
 */
public class DatabaseConsumer extends DatabaseConnection
{
    /**
     * Create a Consumer and store it to the database
     *
     * @param username username that inputed by consumer to create an account for login to the website
     * @param password password that inputed by consumer to create an account for login to the website
     * @param name consumer's name that inputed by consumer for consumer data in the website
     * @param email consumer's email that inputed by consumer for consumer data in the website
     * @param phoneNumber consumer's phone number that inputed by consumer for consumer data in the website
     * @return Consumer object that created by the user
     * @since 2019-05-10
     */
    public Consumer registerConsumer(String username, String password, String name, String email, String phoneNumber) {

        int consumerID = 0;
        PreparedStatement st = null;
        try {
            st = getConn().prepareStatement("INSERT INTO consumer (username, password, name, email, phone_number) VALUES (?, ?, ?, ?, ?) returning consumer_id");
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, name);
            st.setString(4, email);
            st.setString(5, phoneNumber);
            ResultSet rs = st.executeQuery();
            if(!rs.isBeforeFirst()){
                st.close();
                return null;
            }
            while(rs.next()){
                consumerID= rs.getInt("consumer_id");
            }
            Consumer consumer = new Consumer(consumerID, name, email, username, password, phoneNumber);
            st.close();
            rs.close();
            return consumer;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Login to the website by parameter username and password
     *
     * @param username username that inputed by consumer to login to the website
     * @param password password that inputed by consumer to login to the website
     * @return object which have the username and password that have been specified
     * @since 2019-05-10
     */
    public Consumer loginConsumer(String username, String password){
        String name ="", email ="", phoneNumber ="";
        int consumerID = 0;

        PreparedStatement st = null;
        try {
            st = getConn().prepareStatement("SELECT * from consumer WHERE username = ? AND password = ?");
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            if(!rs.isBeforeFirst()){
                st.close();
                return null;
            }
            while (rs.next()){
                username = rs.getString("username");
                password = rs.getString("password");
                name = rs.getString("name");
                email = rs.getString("email");
                phoneNumber = rs.getString("phone_number");
                consumerID = rs.getInt("consumer_id");
            }
            Consumer consumer = new Consumer(consumerID, name, email, username, password, phoneNumber);
            st.close();
            rs.close();
            return consumer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Create a Consumer and store it to the database
     *
     * @param password consumer's password that consumer want to update in the database
     * @param name consumer's name that consumer want to update in the database
     * @param phoneNumber consumer's phone number that consumer want to update in the database
     * @param consumerID the primary key that determine the consumer row that the program want to take
     * @return Consumer object that updated by the user
     * @since 2019-05-10
     */
    public Consumer updateConsumer ( String password, String name,String phoneNumber, int consumerID ){
        PreparedStatement st = null;
        String email = "", username = "";
        try {
            st = getConn().prepareStatement("UPDATE consumer SET  password =?, name = ?, phone_number = ? WHERE consumer_id = ? returning *");
            st.setString(1, password);
            st.setString(2, name);
            st.setString(3, phoneNumber);
            st.setInt(4, consumerID);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                username = rs.getString("username");
                password = rs.getString("password");
                name = rs.getString("name");
                email = rs.getString("email");
                phoneNumber = rs.getString("phone_number");
                consumerID = rs.getInt("consumer_id");
            }

            Consumer consumer = new Consumer(consumerID, name, email, username, password, phoneNumber);
            st.close();
            rs.close();
            return consumer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}