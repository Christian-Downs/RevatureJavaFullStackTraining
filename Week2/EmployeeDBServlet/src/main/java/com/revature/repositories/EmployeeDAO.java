package com.revature.repositories;

import java.util.List;

import com.revature.model.Employee;

/*
 * DAO stands for data access object -- the object (in impl form) that we use to access our DB
 * We use the DAO design pattern to separate business logic (java) from our persistence layer
 */

public interface EmployeeDAO {
	public boolean insert(Employee e); //returns true if successfully instered
	public boolean update(Employee e); 
	public boolean delete(Employee e);
	
	public List<Employee> findAll(); // this will return all employee objects from the DB
	// we will use this in our service layer and filter it to return JUST one employee that mathches
	// username + password
	
}
