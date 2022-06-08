package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Integer> {
	
}
