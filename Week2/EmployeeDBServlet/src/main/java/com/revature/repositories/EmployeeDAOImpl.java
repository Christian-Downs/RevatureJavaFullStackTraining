package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;


// THis is where we write some statements (SQL)!
public class EmployeeDAOImpl implements EmployeeDAO{

	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);
	@Override
	public boolean insert(Employee e) {
		PreparedStatement stmt = null;
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO employee (first_name, last_name,username,pass_word) " +
					"VALUES (?,?,?,?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getFirstName());
			stmt.setString(2, e.getLastName());
			stmt.setString(3, e.getUserName());
			stmt.setString(4, e.getPassword());
			if(!stmt.execute()) {
				return false;
			}
		} catch (SQLException ex) {
			log.warn("Unable to insert user",ex);
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean delete(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<Employee> findAll() /*returns null if unsuccessful*/ {
		List<Employee> output = new ArrayList<Employee>();
		
		PreparedStatement stmt = null;
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from employee";
			
			stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String username = rs.getString("username");
				String password = rs.getString("pass_word");
				Employee e = new Employee(id,first_name,last_name,username,password);
				output.add(e);
			}
		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users",ex);
		}
		return output;
	}


	
}
