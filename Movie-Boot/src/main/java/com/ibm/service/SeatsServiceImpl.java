package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Seats;
import com.ibm.repo.SeatsRepository;

@Service
public class SeatsServiceImpl implements SeatsService {

	@Autowired
	private SeatsRepository repo;
	
	@Override
	public Seats fetch(String seatId) {
		return repo.findById(seatId).get();
	}

	@Override
	public List<Seats> list(int status) {
		return repo.findByStatus(status);
	}

	@Override
	public void save(Seats s) {
		repo.save(s);
	}

}
