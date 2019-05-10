package com.alpajazel.bookrrow.models;

public class Consumer {
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;

    public Consumer(int id, String name, String email, String username, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
