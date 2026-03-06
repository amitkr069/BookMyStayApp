package com.main;
import com.auth.*;

import java.util.Scanner;
import com.inventory.*;
import com.inventory.*;

public class BookMyStay {
	
	public static void main(String[] args) {
		RoomInventory inventory = new RoomInventory();

        Scanner sc = new Scanner(System.in);
        
        while(true) {
        	
        
        System.out.println("1. Admin access");
        System.out.println("2. User Accesss");
        System.out.println("3. Exit");
        
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        
        switch (choice) {
        	case 1:
        		AdminLogin admin = new AdminLogin(inventory);
        		if(admin.login()) {
        			admin.adminAccess();
        		}
        		break;
        	case 2:
        		User.userLogin(inventory);
        		break;
        	case 3:
        		System.exit(0);
        	
        }
        }
        
//        RoomInventory inventory = new RoomInventory();

        
    }
}



