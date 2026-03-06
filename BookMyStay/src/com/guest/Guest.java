package com.guest;


public class Guest {

    private String name;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;

    public Guest(String name, String email, String phoneNumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}