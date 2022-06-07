package com.ibm.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {
	
	

}
