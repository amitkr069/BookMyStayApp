package com.auth;

import java.util.Scanner;
import com.guest.*;
import com.inventory.*;
import com.service.*;

public class User {
	public static void userLogin(RoomInventory inventory, GuestService guestService,
	        BookingService bookingService, AddOnServiceManager serviceManager) {
		Scanner sc = new Scanner(System.in);

//        GuestService guestService = new GuestService();
        SearchService searchService = new SearchService();
//        BookingService booking = new BookingService();
//        RoomInventory inventory = new RoomInventory();
        
//        boolean user = true;
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
//                    	boolean loggedIn = true;

                        while (true) {

                            System.out.println("\nGuest Dashboard");
                            System.out.println("1 View Available Rooms");
                            System.out.println("2. Add Booking Request");
                            System.out.println("3. Logout");

                            int c = sc.nextInt();
                            sc.nextLine();
                            
                            switch(c) {
                            case 1:
                                searchService.showAvailableRooms(inventory);
                                break;
                            case 2:
                            	System.out.print("Enter Your Name: ");
                            	String name = sc.nextLine();
                            	
                            	System.out.print("Enter room type: ");
                            	String roomType = sc.nextLine();
                            	
                            	bookingService.addRequest(name, roomType, serviceManager, sc);
                            	break;
                            case 3:
                            	return;
                            }

                        }
                    }

                    break;

                case 3:
                	return;
            }
        }
	}
}
