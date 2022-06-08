package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Movies;
import com.ibm.repo.MoviesRepository;


@Service
public class MoviesServiceImpl implements MoviesService {
	
	
	@Autowired
	private MoviesRepository repo;
	
	public int save(Movies m) {
		repo.save(m);
		return m.getMovie_id();
	}

	@Override
	public Movies fetch(int movieId) {
		return repo.findById(movieId).get();
	}

	@Override
	public List<Movies> list() {
		return repo.findAll();
	}

	@Override
	public boolean remove(int movieId) {
		repo.deleteById(movieId);
		return true;
	}

	@Override
	public Movies byName(String mName) {
		return repo.findByName(mName);
	}

	@Override
	public List<Movies> byGenere(String gen) {
		return repo.findByGenere(gen);
	}

	@Override
	public List<Movies> byLang(String lang) {
		return repo.findByLanguage(lang);
	}

	@Override
	public List<Movies> byStatus(int status) {
		return repo.findByStatus(status);
	}

	@Override
	public List<Movies> byFormat(String format) {
		return repo.findByFormat(format);
	}
	
	

}
