package com.main;
import com.auth.*;
import com.inventory.*;

import java.util.Scanner;

public class BookMyStay {

    public static void main(String[] args) {

        AdminLogin admin = new AdminLogin();
        
        Scanner sc = new Scanner(System.in);

        if (admin.login()) {

            RoomInventory inventory = new RoomInventory();

            while (true) {

                System.out.println("\n=== HOTEL INVENTORY MENU ===");
                System.out.println("1. Add Room Type");
                System.out.println("2. Update Room Count");
                System.out.println("3. Update Room Price");
                System.out.println("4. View Inventory");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Room Type: ");
                        String type = sc.nextLine();

                        System.out.print("Enter Room Count: ");
                        int count = sc.nextInt();

                        System.out.print("Enter Price per Night: ");
                        double price = sc.nextDouble();

                        inventory.addRoomType(type, count, price);
                        break;

                    case 2:

                        System.out.print("Enter Room Type: ");
                        String type1 = sc.nextLine();

                        System.out.print("Enter New Room Count: ");
                        int newCount = sc.nextInt();

                        inventory.updateRoomCount(type1, newCount);
                        break;

                    case 3:

                        System.out.print("Enter Room Type: ");
                        String type2 = sc.nextLine();

                        System.out.print("Enter New Price: ");
                        double newPrice = sc.nextDouble();

                        inventory.updateRoomPrice(type2, newPrice);
                        break;

                    case 4:
                        inventory.displayRooms();
                        break;

                    case 5:
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
    }
}
