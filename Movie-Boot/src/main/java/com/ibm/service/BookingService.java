package com.ibm.service;

import java.util.List;

import com.ibm.entity.Bookings;

public interface BookingService {
	
	int save(Bookings b, int showId);

	Bookings fetch(int bookingId);
	
	Bookings list(int showId); //Admin

	
	boolean remove(int bookingId);

}
