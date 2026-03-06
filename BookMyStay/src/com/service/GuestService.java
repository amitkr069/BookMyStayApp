package com.service;


import java.util.HashMap;
import java.util.Scanner;

import com.guest.*;
import com.util.*;

public class GuestService {

    HashMap<String, Guest> guests = new HashMap<>();

    Scanner sc = new Scanner(System.in);

    // Registration
    public void register() {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        if (guests.containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Hash password
        String hashedPassword = PasswordUtil.hashPassword(password);

        Guest guest = new Guest(name, email, phone, username, hashedPassword);

        guests.put(username, guest);

        System.out.println("Registration Successful!");
    }

    // Login
    public boolean login() {

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String hashedPassword = PasswordUtil.hashPassword(password);

        if (guests.containsKey(username)) {

            Guest g = guests.get(username);

            if (g.getPassword().equals(hashedPassword)) {

                System.out.println("Login Successful! Welcome " + g.getName());
                return true;
            }
        }

        System.out.println("Invalid credentials!");
        return false;
    }
}
