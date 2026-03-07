package com.model;

public class Reservation {
	private String guestName;
	private String roomType;
	private String roomId;
	private String reservationId;
	private String status; 
	
	public Reservation(String guestName, String roomType, String reservationId) {
		this.guestName = guestName;
		this.roomType = roomType;
		this.reservationId = reservationId;
		this.status = "CONFIRMED";
	}
	
	public String getGuestName() {
		return guestName;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
	public String getRoomId() {
		return roomId;
	}
	
	public String getReservationId() {
		return reservationId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void cancelReservation() {
		this.status = "CANCELLED";
	}
}
