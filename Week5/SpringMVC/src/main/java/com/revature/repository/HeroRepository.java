package com.revature.repository;

import java.util.List;

import com.revature.model.Hero;

public interface HeroRepository {
	
	void save (Hero hero);
	
	Hero findByName(String name);
	
	List<Hero> findAll();
}
