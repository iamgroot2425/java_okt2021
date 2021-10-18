package de.lubowiecki.ocp.collections;

import java.time.LocalDate;
import java.util.Comparator;

public class Person implements Comparable<Person> {
	
	// Klasse ist versteckt, da private, aber über die Konstante wird eine Instanz sichtbar gemacht
	public static final LastNameComparator LASTNAME_COMPARATOR = new LastNameComparator();
	
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	
	
	public Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Person(String firstName, String lastName, LocalDate birthDate) {
		this(firstName, lastName);
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Person o) { // beschreibt die natürliche Reihenfolge
		return birthDate.compareTo(o.birthDate); // Vergleicht Geburtsdatum
	}
	
	
	private static class LastNameComparator implements Comparator<Person> {

		@Override
		public int compare(Person p1, Person p2) {
			// Beschreibt, wie zwei Personen nach Nachnamen verglichen werden
			return p1.getLastName().compareTo(p2.getLastName());
		}
	}	
}
