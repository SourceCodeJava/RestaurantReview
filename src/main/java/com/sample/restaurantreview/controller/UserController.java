package com.sample.restaurantreview.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.restaurantreview.dtos.UserDTO;
import com.sample.restaurantreview.model.DiningUser;
import com.sample.restaurantreview.model.User;
import com.sample.restaurantreview.service.JwtService;
import com.sample.restaurantreview.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

	private UserService us;
	private JwtService jwtService;

	public UserController(UserService us, JwtService jwtService) {
		this.us = us;
		this.jwtService = jwtService;
	}

	@PostMapping
	public ResponseEntity<String> save(@RequestBody UserDTO user) {
		if (user.getUserName().isBlank() || user.getPassword().isBlank()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty user name or password");
		}

		String key = us.save(user);
		System.out.println("key"+key);
		if (key.equals("Duplicate")) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this name already exists");
		} else if (key.equals("Error")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Can not generate key");
		}
		String token = jwtService.makeJwt(key);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(token);
	}

	@PostMapping("/login")
	public ResponseEntity<String> checkLogin(@RequestBody UserDTO user) {
		User result = us.findByNameAndPassword(user.getUserName(), user.getPassword());
		if (result == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user name or password");
		}
		String token = jwtService.makeJwt(result.getUserid().toString());
		return ResponseEntity.ok().body(token);
	}

	@GetMapping("/login")
	public ResponseEntity<String> checkLoginID(@RequestBody UserDTO user) {
		User result = us.findByNameAndPassword(user.getUserName(), user.getPassword());
		if (result == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user name or password");
		}
		String token = result.getUserid().toString();
		return ResponseEntity.ok().body(token);
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public Iterable<User> findAllUsers() {
		return this.us.findAll();
	}

}
