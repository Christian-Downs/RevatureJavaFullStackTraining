package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.services.EmployeeService;

public class ConnectionUtil {
	
	
	// this is boilerplate code
	private static Logger log = Logger.getLogger(ConnectionUtil.class);
	
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e){
			log.warn("Cannot load the driver");
			e.printStackTrace();
		}
		
		
		
		Properties props = new Properties();
		//This ClassLoader isn't always necessary, but it's an obj used to search through our entire project
		// to find our connection.properties file to give us the connection creds
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Connection conn = null;
		
		try {
			props.load(loader.getResourceAsStream("connection.properties"));
			//capture the connection url
			String url = props.getProperty("url");
			//capture the username
			String username = props.getProperty("username");
			//capture the password
			String password = props.getProperty("password");
			try {
				conn = DriverManager.getConnection(url,username,password);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	
	public static void main(String[] args) {
		// 1) create employee
//		Employee e = new Employee("Test123","testy", "McTestface","password");
//		
//		EmployeeService.insert(e);
//		
		System.out.println(EmployeeService.findAll().toString());
	}
	

}
