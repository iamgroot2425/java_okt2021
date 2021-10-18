package de.lubowiecki.ocp.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorTest {
	
	public static void main(String[] args) {
		
		List<Integer> zahlen = Arrays.asList(2,4,6,8,10,1,3,5,7,9);
		
		Iterator<Integer> itr = zahlen.iterator();
		
		while(itr.hasNext()) { // Zeiger steht am Anfang vor dem ersten Element
			int zahl = itr.next(); // Versetzt den Zeiger auf das nächste Element
			System.out.println(zahl);
		}
		
		System.out.println();
		
		// ListIterator gibt es nur für Listen
		// Kann sich Vor- und Rückwärts bewegen
		// Kann einen Index abfragen
		
		ListIterator<Integer> itr2 = zahlen.listIterator();
		while(itr2.hasNext()) {
			int zahl = itr2.next();
			//int zahl = itr2.previous();
			System.out.println(zahl);
		}
		
		System.out.println();
		
		// Arrays.asList baut eine fixed-size Liste
		List<Character> buchstaben = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'E', 'T'));
		
		// Gleichzeitiges durchlaufen und Entfernen von Elementen führt zu ConcurrentModificationExceptioin
//		for (Character character : buchstaben) {
//			System.out.println(buchstaben.remove(character));
//		}
		
		Iterator<Character> itr3 = buchstaben.iterator();
		
		while(itr3.hasNext()) { // Zeiger steht am Anfang vor dem ersten Element
			char c = itr3.next(); // Versetzt den Zeiger auf das nächste Element
			itr3.remove(); // Entfernt das Element an aktueller Zeigerposition
			System.out.println(c);
		}
		
	}

}
