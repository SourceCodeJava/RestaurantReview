package com.sample.restaurantreview.model;

import java.util.Date;

import com.sample.restaurantreview.dtos.ReviewDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "REVIEW")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long reviewId;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	@ManyToOne
	@JoinColumn(name="restaurantid")
	private Restaurant restaurant;
	
	@Column(name="rating")
	private double rating;

	@Column(name = "comment")
	private String comment;
	
	private Date date;

	@Enumerated(EnumType.STRING)
	private ReviewStatus status;
	
	
	public Review() {}
	
	public Review(ReviewDTO review) {
		
		rating = review.getRating();
		comment = review.getComment();
		date = review.getDate();
		status = review.getSatus();
	}
	

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ReviewStatus getStatus() {
		return status;
	}

	public void setStatus(ReviewStatus status) {
		this.status = status;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double  rating) {
		this.rating = rating;
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
