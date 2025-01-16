package com.sample.restaurantreview.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.restaurantreview.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	List<Restaurant> findByName(String name);

	List<Restaurant> findAll();

	List<Restaurant> findByCusineType(String cusinetype);

	@Query("select r from Restaurant r where r.restaurantid=:restaurantid")
	Optional<Restaurant> findByRestaurantid(long restaurantid);

}
