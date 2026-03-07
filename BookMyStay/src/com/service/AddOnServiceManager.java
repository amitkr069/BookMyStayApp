package com.service;

import java.util.*;

public class AddOnServiceManager {

    // Available services added by admin
    private List<AddOnService> availableServices = new ArrayList<>();

    
    private Map<String, List<AddOnService>> roomServices = new HashMap<>();


    
    // Admin adds new service
    
    public void addService(String serviceName) {

        AddOnService service = new AddOnService(serviceName);

        availableServices.add(service);

        System.out.println(serviceName + " service added.");
    }


    // Display services
    public void showServices() {

        System.out.println("\nAvailable Services:");

        int i = 1;

        for(AddOnService s : availableServices) {

            System.out.println(i + ". " + s.getName());
            i++;
        }
    }


    // Guest selects services
    public void selectServices(String reservationId, Scanner sc) {

        if(availableServices.isEmpty()) {
            System.out.println("No services available.");
            return;
        }

        showServices();

        List<AddOnService> selectedServices = new ArrayList<>();

        while(true) {

            System.out.print("Enter service number (0 to stop): ");
            int choice = sc.nextInt();

            if(choice == 0)
                break;

            if(choice > 0 && choice <= availableServices.size()) {

                AddOnService s = availableServices.get(choice-1);

                selectedServices.add(s);

                System.out.println(s.getName() + " added.");

            } else {
                System.out.println("Invalid choice");
            }
        }

        roomServices.put(reservationId, selectedServices);

        System.out.println("Services added for room " + reservationId);
    }


    // View services for a room
    public void showRoomServices(String reservationId) {

        if(!roomServices.containsKey(reservationId)) {
            System.out.println("No services selected.");
            return;
        }

        System.out.println("Services for room " + reservationId);

        for(AddOnService s : roomServices.get(reservationId)) {
            System.out.println("- " + s.getName());
        }
    }
}
