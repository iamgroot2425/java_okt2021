package de.lubowiecki.ocp.collections;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		
//		Set<Person> personen = new TreeSet<>(); // ist IMMER sortiert
//		
//		// Elemente müssen sortierbar sein (Comparable Interface implementieren)
//		
//		Person p1 = new Person("Peter", "Parker", LocalDate.of(1982, 10, 15));
//		Person p2 = new Person("Steve", "Rogers", LocalDate.of(1921, 5, 18));
//		Person p3 = new Person("Bruce", "Banner", LocalDate.of(1975, 2, 25));
//		
//		personen.add(p1);
//		personen.add(p2);
//		personen.add(p3);
//		
//		System.out.println(personen);
		
		//Set<String> namen = new TreeSet<>(); // Verwendet die compateTo der Strings
		
		// Verendet den Comparator, und ignoriert die compareTo der Strings
		Set<String> namen = new TreeSet<>(String.CASE_INSENSITIVE_ORDER); 
		namen.add("Steve");
		namen.add("Bruce");
		namen.add("tony");
		namen.add("carol");
		
		System.out.println(namen);
	}
}
