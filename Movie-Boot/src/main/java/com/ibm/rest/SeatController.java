package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Seats;
import com.ibm.service.SeatsService;

@RestController
public class SeatController {
	
	@Autowired
	private SeatsService service;
	
	@PostMapping(value = "/addSeats", consumes = "application/json")
	public String add(@RequestBody Seats s) {
		service.save(s);
		return "Added seat "+s.getSeatId();
	}
	
	
	
	@GetMapping(value = "/getSeats/{seatId}", produces = "application/json")
	public Seats get(@PathVariable String seatId) {
		return service.fetch(seatId);
	}
	
	@GetMapping(value = "/getSeatsList/{status}", produces = "application/json")
	public List<Seats> fetch(@PathVariable int status) {
		return service.list(status);
	}
	
	
	

}
