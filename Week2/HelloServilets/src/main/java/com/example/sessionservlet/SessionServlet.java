package com.example.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.SuperVillain;


public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SessionServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SuperVillain muddy = new SuperVillain("Mud Man","Mud armor", 100000);
		
		/*
		 * The HttpSession interface provides a way to identify a user
		 * across more than just one page request or visit to a website and to store info about 
		 * that user. this makes user experience better!
		 * 
		 * theis doGet() method is using this interface to create a session
		 * between
		 */
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("villain", muddy);
		
		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(muddy));
		out.println("Mud man is on the loos and the session is set");
	
		
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//when I hit doPost() (so, I send a POST method to this servlet, I CREATE a new villain object
		String name = request.getParameter("name");
		String superPower= request.getParameter("superpower");
		int bounty = Integer.parseInt(request.getParameter("bounty"));
		
		SuperVillain tempVillain = new SuperVillain(name,superPower,bounty);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("villain", tempVillain);
		
//		PrintWriter out = response.getWriter();
//		out.println("A villain is on the loose");
//		out.write(new ObjectMapper().writeValueAsString(tempVillain));
		
		
		
		
		
	}

}
