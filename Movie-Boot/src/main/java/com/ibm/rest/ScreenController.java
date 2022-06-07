package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Screen;
import com.ibm.service.ScreenService;

@RestController
public class ScreenController {
	
	@Autowired
	private ScreenService service;
	
	//http://localhost:8880/add
	@PostMapping(value = "/add", consumes = "application/json")
	public String save(@RequestBody Screen s) {
		int sId = service.save(s);
		return "Screen Added with id: "+sId;
	}
	
	//http://localhost:8880/get/sId
	@GetMapping(value = "/get/{sId}", produces = "application/json")
	public Screen fetch(@PathVariable int sId) {
		return service.fetch(sId);
	}
	
	//http://localhost:8880/list
	@GetMapping(value = "/list", produces = "application/json")
	public List<Screen> list(){
		return service.list();
	}
}
