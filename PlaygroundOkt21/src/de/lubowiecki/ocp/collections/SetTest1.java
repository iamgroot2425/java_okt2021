package de.lubowiecki.ocp.collections;

import java.util.HashSet;
import java.util.Set;

public class SetTest1 {

	public static void main(String[] args) {
		
		Set<String> namen = new HashSet<>();
		namen.add("Bruce");
		namen.add("Peter");
		namen.add("Carol");
		namen.add("Steve");
		namen.add("Bruce"); // Duplikat wird nicht eingefügt
		
		// HashSet ist Reihenfolge nicht vorhersehbar
		System.out.println(namen);
		
		// Suche in einem HashSet ist sehr schnell!!!!
		System.out.println(namen.contains("Peter"));
		
		// Bietet keine Möglichkeit für einen Wahlfreien-Zugriff, Sets bieten keinen Index

		for (String str : namen) {
			System.out.println(str);
		}
		
		namen.remove("Steve");
	}
}
