package com.ibm.service;

import java.util.List;

import com.ibm.entity.Users;

public interface UserService {
	
	void save(Users users);
	
	Users get(String email);
	
	List<Users> list();
	
	boolean checkuser(String email);
	
	void delete(String email);
	
	boolean checklogin(String email, String password);

}
