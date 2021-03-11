package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;

import jdk.internal.org.jline.utils.Log;

public class EmployeeService {
	private static Logger log = Logger.getLogger(EmployeeService.class);
	public static EmployeeDAO eDao = new EmployeeDAOImpl();
	public static boolean insert(Employee e) {
		return eDao.insert(e);
	}
	
	public static boolean update(Employee e) {
		return eDao.update(e);
	}
	
	public static List<Employee> findAll(){
		return eDao.findAll();
	}
	
	public static Employee findByUsername(String username) {
		List<Employee> all = eDao.findAll();
		
		for(Employee e : all) {
			if(e.getUserName().equals(username)) {
				return e;
			}
		}
		return null;
	}
	
	public static Employee confirmLogin(String username, String password) {
		log.info("Inside confirm login with username = " + username + " and password with = " + password);
		Employee e = findByUsername(username);
		if(e==null) {
			return null;
		}
		else if(e.getPassword().equals(password)) {
			return e;
		}
		else {
			return null;
		}
	}
}
