package com.revature.model;

// POJO = plain old java object
// model = a class which makes a blueprint for an object in order to hold data

public class SuperVillain {
	private String name;
	private String superpower;
	private int bounty;
	
	
	public SuperVillain() {
		
	}
	
	public SuperVillain(String name, String superpower, int bounty) {
		super();
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuperpower() {
		return superpower;
	}
	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}
	public int getBounty() {
		return bounty;
	}
	public void setBounty(int bounty) {
		this.bounty = bounty;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SuperVillian " + name + " has the power of " +  superpower + " and a bounty of " + bounty;
	}
		
	


}