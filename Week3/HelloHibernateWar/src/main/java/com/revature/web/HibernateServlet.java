package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.CrimeDao;
import com.revature.dao.SuperPrisonDAO;
import com.revature.dao.SuperVillainDao;
import com.revature.models.Crime;
import com.revature.models.SuperPrison;
import com.revature.models.SuperVillain;

/**
 * Servlet implementation class HibernateServlet
 */
public class HibernateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SuperVillainDao supervdao = new SuperVillainDao();
    /**
     * Default constructor. 
     */
    public HibernateServlet() {
//        initialValues();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("we are in the hibernate servelt");
		
		System.out.println("\n About to select by name:");
		
		System.out.println(supervdao.selectByName("Joker"));
		
		PrintWriter pw = response.getWriter();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static void initialValues() {
		//create new crime objs
		Crime c1 = new Crime("Arson","setting something ablaze");
		Crime c2 = new Crime("Freeze","covering a whole city in ice");
		Crime c3 = new Crime("Time Manipulation", "freeze time, rob banks");
		
		//create a crime dao
		CrimeDao cDao = new CrimeDao();
		
		
		//use the crimeDao to insert the crimes
		cDao.insert(c1);
		cDao.insert(c2);
		cDao.insert(c3);
		
		//build a list of these crimes
		List<Crime> crimes = new ArrayList<Crime>();
		crimes.add(c1);
		crimes.add(c2);
		crimes.add(c3);
		// Create superPrison
		
		SuperPrison sp1 = new SuperPrison("Azkaban","England");
		
		
		//I'll instanties the super villains
		
		SuperVillain sv1 = new SuperVillain("Joker","Evilness",10000,crimes,sp1);
		
		SuperVillainDao svdao = new SuperVillainDao();
		svdao.insert(sv1);
		
		// Create a superprisondao here
		SuperPrisonDAO spdao = new SuperPrisonDAO();
		
		List<SuperVillain> villains = new ArrayList<SuperVillain>();
		villains.add(sv1);
		
		sp1.setVillList(villains);
		
//		// insert sp1..
		spdao.insert(sp1);
	}
}
