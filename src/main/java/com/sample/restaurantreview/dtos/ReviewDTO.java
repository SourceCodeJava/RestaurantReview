package com.sample.restaurantreview.dtos;

import java.util.Date;

import com.sample.restaurantreview.model.Review;
import com.sample.restaurantreview.model.ReviewStatus;

public class ReviewDTO {

	private long reviewId;
	private String userid;
	private long restaurantid;
	private double rating;
	private Date date;
	private String comment;
	private ReviewStatus status;

	public ReviewDTO() {

	}

	public ReviewDTO(Review review) {

		reviewId = review.getReviewId();
		userid = review.getUser().getUserid().toString();
		restaurantid = review.getRestaurant().getRestaurantid();
		rating = review.getRating();
		comment = review.getComment();
		date = review.getDate();
		status = review.getStatus();

	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public long getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(long restaurantid) {
		this.restaurantid = restaurantid;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ReviewStatus getSatus() {
		return status;
	}

	public void setSatus(ReviewStatus status) {
		this.status = status;
	}

}
