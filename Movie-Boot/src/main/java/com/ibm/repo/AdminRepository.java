package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
