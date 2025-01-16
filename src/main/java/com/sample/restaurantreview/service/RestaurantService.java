package com.sample.restaurantreview.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.restaurantreview.dtos.RestaurantDTO;
import com.sample.restaurantreview.model.Restaurant;
import com.sample.restaurantreview.repository.RestaurantRepository;
import com.sample.restaurantreview.repository.ReviewRepository;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;

	@Autowired
	ReviewRepository reviewRepository;

	public Restaurant save(RestaurantDTO restaurant) {

		Restaurant newRestaurant = restaurantRepository.save(new Restaurant(restaurant));
		return newRestaurant;
	}

	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}

	public List<Restaurant> findByCusineType(String cusinetype) {
		return restaurantRepository.findByCusineType(cusinetype);
	}

	public List<Restaurant> findByName(String name) {
		List<Restaurant> restList = restaurantRepository.findByName(name);
		return restList;

	}

	public Restaurant findByRestaurantid(long restaurantid) {
		Optional<Restaurant> maybeRestaurant = restaurantRepository.findByRestaurantid(restaurantid);
		if (!maybeRestaurant.isPresent())
			return null;
		/*
		 * int total = totalReviews(restaurantid); double avgRating =
		 * avgRating(restaurantid);
		 */
		Restaurant restaurant = maybeRestaurant.get();
		/*
		 * restaurant.setTotalReviews(total); restaurant.setAvgRating(avgRating);
		 */

		return restaurant;
	}

	public Restaurant avgRating(long restaurantid) {

		double avg = reviewRepository.avgRatingByRestaurantid(restaurantid);
		int total = reviewRepository.totalReviewsByRestaurantid(restaurantid);
		Optional<Restaurant> maybeRestaurant = restaurantRepository.findByRestaurantid(restaurantid);
		Restaurant restaurant = maybeRestaurant.get();
		restaurant.setAvgRating(avg);
		restaurant.setTotalReviews(total);
		return restaurant;
	}

}