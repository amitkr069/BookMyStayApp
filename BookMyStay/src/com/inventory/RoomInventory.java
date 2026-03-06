//package com.inventory;
//
//import java.util.HashMap;
//
//public class RoomInventory {
//
//    HashMap<String, Integer> roomCount = new HashMap<>();
//    HashMap<String, Double> roomPrice = new HashMap<>();
//
//    // Add new room type
//    public void addRoomType(String type, int count, double price) {
//
//        roomCount.put(type, count);
//        roomPrice.put(type, price);
//
//        System.out.println(type + " room added successfully!");
//    }
//
//    // Update room count
//    public void updateRoomCount(String type, int newCount) {
//
//        if (roomCount.containsKey(type)) {
//            roomCount.put(type, newCount);
//            System.out.println("Room count updated successfully!");
//        } else {
//            System.out.println("Room type not found!");
//        }
//    }
//
//    // Update room price
//    public void updateRoomPrice(String type, double newPrice) {
//
//        if (roomPrice.containsKey(type)) {
//            roomPrice.put(type, newPrice);
//            System.out.println("Room price updated successfully!");
//        } else {
//            System.out.println("Room type not found!");
//        }
//    }
//
//    // Display inventory
//    public void displayRooms() {
//
//        System.out.println("\nCurrent Room Inventory:");
//
//        for (String type : roomCount.keySet()) {
//
//            System.out.println(
//                    "Room Type: " + type +
//                    " | Available: " + roomCount.get(type) +
//                    " | Price: " + roomPrice.get(type)
//            );
//        }
//    }
//}

//package com.inventory;

//import java.util.HashMap;
//
//public class RoomInventory {
//
//    HashMap<String, Integer> roomCount = new HashMap<>();
//    HashMap<String, Double> roomPrice = new HashMap<>();
//    HashMap<String, String> roomAmenities = new HashMap<>();
//
//    public void addRoomType(String type, int count, double price, String amenities) {
//
//        roomCount.put(type, count);
//        roomPrice.put(type, price);
//        roomAmenities.put(type, amenities);
//
//        System.out.println(type + " room added successfully!");
//    }
//
//    public HashMap<String, Integer> getRoomCount() {
//        return roomCount;
//    }
//
//    public HashMap<String, Double> getRoomPrice() {
//        return roomPrice;
//    }
//
//    public HashMap<String, String> getAmenities() {
//        return roomAmenities;
//    }
//}



package com.inventory;

import java.util.HashMap;

public class RoomInventory {

    HashMap<String, Integer> roomCount = new HashMap<>();
    HashMap<String, Double> roomPrice = new HashMap<>();
    HashMap<String, String> roomAmenities = new HashMap<>();

    // Add room type
    public void addRoom(String type, int count, double price, String amenities) {

        roomCount.put(type, count);
        roomPrice.put(type, price);
        roomAmenities.put(type, amenities);

        System.out.println(type + " room added successfully.");
    }

    // Update room count
    public void updateRoomCount(String type, int count) {

        if (roomCount.containsKey(type)) {
            roomCount.put(type, count);
            System.out.println("Room count updated.");
        } else {
            System.out.println("Room type not found.");
        }
    }
    
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

        System.out.println("\nRoom Inventory:");

        for (String type : roomCount.keySet()) {

            System.out.println(
                    "Room Type: " + type +
                    " | Available: " + roomCount.get(type) +
                    " | Price: " + roomPrice.get(type) +
                    " | Amenities: " + roomAmenities.get(type)
            );
        }
    }

    public HashMap<String, Integer> getRoomCount() {
        return roomCount;
    }

    public HashMap<String, Double> getRoomPrice() {
        return roomPrice;
    }

    public HashMap<String, String> getAmenities() {
        return roomAmenities;
    }
}