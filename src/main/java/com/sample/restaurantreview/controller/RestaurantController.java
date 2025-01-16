package com.sample.restaurantreview.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.restaurantreview.dtos.RestaurantDTO;
import com.sample.restaurantreview.model.Restaurant;
import com.sample.restaurantreview.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "*")
public class RestaurantController {

	private RestaurantService restaurantService;

	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@PostMapping
	public ResponseEntity<RestaurantDTO> save(@RequestBody RestaurantDTO restaurant) {
		Restaurant newRestaurant = restaurantService.save(restaurant);
		return ResponseEntity.ok().body(new RestaurantDTO(newRestaurant));
	}

	@GetMapping()
	public ResponseEntity<List<Restaurant>> findAll() {
		List<Restaurant> result = restaurantService.findAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<List<Restaurant>> RestaurantByname(@PathVariable("name") String name) {
		List<Restaurant> result = restaurantService.findByName(name);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> findByRestaurantid(@PathVariable("id") long restaurantid) {
		Restaurant result = restaurantService.findByRestaurantid(restaurantid);
		if (result == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/cusinetype/{type}")
	public ResponseEntity<List<Restaurant>> RestaurantsByCusineType(@PathVariable("type") String cusinetype) {
		List<Restaurant> result = restaurantService.findByCusineType(cusinetype);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/{id}/rating")
	public ResponseEntity<Restaurant> avgRating(@PathVariable("id") long restaurantid) {
		Restaurant restaurant = restaurantService.avgRating(restaurantid);
		if (restaurant == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(restaurant);
		} else {
		}
		return ResponseEntity.ok().body(restaurant);
	}

}
