package de.lubowiecki.ocp.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest2 {

	public static void main(String[] args) {
		
		//Set<Person> personen = new HashSet<>(); // Ist weder sortiert noch geordnet
		Set<Person> personen = new LinkedHashSet<>(); // Behält die Einfügereihenfolge bei
		
		Person p1 = new Person("Peter", "Parker");
		Person p2 = new Person("Peter", "Parker");
		Person p3 = new Person("Bruce", "Banner");
		Person p4 = new Person("Steve", "Rogers");
		
		personen.add(p1);
		personen.add(p4);
		personen.add(p2);
		personen.add(p3);
		// Ist ein Objekt mit dem gleichen HashCode schon drin?
		// Wenn ja, wird als nächstes equals aufgerufen
		
		System.out.println(personen);

	}
}

