package com.sample.restaurantreview.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.restaurantreview.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	
	List<User> findAll();
	
	@Query("select u from User u where u.userName=:userName")
	List<User> findByName(String userName);
}
