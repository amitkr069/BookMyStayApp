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
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
	private Queue<Reservation> bookingQueue = new LinkedList<>();
	
	private Set<String> BookedroomIds = new HashSet<>();
	
	private HashMap<String, Set<String>> roomAllocations = new HashMap<>();
	
	private Map<String, Reservation> reservations = new HashMap<>();
	
	private List<Reservation> bookingHistory = new ArrayList<>();
	
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
			
			reservations.put(reservation.getReservationId(), reservation);
			
			bookingHistory.add(reservation);
			
			System.out.println("Reservation Confirmed | Guest: "
					+ reservation.getGuestName()
					+ " | Room Type: "
					+ type
					+ " | Room ID: "
					+ roomId
					+ "Reservation ID: "
					+ reservation.getReservationId()
					);
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
	
	public void viewBookings(String guestName, AddOnServiceManager serviceManager) {
		boolean found = false;
		
		for(Reservation r: reservations.values()) {
			if(r.getGuestName().equals(guestName));{
				found = true;
				
				System.out.println("\nReservation ID: " + r.getReservationId());
				System.out.println("Guest Name: " + r.getGuestName());
				System.out.println("Room Type: " + r.getRoomType());
				System.out.println("Status: " + r.getStatus());
				
				serviceManager.showRoomServices(r.getReservationId());
				System.out.println();
			}
		}
		if(!found) {
			System.out.println("No Bookings found");
			
		}
	}
	
	public void cancelBooking(String guestName, RoomInventory inventory) {
		for(Reservation r: bookingHistory) {
			if(r.getGuestName().equals(guestName)) {
				r.cancelReservation();
				
				String roomType = r.getRoomType();
				
				int current = inventory.getRoomCount().get(roomType);
				
				inventory.getRoomCount().put(roomType, current + 1);
				
				System.out.println("Reservation cancelled for: " + guestName);
				return;
			}
		}
		
		System.out.println("Reservation not found.");
	}
	
	public void viewBookingHistory() {
		if(bookingHistory.isEmpty()) {
			System.out.println("No booking history found. ");
			return;
		}
		
		for(Reservation r: bookingHistory) {
			System.out.println("Reservation ID: " + r.getReservationId()
					+ " | Guest: " + r.getGuestName()
					+ " | Room Type: " + r.getRoomType()
					+ " | Room ID: " + r.getRoomId()
					+ " | Status: " + r.getStatus()
					);
		}
	}
	
	public void generateReport() {
		Map<String, Integer> report = new HashMap<>();
		
		for(Reservation r: bookingHistory) {
			if(r.getStatus().equals("CONFIRMED")) {
				
				report.put(r.getRoomType(), report.getOrDefault(r.getRoomType(), 0) + 1);
			}
		}
		
		System.out.println("\nBooking Report: ");
		
		for(String type: report.keySet()) {
			System.out.println("Room Type: " 
					+ type
					+ " | Total Bookings: " 
					+ report.get(type));
		}
	}
	
}
