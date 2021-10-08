package de.lubowiecki.ocp.basics.collections;

import java.util.ArrayList;
import java.util.List;

import de.lubowiecki.ocp.basics.things.Thing;

public class ListTest2 {

	public static void main(String[] args) {
		
		// links: Referenztyp - kann eine Klasse, abstrakte Klasse, Enum oder ein Interface sein
		// rechts: Objekttyp - muss immer eine konkrete Klasse sein
		List<Thing> zeug = new ArrayList<>();
		
		Thing t = new Thing("Hammer", 0.5);
		zeug.add(t);
		
		zeug.add(new Thing("Zeug", 0.5));
		
		// toString von List ruft toString für jedes enthaltene Element auf
		System.out.println(zeug);
		
		
		List<Thing> zeug2 = new ArrayList<>();
		zeug2.add(new Thing("Zange", 0.5));
		zeug2.addAll(zeug);
		
		System.out.println(zeug2);
		
		List<Thing> zeug3 = new ArrayList<>(zeug);
		zeug3.get(0).setName("Becher");
		
		System.out.println(zeug);
		System.out.println(zeug2);
		System.out.println(zeug3);
	}
	
	
}
