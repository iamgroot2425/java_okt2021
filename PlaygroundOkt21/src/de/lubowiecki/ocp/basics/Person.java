package de.lubowiecki.ocp.basics;

public class Person {
	
	private String firstname;
	private String lastname;
	private String email;
	
//	public Person() {
//		super(); // optional
//	}
	
	public Person() {
	}
	
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@shield.org";
	}
	
	public Person(String firstname) {
		this.firstname = firstname;
		this.lastname = "Unbekannt";
	}
	
//	public Person(String lastname) {
//		this.firstname = "Unbekannt";
//		this.lastname = lastname;
//	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

}
