package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Integer> {
	
	@Query("FROM Bookings WHERE email=:emailId")
	List<Bookings> findByUsers(String emailId);
	
}
