package com.auth;

import com.service.*;
import java.util.Scanner;

import com.inventory.RoomInventory;
import com.service.*;
public class AdminLogin {
	private RoomInventory inventory;
	private BookingService bookingService;
	private AddOnServiceManager serviceManager;

    public AdminLogin(RoomInventory inventory, BookingService bookingService, AddOnServiceManager serviceManager) {
        this.inventory = inventory;
        this.bookingService = bookingService;
        this.serviceManager = serviceManager;
    }
    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";
    
    Scanner sc = new Scanner(System.in);
    
    
    public boolean login() {
        

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
    
    public void adminAccess() {
//    	RoomInventory inventory = new RoomInventory();
//    	SearchService searchService = new SearchService();
//        RoomInventory inventory = new RoomInventory();
//    	BookingService booking = new BookingService();
            while (true) {

                System.out.println("\nAdmin Dashboard");
                System.out.println("1. Add Room Type: (Single, Double, Suite)");
                System.out.println("2. Update Room Count");
                System.out.println("3. Update Room Price");
                System.out.println("4. View Inventory");
                System.out.println("5. Process Bookings");
                System.out.println("6. Add Service");
                System.out.println("7. View Booking History");
                System.out.println("8. Generate Report");
                System.out.println("9. Back");

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
                        sc.nextLine();

                        System.out.print("Enter Amenities: ");
                        String amenities = sc.nextLine();

                        inventory.addRoom(type, count, price, amenities);

                        break;

                    case 2:

                        System.out.print("Enter Room Type: ");
                        String rType = sc.nextLine();

                        System.out.print("Enter New Count: ");
                        int newCount = sc.nextInt();
                        sc.nextLine();

                        inventory.updateRoomCount(rType, newCount);

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
                    	bookingService.processBookings(inventory);
                    	break;
                    case 6:
                    	System.out.print("Enter Service name: ");
                    	String serviceName = sc.nextLine();
                    	
                    	serviceManager.addService(serviceName);
                    	break;
                    case 7:
                    	bookingService.viewBookingHistory();
                    	break;
                    case 8:
                    	bookingService.generateReport();
                    	break;
                    case 9:
                        return;
                }
            }
        
    }
}