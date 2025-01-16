package com.sample.restaurantreview.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sample.restaurantreview.dtos.ReviewDTO;
import com.sample.restaurantreview.model.Restaurant;
import com.sample.restaurantreview.model.Review;
import com.sample.restaurantreview.model.ReviewStatus;
import com.sample.restaurantreview.model.User;
import com.sample.restaurantreview.repository.RestaurantRepository;
import com.sample.restaurantreview.repository.ReviewRepository;
import com.sample.restaurantreview.repository.UserRepository;

@Service
public class ReviewService {
	@Autowired
	RestaurantRepository restaurantRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	UserRepository userRepository;

	public Review save(ReviewDTO review) {
		Review newReview = new Review(review);
		System.out.println("review.getSatus()" + review.getSatus());
		if (review.getSatus() == ReviewStatus.ACCEPTED)
			newReview.setStatus(ReviewStatus.ACCEPTED);
		else if (review.getSatus() == ReviewStatus.PENDING)
			newReview.setStatus(ReviewStatus.PENDING);
		else if (review.getSatus() == ReviewStatus.REJECTED)
			newReview.setStatus(ReviewStatus.REJECTED);

		System.out.println("newReview" + newReview.getStatus());

		Optional<Restaurant> maybeRestaurant = restaurantRepository.findByRestaurantid(review.getRestaurantid());

		if (maybeRestaurant.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"restaurant with id: " + review.getRestaurantid() + " does not exist");
		}
		Restaurant restaurant = maybeRestaurant.get();
		newReview.setRestaurant(restaurant);

		Optional<User> maybeUser = userRepository.findById(UUID.fromString(review.getUserid()));
		User user = maybeUser.get();
		newReview.setUser(user);

		reviewRepository.save(newReview);
		return newReview;
	}

	public List<Review> findReviewByRestaurantName(String restaurantName) {
		return reviewRepository.findReviewByRestaurantName(restaurantName);
	}

	public int totalReviews(long restaurantid) {
		return reviewRepository.totalReviewsByRestaurantid(restaurantid);
	}

	/*
	 * public double avgRating(long restaurantid) { return
	 * reviewRepository.avgRatingByRestaurantid(restaurantid); }
	 */
}
