package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.model.LoginTemplate;
import com.revature.services.EmployeeService;

public class RequestHelper {
	private static Logger log = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();
	
	public static void processLogin(HttpServletRequest req, HttpServletResponse response) throws IOException {
		// we want to turn whatever we recieve as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s= new StringBuilder();
		//logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		while(line !=null) {
			s.append(line);
			line = reader.readLine();
		}
				
		
		String body = s.toString();
		
		log.info(body);
		
		// I'm going to build a model called LoginTemplate which holds a username and password
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
		
		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();
		
		log.info("User attempt to login with username: " + username);
		
		Employee e = EmployeeService.confirmLogin(username, password);
		
		if(e != null) {
			//get the current session OR create one if it doesn't exist
			HttpSession session = req.getSession();
			
			session.setAttribute("username", username);
			
			PrintWriter pw = response.getWriter();
			
			response.setContentType("application/json");
			
			pw.println(om.writeValueAsString(e));
			
			
//			RequestDispatcher rd = req.getRequestDispatcher("home.html");
//			try {
//				rd.forward(req, response);
//			} catch (ServletException|IOException e1) {
//				e1.printStackTrace();
//			}
			log.info(username + " has successfully logged in");
		} else {
			response.setStatus(204);
		}
				
	}
	
	
	public static void processLogout(HttpServletRequest req, HttpServletResponse res) throws IOException{
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			String username = (String) session.getAttribute("username");
			log.info(username + " has logged out");
			session.invalidate();
		}
		res.setStatus(200);
	}
	
	
	// This method purpose is to return all employees from the DB in JSON form
	public static void processEmployees(HttpServletRequest req, HttpServletResponse res) throws IOException{
		//1.Set the content type to app/json becuase we will be sending json data back to the client,
		// stuck alonside the response
		
		res.setContentType("application/json");
		
		// 2. get a list of all employees
		List<Employee> allEmps = EmployeeService.findAll();
		
		//3. turn the list of java obj 
		String json = om.writeValueAsString(allEmps);
		
		// 4. use getWriter() from the response object to return the json string
		PrintWriter pw = res.getWriter();
		pw.println(json);
		
	}
	
}
