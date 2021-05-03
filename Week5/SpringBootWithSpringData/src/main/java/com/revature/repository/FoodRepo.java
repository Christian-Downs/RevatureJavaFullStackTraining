package com.revature.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.model.Food;

public interface FoodRepo extends CrudRepository<Food,Integer> {
	public Food findByDishName(String dishName);
	public Food findByDishNameIgnoreCaseAndCalories(String dishName, double calories);
	public List<Food> findByOrderByDishName();
}
