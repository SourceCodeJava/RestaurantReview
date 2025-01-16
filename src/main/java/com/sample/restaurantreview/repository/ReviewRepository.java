package com.sample.restaurantreview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.restaurantreview.model.Review;
import com.sample.restaurantreview.model.ReviewStatus;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	List<Review> findByStatus(ReviewStatus status);

	@Query("select r from Review r where r.restaurant.name=:restaurantName")
	List<Review> findReviewByRestaurantName(String restaurantName);

	//List<Review> findByStatusAndRestaurantId(ReviewStatus status, long restaurantId);

	@Query("select count(r) from Review r where r.restaurant.restaurantid=:restaurantid")
	int totalReviewsByRestaurantid(long restaurantid);

	@Query("select avg(r.rating) from Review r where r.restaurant.restaurantid=:restaurantid")
	double avgRatingByRestaurantid(long restaurantid);
}
