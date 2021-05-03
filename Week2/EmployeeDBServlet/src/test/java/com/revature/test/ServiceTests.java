package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.Employee;
import com.revature.repositories.EmployeeDAOImpl;
import com.revature.services.EmployeeService;

public class ServiceTests {
	//class to be tested
	private EmployeeService eServ;
	
	//dependencies that our service layer needs in order to make contact with the db
	// later we will MOCK this and trick our application
	// into thinking that it's connecting to a DB when its not.
	private EmployeeDAOImpl edaoImpl;
	
	
	@Before
	public void setup() {
		eServ = new EmployeeService();
	
		
		/*
		 * Here, we're creating a fake DB connection...
		 * and tricking our Service layer
		 */
		edaoImpl = mock(EmployeeDAOImpl.class);
		
		eServ.eDao = edaoImpl;
		
	}
	
	// A happy path is a default dcenario in which we allow it input and expected output without exceptions
	
	@Test
	public void happyPathScenario() {
		Employee sampleEmployee = new Employee(1,"a","b","c","d");
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(sampleEmployee);
		
		when(edaoImpl.findAll()).thenReturn(list);
		
		Employee foundByUsername = eServ.findByUsername(sampleEmployee.getUserName());
		
		assertEquals(sampleEmployee, foundByUsername);
	}
	
	@Test
	public void employeeIsNotPresentInDB() {
		List<Employee> emptyList = new ArrayList<Employee>();
		
		when(edaoImpl.findAll()).thenReturn(emptyList);
		
		Employee foundByUsername = eServ.findByUsername("tester");
		
		assertEquals(null, foundByUsername);
	}
	
	
}
