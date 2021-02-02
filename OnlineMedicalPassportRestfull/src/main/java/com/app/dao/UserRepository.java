package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Users;

public interface UserRepository extends JpaRepository<Users ,Integer>{

	 
	 Optional<Users>findByFirstname(String uFirstName);
	 
}
