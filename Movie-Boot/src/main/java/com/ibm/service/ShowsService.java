package com.ibm.service;

import java.util.List;

import com.ibm.entity.Shows;

public interface ShowsService {
	
	int add(Shows s, int sId, int movie_id);
	
	Shows fetch(int sId);
	
	Shows byMovieId(int movie_id);
	
	List<Shows> list();

}
