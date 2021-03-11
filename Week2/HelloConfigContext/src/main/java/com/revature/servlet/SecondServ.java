package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServ
 */
public class SecondServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//By defult, since we didn't set any load-on-startup values for the servlet,
	//it will default to LAZY initalization
	
	private int visits = 0;
	@Override
    public void init() {
        System.out.println("second serv has been initialized");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contextEx = getServletContext().getInitParameter("contextExample");
		String configEx = getServletConfig().getInitParameter("configExample");
		
		System.out.println("contextEx: "+contextEx+"& the configEx "+ configEx + " visits " + visits++);
	}

}
