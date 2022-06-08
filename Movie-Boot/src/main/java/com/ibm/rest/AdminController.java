package com.ibm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Admin;
import com.ibm.service.AdminServices;

@RestController
public class AdminController {
	@Autowired
	private AdminServices service;
	
	//http://localhost:8000/addAdmin
	@PostMapping("/addAdmin")
	public String add(@RequestBody Admin a) {
		int c = service.save(a);
		return "Admin signed in with id: "+c;
	}
	
	//http://localhost:8000/admin
	@PostMapping("/admin")
	public ResponseEntity<Boolean> checkadmin(@RequestBody Admin admin){
		return new ResponseEntity<Boolean> (service.checkadmin(admin),HttpStatus.OK);
	}
}