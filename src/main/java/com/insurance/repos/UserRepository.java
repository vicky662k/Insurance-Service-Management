package com.insurance.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entites.Users;


@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
	
	

}
