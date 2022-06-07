package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Integer> {
	
	

}
