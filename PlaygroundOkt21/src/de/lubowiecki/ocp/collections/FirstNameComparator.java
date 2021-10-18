package de.lubowiecki.ocp.collections;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		// Beschreibt, wie zwei Personen nach Vornamen verglichen werden
		return p1.getFirstName().compareTo(p2.getFirstName());
	}
}
