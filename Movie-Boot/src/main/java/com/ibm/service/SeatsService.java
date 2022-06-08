package com.ibm.service;

import java.util.List;

import com.ibm.entity.Seats;

public interface SeatsService {
	
	void save(Seats s);
	
	Seats fetch(String seatId);
	
	List<Seats> list(int status);

}
