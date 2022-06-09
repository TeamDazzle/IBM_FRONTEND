package com.ibm.rest;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Bookings;
import com.ibm.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	//http://localhost:8000/book
	@PostMapping(value = "/book/{showId}/{email}", consumes = "application/json")
	public String add(@RequestBody Bookings b, @PathVariable int showId, @PathVariable String email) {
		System.out.println(showId+" "+email);
		int id = service.save(b,showId,email);
		return "Booking is Confirmed, Your Booking Id is: "+id;
	}
	
	//http://localhost:8000/getBook
	@GetMapping(value = "/getBook/{bookingId}", produces = "application/json")
	public Bookings fetch(@PathVariable int bookingId) {
		return service.fetch(bookingId);
	}
	
	//http://localhost:8000/getShowBook
	@GetMapping(value = "/getShowBook", produces = "application/json")
	public List<Bookings> get(){
		return service.listAll();
	}
	
	
	//http://localhost:8000/getBookUser
	@GetMapping(value = "/getBookUser", produces = "application/json")
	public List<Bookings> find(@RequestParam String email){
		return service.listByUsers(email);
	}
	

	
	//http://localhost:8000/delete
	@DeleteMapping(value = "/delete/{bookingId}",produces = "application/json")
	public boolean delete(@PathVariable int bookingId) {
		service.remove(bookingId);
		return true;
	}
	
	

}
