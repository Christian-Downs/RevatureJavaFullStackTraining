package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.services.MotdServiceBean;

public class MainBean {
	
	private MotdServiceBean motdServiceBean = new MotdServiceBean();
	
	public MainBean(MotdServiceBean motdServiceBean) {
		this.motdServiceBean = motdServiceBean;
	}
	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
		
		MainBean mainBean = ac.getBean("MainBean", MainBean.class);
		
		System.out.println(mainBean.motdServiceBean.getMotd(3));
		
		ac.close();
	}
}
