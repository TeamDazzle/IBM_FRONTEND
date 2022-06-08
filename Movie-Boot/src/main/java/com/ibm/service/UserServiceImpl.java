package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Users;
import com.ibm.repo.UsersRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UsersRepository repo;
	
	@Override
	public void save(Users users) {
		repo.save(users);

	}

	@Override
	public Users get(String email) {
		return repo.findById(email).get();
	}

	@Override
	public List<Users> list() {
		return repo.findAll();
	}

	@Override
	public boolean checkuser(String email) {
		return repo.existsById(email);
	}

	@Override
	public void delete(String email) {
		repo.deleteById(email);
	}

	@Override
	public boolean checklogin(String email, String password) {
		if (checkuser(email)) {
			Users users = get(email);
			if(users.getPassword().equals(password)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}	}

}
