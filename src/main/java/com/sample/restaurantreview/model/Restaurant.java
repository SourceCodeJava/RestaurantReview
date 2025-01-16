package com.sample.restaurantreview.model;

import java.util.UUID;

import com.sample.restaurantreview.dtos.RestaurantDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "restaurantid")
	private long restaurantid;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "cusineType")
	private String cusineType;

	@Column(name = "avgRating")
	private double avgRating;

	@Column(name = "totalReviews")
	private int totalReviews;

	public Restaurant() {
	}

	public Restaurant(RestaurantDTO restDto) {
		name = restDto.getName();
		address = restDto.getAddress();
		cusineType = restDto.getCusinetype();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCusineType() {
		return cusineType;
	}

	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}

	public long getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(long restaurantid) {
		this.restaurantid = restaurantid;
	}

	public int getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(int totalReviews) {
		this.totalReviews = totalReviews;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

}
