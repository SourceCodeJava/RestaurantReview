package com.sample.restaurantreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.restaurantreview.dtos.UserDTO;
import com.sample.restaurantreview.model.Restaurant;
import com.sample.restaurantreview.model.User;
import com.sample.restaurantreview.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public String save(UserDTO user) {
		List<User> existing = userRepository.findByName(user.getUserName());
		if (existing.size() > 0)
			return "Duplicate";

		User newUser = new User();
		newUser.setUserName(user.getUserName());
		newUser.setPassword(user.getPassword());
		userRepository.save(newUser);
		return newUser.getUserid().toString();
	}

	public User findByNameAndPassword(String name, String password) {
		List<User> existing = userRepository.findByName(name);
		if (existing.size() != 1)
			return null;
		User u = existing.get(0);
		if (password.equals(u.getPassword())) {
			return u;
		}
		return null;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

}
