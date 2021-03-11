package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	
	/*
	 * Creating the HibernateUtil.java Helper file
	 * 
	 * To use Hibernate, you need to create a helper class that handles startup
	 * and access hibernate's SessionFactory to obtain a session object
	 * 
	 * (interface)
	 * Session managed the connection to DB and provides CRUD operations (Create, Read, update, delete)
	 *
	 * (class)
	 * Configuration's job is to gather info from the hibernate.cfg.xml file and then build the session factory.
	 * 
	 * (interface)
	 * Session Factory's job is to create sessions and store info on how
	 * to make connections to your DB
	 * 
	 * (interface)
	 * Transaction manages... well.... your transaction
	 * 
	 * 
	 * query is used to write complex CRUD operations using HQL (Hibernate Query Language)
	 */

	
	
	private static Session ses;
	
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	// We create a getSession() mehtod which is going to be called in our DAO layer
	// This method obtains a JDBC connection which we can use to perform a 
	// transaction against our DB
	public static Session getSession() {
		
		if(ses == null) {
			ses = sf.openSession();
		}
		
		return ses;
	}
	
	public static void closeSes() {
		ses.close();
		sf.close();
		
		//By closing our session, you free up the connections from the conn pool
		// so that it can be used by a new session.
	}
}
