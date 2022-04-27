package com.qa.skyrim.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.skyrim.entity.User;

@Repository 
public interface UserRepo extends JpaRepository<User, Integer> {
	
}
