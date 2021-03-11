package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.SuperVillain;
import com.revature.util.HibernateUtil;

public class SuperVillainDao {
	
	public SuperVillainDao() {
		
	}
	
	public void insert(SuperVillain villain) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(villain);
		
		tx.commit();
	}
	
	public void update(SuperVillain villain) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.update(villain);
		tx.commit();
	}
	
	public SuperVillain selectById(int id) {
		Session ses = HibernateUtil.getSession();
		
		SuperVillain vill = ses.get(SuperVillain.class,id);
		
		return vill;
	}
	
	
	public SuperVillain selectByName(String name) {
		
		Session ses = HibernateUtil.getSession();
		
		//HQL --> Hibernate Query Language
		// creates a complex query by using a combo of native
		// SQL and oop
		// hql targets java objects, not sql tables
		
		List<SuperVillain> villList1 = ses.createQuery("from SuperVillain where name ='" + name + "'",SuperVillain.class).list();
		
		//NATIVE SQL
		//create complex queries using plain old sql
		//List<SuperVillain> villList1 = ses.createNativeQuery("SELECT * FROM Super_Villain WHERE name = '" + name + "'",SuperVillain.class).list();
		
		if(villList1.size()==0) {
			System.out.println("No villian found");
			return null;
		}
		return villList1.get(0);
	}
	
	public List<SuperVillain> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		List<SuperVillain> villList = ses.createQuery("from SuperVillain",SuperVillain.class).list();
		
		return villList;
	}

}
