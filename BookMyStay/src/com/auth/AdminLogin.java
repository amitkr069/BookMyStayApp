package com.auth;

import java.util.Scanner;

public class AdminLogin {

    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";

    public boolean login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
            System.out.println("Login Successful!");
            return true;
        } else {
            System.out.println("Invalid Credentials!");
            return false;
        }
    }
}