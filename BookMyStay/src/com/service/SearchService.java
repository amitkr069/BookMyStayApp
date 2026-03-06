package com.service;


import com.inventory.*;

public class SearchService {

    public void showAvailableRooms(RoomInventory inventory) {

        System.out.println("\nAvailable Rooms:");

        for (String type : inventory.getRoomCount().keySet()) {

            int count = inventory.getRoomCount().get(type);

            if (count > 0) {

                System.out.println(
                        "Room Type: " + type +
                        " | Price: " + inventory.getRoomPrice().get(type) +
                        " | Amenities: " + inventory.getAmenities().get(type) +
                        " | Available: " + count
                );
            }
        }
    }
}
