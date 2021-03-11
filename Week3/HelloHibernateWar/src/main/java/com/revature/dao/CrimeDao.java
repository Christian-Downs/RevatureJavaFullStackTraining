package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Crime;
import com.revature.util.HibernateUtil;

public class CrimeDao {
// we will just create an insert method for Crime
	public void insert(Crime crime) {
		Session ses = HibernateUtil.getSession();
		
		//The transaction interface is used for managing ACID compient transactions against the db
		//pteform the opperation on the db 
		Transaction tx = ses.beginTransaction();
		ses.save(crime); //3 use the save() seession mehtod to perform an insert peration
		
		tx.commit();
	}
}
