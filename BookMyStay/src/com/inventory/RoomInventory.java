package com.inventory;

import java.util.HashMap;

public class RoomInventory {

    HashMap<String, Integer> roomCount = new HashMap<>();
    HashMap<String, Double> roomPrice = new HashMap<>();

    // Add new room type
    public void addRoomType(String type, int count, double price) {

        roomCount.put(type, count);
        roomPrice.put(type, price);

        System.out.println(type + " room added successfully!");
    }

    // Update room count
    public void updateRoomCount(String type, int newCount) {

        if (roomCount.containsKey(type)) {
            roomCount.put(type, newCount);
            System.out.println("Room count updated successfully!");
        } else {
            System.out.println("Room type not found!");
        }
    }

    // Update room price
    public void updateRoomPrice(String type, double newPrice) {

        if (roomPrice.containsKey(type)) {
            roomPrice.put(type, newPrice);
            System.out.println("Room price updated successfully!");
        } else {
            System.out.println("Room type not found!");
        }
    }

    // Display inventory
    public void displayRooms() {

        System.out.println("\nCurrent Room Inventory:");

        for (String type : roomCount.keySet()) {

            System.out.println(
                    "Room Type: " + type +
                    " | Available: " + roomCount.get(type) +
                    " | Price: " + roomPrice.get(type)
            );
        }
    }
}