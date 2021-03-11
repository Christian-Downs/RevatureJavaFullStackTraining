package com.example.indirectservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class inderectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(inderectServlet.class);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("In the INdirect doGet() method");
		
		/* there is a method on the response object called sendRirect()
			This allows us to redirect the user to another resource
		*/
		
		//redirect to an external page
//		response.sendRedirect("https://www.google.com");
		
		//redirect to another servlet
		//response.sendRedirect("http://localhost:8090/HelloServilets/dirserv");
		
		//redirect to an html page
		response.sendRedirect("resources/html/somepage.html");
		
		
	}

	
	/*
	 * Request dispathcer is an interface whoes implementation
	 *  defines an object which can dispatch the request to any resources on the server
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rdis = request.getRequestDispatcher("resources/html/somepage.html");
		
		rdis.forward(request, response);
	}

}
