package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.dao.CrimeDao;
import com.revature.dao.SuperPrisonDAO;
import com.revature.dao.SuperVillainDao;
import com.revature.models.Crime;
import com.revature.models.SuperPrison;
import com.revature.models.SuperVillain;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initialValues();
		//firstLevelCaching();
		
		secondLevelCaching();
		//SuperPrisonDAO spdao = new SuperPrisonDAO();
		
		//System.out.println(spdao.selectAll());
		
		HibernateUtil.closeSes();
	}
	
	public static void firstLevelCaching() {
		
		/*
		 * By default, Hibernate allows first level caching...
		 * 
		 * this means that any data that a particular session retrieves, is stored
		 * and accessible within the context of that particular session (and no other session)
		 * 
		 */
		
		Session ses1 = HibernateUtil.getSession();
		
		//I will ust the session get() or load()  mehtods to return a n entity from the db
		SuperVillain vill1 = ses1.load(SuperVillain.class, 4);
		System.out.println("First call output: " + vill1.getName());
		
		/*
		 * There are some handy mehtods we can apply to sessions:
		 * 
		 * 		.evict() -- this clears all of the entities from the particular session itself (on the session level)
		 * 		.clear()
		 * 		.refresh()
		 */
		ses1.evict(vill1);
		
		System.out.println(ses1.getStatistics().getEntityCount());
	}
	
	public static void secondLevelCaching() {
		/*
		 * SECOND LEVEL CACHING
		 * 
		 * By default, Hibernate diables this...
		 * The developer needs to enable it explicitly, and the sessionfactory object is responsible
		 * for maintaining it.
		 * 
		 * 
		 */
		
		Session ses1 = HibernateUtil.getSession();
		
		Session ses2 = HibernateUtil.getSession();
		
		SuperVillain vill1 = ses1.load(SuperVillain.class, 4);
		
		System.out.println(vill1.getName());
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
