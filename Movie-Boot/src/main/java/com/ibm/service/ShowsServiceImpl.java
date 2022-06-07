package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Movies;
import com.ibm.entity.Screen;
import com.ibm.entity.Shows;
import com.ibm.repo.MoviesRepository;
import com.ibm.repo.ScreenRepository;
import com.ibm.repo.ShowsRepository;


@Service
public class ShowsServiceImpl implements ShowsService {

	@Autowired
	private ShowsRepository repo;
	
	@Autowired
	private ScreenRepository scrService;
	
	@Autowired
	private MoviesRepository mservice;
	
	@Override
	public int add(Shows s, int sId, int movie_id) {
		Screen scr = scrService.findById(sId).get();
		Movies mov = mservice.findById(movie_id).get();
		s.setScreen(scr);
		s.setMovie(mov);
		repo.save(s);
		return s.getShowId();
	}

	@Override
	public Shows fetch(int sId) {
		return repo.findById(sId).get();
	}

	@Override
	public Shows byMovieId(int movie_id) {
		return (Shows) repo.findByMovie(movie_id);
	}


}
