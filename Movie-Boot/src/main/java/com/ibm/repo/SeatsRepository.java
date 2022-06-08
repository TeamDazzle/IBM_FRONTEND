package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.Seats;

public interface SeatsRepository extends JpaRepository<Seats, String> {
	
	@Query("FROM Seats WHERE status=:stat")
	List<Seats> findByStatus(int stat);

}
