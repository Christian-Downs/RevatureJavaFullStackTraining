package com.example.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MotdServiceBean {
	protected List<String> motds= new ArrayList<String>();
	
	protected int defaultMotdIndex;
	
	// A method that returns the message of the day (MOTD)
	public String getMotd(int motdIndex) {
		if(motdIndex<0 || motdIndex>=motds.size()) {
			return motds.get(defaultMotdIndex);
		}
		
		return motds.get(motdIndex);
	}
	
	protected void initMotds() {
		motds.addAll(Arrays.asList("Good Morning","You always pass failure on your way to success", "it seems impossible until it's done"));
	}
	
	
	protected void setDefaultMotdIndex(int defaultMotdIndex) {
		this.defaultMotdIndex = defaultMotdIndex;
	}
}
