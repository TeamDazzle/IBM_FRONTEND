package com.ibm.service;

import java.util.List;
import com.ibm.entity.Movies;
public interface MoviesService {
	
	int save(Movies m);
	
	Movies fetch(int movieId);
	
	Movies byName(String mName);
	
	List<Movies> byGenere(String gen);
	
	List<Movies> byLang(String lang);
	
	List<Movies> byStatus(int status);
	
	List<Movies> byFormat(String format);
	
	List<Movies> list();
	
	boolean remove(int movieId);

}
