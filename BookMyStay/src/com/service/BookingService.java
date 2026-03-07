package com.service;

import com.model.*;

import java.util.LinkedList;
import java.util.Queue;

public class BookingService {
	private Queue<Reservation> bookingQueue = new LinkedList<>();
	
	public void addRequest(String guestName, String roomType) {
		try {
			Thread.sleep(2000);
		}
		
		catch (InterruptedException e){
			e.printStackTrace();
		}
		
		
		Reservation reservation = new Reservation(guestName, roomType);
		
		bookingQueue.add(reservation);
		
		System.out.println("Booking request added to queue for " + guestName);
		System.out.println("Current Queue Size: " + bookingQueue.size());
		System.out.println("Request is waiting for processing.");
	}
	
	
}
