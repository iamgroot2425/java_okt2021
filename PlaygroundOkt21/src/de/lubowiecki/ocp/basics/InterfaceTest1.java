package de.lubowiecki.ocp.basics;

import java.util.TreeSet;

import de.lubowiecki.ocp.basics.things.Thing;

public class InterfaceTest1 {

	public static void main(String[] args) {
		
		// TreeSet ist eine IMMER sortierte Menge
		TreeSet<String> namen = new TreeSet<>();
		namen.add("Peter"); // Alle Strings sind Comparable mit anderen Strings
		namen.add("Bruce");
		namen.add("Steve");
		namen.add("Carol");
		namen.add("Natasha");
		
		// Alle Elemente des TreeSets müssen Sortierbar sein
		// Sortierbar bedeutet, sie müssen das Interface Comparable implementieren
		System.out.println(namen);
		
		System.out.println();

		TreeSet<Integer> zahlen = new TreeSet<>();
		zahlen.add(7); // Alle Integer sind Comparable mit anderen Integern
		zahlen.add(22);
		zahlen.add(1);
		zahlen.add(9);
		zahlen.add(18);
		
		System.out.println(zahlen);
		
		System.out.println();

		TreeSet<Thing> things = new TreeSet<>();
		// Thing Objekte sind nicht vergleichbar, weil die Klasse Thing das Interface Comparable nicht implementiert
		things.add(new Thing("Hammer", 0.5)); 
		things.add(new Thing("Zange", 0.25));
		things.add(new Thing("Tasse", 0.3));
		
		System.out.println(things);
		
		

	}

}
