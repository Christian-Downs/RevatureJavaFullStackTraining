package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="FOOD")
@Getter @Setter @EqualsAndHashCode @ToString
public class Food {
	@Id
	@Column(name="food_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodInt;
	
	@Column(name="dish_name")
	private String dishName;
	
	@Column(name="calories")
	private double calories;
	
	public Food() {}

	public Food(int foodInt, String dishName, double calories) {
		super();
		this.foodInt = foodInt;
		this.dishName = dishName;
		this.calories = calories;
	}

	public Food(String dishName, double calories) {
		super();
		this.dishName = dishName;
		this.calories = calories;
	}
	
	
	
	
}
