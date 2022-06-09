package com.ibm.service;

import java.util.List;

import com.ibm.entity.Bookings;

public interface BookingService {
	
	int save(Bookings booking, int seatId, String email);
	
	List<Bookings> listAll();
	
	List<Bookings> listByUsers(String email);

	Bookings fetch(int bookingId);
	
	boolean remove(int bookingId);

}
