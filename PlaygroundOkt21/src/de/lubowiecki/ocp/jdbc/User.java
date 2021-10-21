package de.lubowiecki.ocp.jdbc;

import de.lubowiecki.orm.AbstractEntity;

public class User extends AbstractEntity {
	
	private String firstname;
	
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
