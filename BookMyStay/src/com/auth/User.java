package com.auth;

import java.util.Scanner;
import com.guest.*;
import com.inventory.*;
import com.service.*;

public class User {
	public static void userLogin(RoomInventory inventory) {
		Scanner sc = new Scanner(System.in);

        GuestService guestService = new GuestService();
        SearchService searchService = new SearchService();
//        RoomInventory inventory = new RoomInventory();
        
        
        while (true) {

            System.out.println("\n1 Register");
            System.out.println("2 Login");
            System.out.println("3 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    guestService.register();
                    break;

                case 2:

                    if (guestService.login()) {

                        while (true) {

                            System.out.println("\nGuest Dashboard");
                            System.out.println("1 View Available Rooms");
                            System.out.println("2 Logout");

                            int c = sc.nextInt();

                            if (c == 1) {
                                searchService.showAvailableRooms(inventory);
                            }

                            else if (c == 2) {
                                break;
                            }
                        }
                    }

                    break;

                case 3:
                    System.exit(0);
            }
        }
	}
}
