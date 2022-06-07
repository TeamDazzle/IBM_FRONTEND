package com.ibm.service;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Bookings;
import com.ibm.entity.Shows;
import com.ibm.repo.BookingRepository;
import com.ibm.repo.ShowsRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository repo;
	
	@Autowired
	private ShowsRepository showService;
	
	
	@Override
	public int save(Bookings b, int showId) {
		Shows s = showService.findById(showId).get();
		b.setShows(s);
		repo.save(b);
		return b.getBookingId();
	}

	@Override
	public Bookings fetch(int bookingId) {
		return repo.findById(bookingId).get();
	}

	@Override
	public Bookings list(int showId) {
		return repo.findById(showId).get();
	}

	@Override
	public boolean remove(int bookingId) {
		repo.deleteById(bookingId);
		return true;
	}

}
