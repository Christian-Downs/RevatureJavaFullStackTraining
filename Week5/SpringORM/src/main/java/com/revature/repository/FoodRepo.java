package com.revature.repository;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("foodRepo")
@Transactional
public class FoodRepo {
	
	@Autowired
	private SessionFactory sesFact;
	
	public void FoodRepoo() {
		
	}

}
