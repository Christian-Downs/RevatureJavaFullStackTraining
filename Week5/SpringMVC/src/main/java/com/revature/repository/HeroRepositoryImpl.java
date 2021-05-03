package com.revature.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Hero;


// @Repository annotation indicates that this class provides a mechanism
// for CRUD operations of this particular object
@Repository("heroRepository")
@Transactional
public class HeroRepositoryImpl implements HeroRepository{
	
	private static Logger logger = Logger.getLogger(HeroRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public HeroRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}
	
	@Override
	public void save(Hero hero) {
		sessionFactory.getCurrentSession().save(hero);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hero> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Hero.class).list();
	}

	@Override
	public Hero findByName(String passedThruName) {
		try {
			return (Hero) sessionFactory.getCurrentSession().createCriteria(Hero.class).add(Restrictions.like("name", passedThruName)).list().get(0);
		} catch (Exception e) {
			logger.debug(e);
		}
		return null;
	}
	
	
}
