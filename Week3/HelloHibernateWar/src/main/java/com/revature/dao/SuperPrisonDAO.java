package com.revature.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.SuperPrison;
import com.revature.util.HibernateUtil;

public class SuperPrisonDAO {
	public void insert(SuperPrison prison) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(prison);
		tx.commit();
	}
	
	public void update(SuperPrison prison) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(prison);
		tx.commit();
	}
	
	public SuperPrison selectById(int id) {
		Session ses = HibernateUtil.getSession();
		SuperPrison sp = ses.get(SuperPrison.class, id);
		return sp;
	}
	
	public List<SuperPrison> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		List<SuperPrison> prisons = ses.createQuery("from SuperPrison",SuperPrison.class).list();
		
		return prisons;
	}
}
