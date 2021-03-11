package com.example.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.SuperVillain;

public class DirectServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(DirectServlet.class);
	
	/*
	 * 3 Steps to create a servlet:
	 * 
	 * Step 1: create a class that inherits from HttpServlet or GenericServlet
	 * 
	 * Step 2: Override the doGet and doPost methods()
	 * 	-we do NOT override the init()method (abstracted)
	 * 
	 * step 3: Configure the servlet in your web.xml (Deployment Descriptor) 
	 */
	
	//this is happening in the background
//	public void init() throws ServletException{
//		
//	}
	
	// this method allows a servlet to handle a GET request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html><body><h1>The Servlet is talking directly to the client!</h1></body></html>");
		log.info("Test");
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("application/json");
		
		// the object that I send back will correspond to an object that I've defined a CLASS for in my Java app.
		SuperVillain sheev = new SuperVillain("Sheev Palpatine", "Evilness", 250000);
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(sheev));
		
		log.info("We're in the post method!");
		
	}
	
}	
