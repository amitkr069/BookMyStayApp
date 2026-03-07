package com.model;

public class Reservation {
	private String guestName;
	private String roomType;
	private String roomId;
	
	public Reservation(String guestName, String roomType) {
		this.guestName = guestName;
		this.roomType = roomType;
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
}
