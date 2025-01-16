package com.sample.restaurantreview.dtos;

import java.util.UUID;

import com.sample.restaurantreview.model.Restaurant;

public class RestaurantDTO {
	private long restaurantid;
	private String name;
	private String address;
	private String cusineType;

	public RestaurantDTO() {
	}

	public RestaurantDTO(Restaurant rest) {
		restaurantid = rest.getRestaurantid();
		name = rest.getName();
		address = rest.getAddress();
		cusineType = rest.getCusineType();

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(long restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCusinetype() {
		return cusineType;
	}

	public void setCusinetype(String cusineType) {
		this.cusineType = cusineType;
	}
}
