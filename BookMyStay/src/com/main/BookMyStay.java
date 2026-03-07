
/**
 * @author Amit
 * @version 6.0
 * This is use Case 6;
 * Saving Booking history and reporting feature implemented

 */
package com.main;
import com.auth.*;

import java.util.Scanner;
import com.inventory.*;
import com.guest.*;
import com.service.*;

public class BookMyStay {
	
	public static void main(String[] args) {
		RoomInventory inventory = new RoomInventory();
		GuestService guestService = new GuestService();
        BookingService bookingService = new BookingService();
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        Scanner sc = new Scanner(System.in);
        
        while(true) {
        	
        
	        System.out.println("1. Admin access");
	        System.out.println("2. User Accesss");
	        System.out.println("3. Exit");
	        
	        System.out.print("Enter choice: ");
	        int choice = sc.nextInt();
	        
	        switch (choice) {
	        	case 1:
	        		AdminLogin admin = new AdminLogin(inventory, bookingService, serviceManager);
	        		if(admin.login()) {
	        			admin.adminAccess();
	        		}
	        		break;
	        	case 2:
	        		User.userLogin(inventory, guestService, bookingService, serviceManager);
	        		break;
	        	case 3:
	        		System.exit(0);
	        	
	        }
        }

        
    }
}



