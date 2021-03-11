package com.revature.models;

import java.util.List;

import javax.persistence.*;

/*
 * JPA (java Persistance API) This is the specification and hibernate is the implementation
 */

@Entity
@Table(name="super_villain")
public class SuperVillain {
	
	@Id
	@Column(name="supervillainid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int superVillainId;
	
	@Column(name="name", unique = true, nullable=false)
	private String name;
	
	@Column(name="superpower")
	private String superPower;
	
	@Column(name="bounty")
	private double bounty;
	
	//masny to many relationsahhhip
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//	@Column(name="crimes")
	private List<Crime> crimes;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Prison_FK")
	private SuperPrison superPrisonHolder;

	public SuperVillain() {
		super();
	}

	public SuperVillain(String name, String superPower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.name = name;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}

	public SuperVillain(int superVillainId, String name, String superPower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.superVillainId = superVillainId;
		this.name = name;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}

	@Override
	public String toString() {
		return "SuperVillain [superVillainId=" + superVillainId + ", name=" + name + ", superPower=" + superPower
				+ ", bounty=" + bounty + ", crimes=" + crimes + ", superPrisonHolder=" + superPrisonHolder + "]";
	}

	public int getSuperVillainId() {
		return superVillainId;
	}

	public void setSuperVillainId(int superVillainId) {
		this.superVillainId = superVillainId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}

	public double getBounty() {
		return bounty;
	}

	public void setBounty(double bounty) {
		this.bounty = bounty;
	}

	public List<Crime> getCrimes() {
		return crimes;
	}

	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}

	public SuperPrison getSuperPrisonHolder() {
		return superPrisonHolder;
	}

	public void setSuperPrisonHolder(SuperPrison superPrisonHolder) {
		this.superPrisonHolder = superPrisonHolder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bounty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((crimes == null) ? 0 : crimes.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((superPower == null) ? 0 : superPower.hashCode());
		result = prime * result + ((superPrisonHolder == null) ? 0 : superPrisonHolder.hashCode());
		result = prime * result + superVillainId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperVillain other = (SuperVillain) obj;
		if (Double.doubleToLongBits(bounty) != Double.doubleToLongBits(other.bounty))
			return false;
		if (crimes == null) {
			if (other.crimes != null)
				return false;
		} else if (!crimes.equals(other.crimes))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (superPower == null) {
			if (other.superPower != null)
				return false;
		} else if (!superPower.equals(other.superPower))
			return false;
		if (superPrisonHolder == null) {
			if (other.superPrisonHolder != null)
				return false;
		} else if (!superPrisonHolder.equals(other.superPrisonHolder))
			return false;
		if (superVillainId != other.superVillainId)
			return false;
		return true;
	}
	
	
	
	

}
