package de.lubowiecki.ocp.basics.things;

import java.util.ArrayList;
import java.util.List;

public class ThingManagement {

	public static void main(String[] args) {
		
		List<Thing> things = new  ArrayList<>();
		
		Thing t1 = new Thing("Hammer", 1.5);
		things.add(t1);
		
		things.add(new Thing("Zange", 0.5));
		
		things.add(new Thing("Tasse", 0.25));
		
		things.add(new Thing("Tasse", 0.25));
		
		t1.setName("Stuhl");
		t1.setWeight(2.5);
		//t1.setRefNr(5);
		Thing.setRefNr(18);
		
		for (Thing thing : things) {
			// Wenn ein Objekt per print oder println ausgegeben wird,
			// dann wird es automatisch das Objekt mit der toString Methode 
			// in einen String konvertiert
			System.out.println(thing);
		}
		
		System.out.println();
		
//		String s1 = new String("Hi");
//		String s2 = "Hi";
//		
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
		

	}

}
