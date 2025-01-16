package com.sample.restaurantreview.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.restaurantreview.dtos.ReviewDTO;
import com.sample.restaurantreview.model.Review;
import com.sample.restaurantreview.service.ReviewService;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@PostMapping
	public ResponseEntity<Review> save(@RequestBody ReviewDTO review) {
		Review newReview = reviewService.save(review);
		return ResponseEntity.ok().body(newReview);
	}

	@GetMapping("/{restaurantname}")
	public ResponseEntity<List<Review>> findReviewByRestaurantName(
			@PathVariable("restaurantname") String restaurantname) {
		List<Review> result = reviewService.findReviewByRestaurantName(restaurantname);
		return ResponseEntity.ok().body(result);
	}

}
