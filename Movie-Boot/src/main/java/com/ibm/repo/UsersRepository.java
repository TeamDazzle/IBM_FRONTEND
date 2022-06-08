package com.ibm.repo;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String>{

}
