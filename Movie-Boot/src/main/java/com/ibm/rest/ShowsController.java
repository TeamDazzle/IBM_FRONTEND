package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Shows;
import com.ibm.service.ShowsService;

@RestController
public class ShowsController {
	
	@Autowired
	private ShowsService service;
	
	//http://localhost:8000/add
	@PostMapping(value = "/add/{sId}/{movie_id}", consumes = "application/json")
	public void add(@RequestBody Shows s, @PathVariable int sId, @PathVariable int movie_id ) {
		int id = service.add(s, sId, movie_id);
		System.out.println("Shows Created for "+ movie_id +" with id: "+ id);
	}
	
	//http://localhost:8000/get/screen/
	@GetMapping(value = "/get/screen/{sId}", produces = "application/json")
	public Shows get(@PathVariable int sId) {
		return service.fetch(sId);
	}
	
	//http://localhost:8000/listShows
	@GetMapping(value = "/listShows", produces = "application/json")
	public List<Shows> list() {
		return service.list();
	}
	

}
