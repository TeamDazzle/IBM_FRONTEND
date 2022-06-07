package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Screen;
import com.ibm.repo.ScreenRepository;

@Service
public class ScreenServiceImpl implements ScreenService {
	
	@Autowired
	private ScreenRepository repo;

	@Override
	public int save(Screen s) {
		repo.save(s); 
		return s.getsId();
	}

	@Override
	public Screen fetch(int sId) {
		return repo.findById(sId).get();
	}

	@Override
	public List<Screen> list() {
		return repo.findAll();
	}

}
