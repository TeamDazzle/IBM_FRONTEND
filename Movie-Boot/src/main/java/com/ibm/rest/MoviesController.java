package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Movies;
import com.ibm.service.MoviesService;


@RestController
public class MoviesController {
	
	@Autowired
	private MoviesService service;
	
	
	//http://localhost:8000/addMovies
	@PostMapping(value="/addMovies", consumes="application/json")
	public String save(@RequestBody Movies m) {
		int movieId=service.save(m);
		return "Movie added with id: "+movieId;
	}
	
	//http://localhost:8000/getMovies
	@GetMapping(value="/getMovies/{movieId}", produces="application/json")
	public Movies fetch(@PathVariable int movieId)
	{
		return service.fetch(movieId);
	}
	
	//http://localhost:8000/movies
	@GetMapping(value = "/movies/{mName}", produces = "application/json")
	public Movies name(@PathVariable String mName) {
		System.out.println(mName);
		return service.byName(mName);
	}
	
	//http://localhost:8880/listmovies
	@GetMapping(value="/listMovies", produces="application/json")
	public List<Movies> list()
	{
		return service.list();
	}
	
	//http://localhost:8000/listGenere
	@GetMapping(value = "/listGenere/{gen}",produces = "application/string")
	public List<Movies> genere(@PathVariable String gen){
		System.out.println(gen);
		return service.byGenere(gen);
	}
	
	//http://localhost:8000/listFormat
	@GetMapping(value = "/listFormat/{format}",produces = "application/string")
	public List<Movies> form(@PathVariable String format){
		System.out.println(format);
		return service.byFormat(format);
	}
	
	//http://localhost:8000/listLanguage
	@GetMapping(value = "/listLanguage/{lang}",produces = "application/string")
	public List<Movies> language(@PathVariable String lang){
		System.out.println(lang);
		return service.byLang(lang);
	}
	
	//http://localhost:8000/listStatus
	@GetMapping(value = "/listStatus/{status}",produces = "application/string")
	public List<Movies> status(@PathVariable int status){
		System.out.println(status);
		return service.byStatus(status);
	}
	
	//http://localhost:8000/deleteMovies
	@DeleteMapping(value = "/deleteMovies/{movie_id}")
	public boolean delete(@PathVariable int movie_id) {
		return service.remove(movie_id);
	}
}
