package com.ibm.rest;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Users;
import com.ibm.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	private UserService service;

	
	//http://localhost:8000/users/
	@GetMapping("/users")
	public List<Users> list(){
		return service.list();
	}
	
	//http://localhost:8000/users/s@gmail.com
	@GetMapping("/users/{email}")
	public ResponseEntity<Users> get(@PathVariable String email) {
		try {
			Users users =  service.fetch(email);
			return new ResponseEntity<Users>(users,HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
	}
	
	//http://localhost:8000/users/signup
	@PostMapping(value = "/users/signup", consumes = "application/json")
	public String add(@RequestBody Users users ) {
		service.save(users);
		return "Adder user with Name: "+users.getFullname();
	}

	//http://localhost:8000/users/getname/s@gmail.com
	@GetMapping("users/getname/{email}")
	public String getUser(@PathVariable String email) {
		String mail = service.fetch(email).getFullname();
		return mail;
	}
	
	//http://localhost:8000/users/s@gmail.com
	@DeleteMapping("/users/{email}")
	public void delete(@PathVariable String email) {
		service.delete(email);
	}
	
	//http://localhost:8000/users/s@gmail.com
	@PutMapping("users/{email}")
	public ResponseEntity<Users> update(@RequestBody Users users, @PathVariable String email) {
		try {
			Users existUser = service.fetch(email); 
			System.out.print(existUser);
			service.save(users);
			return new ResponseEntity<Users>(HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND); 
		}
	}

	//http://localhost:8000/users/login
	@PostMapping("users/login")
	public boolean check(@RequestBody Users users) {
		return service.checklogin(users.getEmail(), users.getPassword());
		
	}
	
	
}
