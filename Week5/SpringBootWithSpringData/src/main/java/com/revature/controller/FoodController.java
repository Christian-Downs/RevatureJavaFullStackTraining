package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Food;
import com.revature.repository.FoodRepo;

@RestController
@RequestMapping("/food")
@CrossOrigin(origins = "http://localhost:4200")
public class FoodController {
	@Autowired
	private FoodRepo foodRepo;
	
	@GetMapping("/all")
	public List<Food> findAllFoods() {
		return (List<Food>)foodRepo.findAll();
	}
	
	@GetMapping("/pizza")
	public Food findPizza() {
		return foodRepo.findByDishName("pizza");
	}
	
	@PostMapping("/findFood")
	public Food findFood(String dishName) {
		return foodRepo.findByDishName(dishName);
	}
	
	@PostMapping("/add")
	public String insertFood(@RequestBody Food food) {
		try {
			foodRepo.save(food);
			return "Success";
		} catch (Exception e) {
			return "Error";
		}
		
	}
}
