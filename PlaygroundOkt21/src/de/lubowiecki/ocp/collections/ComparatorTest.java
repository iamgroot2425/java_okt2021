package de.lubowiecki.ocp.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {
	
	public static void main(String[] args) {
		
		List<Person> personen = new ArrayList<>();
		
		personen.add(new Person("Peter", "Parker", LocalDate.of(1982, 2, 18)));
		personen.add(new Person("Steve", "Rogers", LocalDate.of(1921, 10, 2)));
		personen.add(new Person("Bruce", "Banner", LocalDate.of(1976, 5, 10)));
		personen.add(new Person("Thor", "Thorkowski", LocalDate.of(-500, 1, 16)));
		personen.add(new Person("Natasha", "Romanov", LocalDate.of(1979, 9, 12)));
		
		System.out.println(personen);
		
		Collections.sort(personen); // Sortiert nach der natürlichen Reihenfolge (Comparable)
		
		System.out.println(personen);
		
		Collections.sort(personen, new FirstNameComparator()); // Sortiert nach der dem Comparator
		
		System.out.println(personen);
		
		// Verwendet den vorbereiteten Comparator
		Collections.sort(personen, Person.LASTNAME_COMPARATOR);
		
		System.out.println(personen);
		
		
		// Verwendet den Comparators als Lambda
		Collections.sort(personen, (a, b) -> a.getFirstName().compareTo(b.getFirstName()));
		
		System.out.println(personen);
	}
}
