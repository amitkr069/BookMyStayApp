package com.service;

import com.model.*;
import com.inventory.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;

public class BookingService {
	private Queue<Reservation> bookingQueue = new LinkedList<>();
	
	private Set<String> BookedroomIds = new HashSet<>();
	
	private HashMap<String, Set<String>> roomAllocations = new HashMap<>();
	
	public void addRequest(String guestName, String roomType, AddOnServiceManager serviceManager, Scanner sc) {
		try {
			Thread.sleep(2000);
		}
		
		catch (InterruptedException e){
			e.printStackTrace();
		}
		
		String reservationId = generateReservationId();
		
		
		Reservation reservation = new Reservation(guestName, roomType, reservationId);
		
		bookingQueue.add(reservation);
		
		System.out.println("Booking request created for " + guestName);
		System.out.println("Reservation Id: " + reservationId);
		
		serviceManager.selectServices(reservationId, sc);
		
	}
	
	public void processBookings(RoomInventory inventory) {
		if(bookingQueue.isEmpty()) {
			System.out.println("No pending booking requests. ");
			return;
		}
		
		while(!bookingQueue.isEmpty()) {
			Reservation reservation = bookingQueue.poll();
			
			String type = reservation.getRoomType();
			
			if(!inventory.getRoomCount().containsKey(type)) {
				System.out.println("Invalid room type requested by " + reservation.getGuestName());
				continue;
			}
			
			int available = inventory.getRoomCount().get(type);
			
			if(available <= 0) {
				System.out.println("No room available for "+ reservation.getGuestName());
				continue;
			}
			
			String roomId = generateRoomId(type);
			
			reservation.setRoomId(roomId);
			
			BookedroomIds.add(roomId);
			
			roomAllocations.computeIfAbsent(type, k -> new HashSet<>()).add(roomId);
			
			inventory.getRoomCount().put(type, available - 1);
			
			System.out.println("Reservation Confirmed | Guest: "
					+ reservation.getGuestName()
					+ " | Room Type: "
					+ type
					+ " | Room ID: "
					+ roomId);
		}
	}
	
	private String generateRoomId(String type) {
		String roomId = "";
		

		roomId = type.substring(0, 2).toUpperCase()
	            + new Random().nextInt(1000);
	
	    // Keep generating until it is not in bookedRoomIds
	    while (BookedroomIds.contains(roomId)) {
	        roomId = type.substring(0, 2).toUpperCase()
	                + new Random().nextInt(1000);
	    }
	    return roomId;

	}
	
	public void showAllocations() {
		System.out.println("\nRoom Allocations: ");
		
		for(String type: roomAllocations.keySet()) {
			System.out.println("Room Type: "
					+ type
					+ " -> "
					+ roomAllocations.get(type)
					);
		}
	}
	
	private String generateReservationId() {
		return "RES" + (1000+ new Random().nextInt(9000));
	}
	
	
}
