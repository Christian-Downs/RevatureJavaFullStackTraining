package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.services.EmployeeService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LoginServlet.class);
    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		log.info("User attempted to login with the username " + username);
		
		Employee e = EmployeeService.confirmLogin(username, password);
		
		//stwp three create a session to remeber the user
		
		if(e!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			//4. redirect the user to the home page because they succesffuylly logged in
			RequestDispatcher rd = request.getRequestDispatcher("home.html"); // we will create this ... this welcoms the user upon succesfful login
			
			rd.forward(request,response);
			log.info(username + " has succesfully logged in");
			
		} else {
			log.info(username + " has failed to log in");
			//we will exopand upon this and create a failure page later and redirect the user there
		}
		
		

	}

}
