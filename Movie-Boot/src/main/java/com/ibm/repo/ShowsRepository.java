package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.Shows;

public interface ShowsRepository extends JpaRepository<Shows, Integer>{
	
	@Query(value = "from shows where screen_id= :sId", nativeQuery = true)
	List<Shows> findByScreen(int sId);
	
	@Query(value = "from shows where movie_id= :movie_id", nativeQuery = true)
	Shows findByMovie(int movie_id);

}
