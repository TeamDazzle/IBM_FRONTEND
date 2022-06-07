package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.ibm.entity.Movies;

public interface MoviesRepository extends JpaRepository<Movies,Integer>{
	
	@Query(value = "FROM Movies WHERE movie_name=:mName")
	Movies findByName(String mName);
	
	@Query(value = "FROM Movies WHERE format=:form")
	List<Movies> findByFormat(String form);
	
	@Query(value = "FROM Movies WHERE genere=:gen")
	List<Movies> findByGenere(String gen);
	
	@Query(value = "FROM Movies WHERE language=:lang")
	List<Movies> findByLanguage(String lang);

	@Query(value = "FROM Movies WHERE status=:stat")
	List<Movies> findByStatus(int stat);
	
}
