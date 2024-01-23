package com.andreySpring.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreySpring.userdept.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}

