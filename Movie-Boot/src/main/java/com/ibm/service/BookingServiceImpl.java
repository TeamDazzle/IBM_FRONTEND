package com.ibm.service;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Bookings;
import com.ibm.entity.Shows;
import com.ibm.entity.Users;
import com.ibm.repo.BookingRepository;
import com.ibm.repo.ShowsRepository;
import com.ibm.repo.UsersRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository repo;
	
	@Autowired
	private ShowsRepository showService;
	
	@Autowired
	private UsersRepository userService;
	
	
	@Override
	public int save(Bookings b, int showId, String email) {
		Shows s = showService.findById(showId).get();
		Users u = userService.findById(email).get();
		b.setShow(s);
		b.setUser(u);
		repo.save(b);
		return b.getBookingId();
	}

	
	
	@Override
	public Bookings fetch(int bookingId) {
		return repo.findById(bookingId).get();
	}



	@Override
	public boolean remove(int bookingId) {
		repo.deleteById(bookingId);
		return true;
	}



	@Override
	public List<Bookings> listAll() {
		return  repo.findAll();
	}



	@Override
	public List<Bookings> listByUsers(String email) {
		return repo.findByUsers(email);
	}

}
