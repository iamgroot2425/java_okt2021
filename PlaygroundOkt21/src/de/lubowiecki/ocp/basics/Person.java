package de.lubowiecki.ocp.basics;

public class Person {
	
	private String firstname = "Unbekannt";
	private String lastname = "Unbekannt";
	private String email;
	
//	public Person() {
//		super(); // optional
//	}
	
	public Person() {
		setEmail();
	}
	
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		setEmail();
	}
	
	public Person(String firstname) {
		this.firstname = firstname;
		setEmail();
	}
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setFirstname(String firstname) {
		
		if(firstname != null) {
			this.firstname = firstname;
			setEmail();
		}
	}

	public void setLastname(String lastname) {
		
		if(firstname != null) {
			this.lastname = lastname;
			setEmail();
		}
	}

	private void setEmail() {
		email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@shield.org";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
		
		Person other = (Person) obj;
		
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
}
