package com.alpajazel.bookrrow.models;

/**
 * represent the consumer of bookrrow
 *
 * @author DP Nala Krisnanda
 * @version 1.0
 * @since 2019-05-17
 */
public class Consumer {
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;

    /**
     * default constructor for generating a new consumer
     * @param id of the consumer
     * @param name of the consumer
     * @param email of the consumer
     * @param username of the consumer
     * @param password of the consumer
     * @param phoneNumber of the consumer
     */
    public Consumer(int id, String name, String email, String username, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    /**
     * get the consumer id
     * @return the id of a consumer
     */
    public int getId() {
        return id;
    }

    /**
     * get the consumer name
     * @return the name of a consumer
     */
    public String getName() {
        return name;
    }


    /**
     * get the consumer email
     * @return the email of a consumer
     */
    public String getEmail() {
        return email;
    }

    /**
     * get the consumer username
     * @return the username of a consumer
     */
    public String getUsername() {
        return username;
    }

    /**
     * get the consumer password
     * @return the password of a consumer
     */
    public String getPassword() {
        return password;
    }

    /**
     * get the consumer phone Number
     * @return the phone Number of a consumer
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * set a new consumer id
     * @param id is the new id assign to the consumer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * set a new consumer name
     * @param name is the new name assign to the consumer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set a new consumer email
     * @param email is the new email assign to the consumer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * set a new consumer username
     * @param username is the new username assign to the consumer
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * set a new consumer password
     * @param password is the new password assign to the consumer
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * set a new consumer phone Number
     * @param phoneNumber is the new phone Number assign to the consumer
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
