package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Admin;
import com.ibm.repo.AdminRepository;

@Service
public class AdminServiceImpl implements AdminServices {
	
	@Autowired
	private AdminRepository repo;

	@Override
	public boolean checkadmin(Admin a) {
		if (repo.existsById(a.getAdminid())) {
			Admin currentadmin = repo.findById(a.getAdminid()).get();
			if (currentadmin.getPassword().equals(a.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public int save(Admin a) {
		repo.save(a);
		return a.getAdminid();
	}
	
	

}
