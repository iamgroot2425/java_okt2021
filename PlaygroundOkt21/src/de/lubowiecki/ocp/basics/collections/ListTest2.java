package de.lubowiecki.ocp.basics.collections;

import java.util.ArrayList;
import java.util.List;

import de.lubowiecki.ocp.basics.things.Thing;

public class ListTest2 {

	public static void main(String[] args) {
		
		List<Thing> zeug = new ArrayList<>();
		
		Thing t = new Thing("Hammer", 0.5);
		zeug.add(t);
		
		zeug.add(new Thing("Zeug", 0.5));
		
		// toString von List ruft toString für jedes enthaltene Element auf
		System.out.println(zeug);
		
	}
	
	
}
