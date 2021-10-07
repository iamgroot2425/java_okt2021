package de.lubowiecki.ocp.basics.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
	
	public static void main(String[] args) {
		
		// Legacy-Variante, Alles wird hinzugefügt wird, wird als Objekt gespeichert
		// Sollte möglichst nicht mehr verwendet werden
		ArrayList list1 = new ArrayList(); // Nimmt alles entgegen
		list1.add(1); // primitive Datentypen werden immer in ihre Wrapper geboxt
		list1.add("Moin");
		list1.add(new Object());
		
		for(Object object : list1) {
			System.out.println(object); // Speziellöe Informationen des Objektes sind nicht sichtbar
			//System.out.println(((Number) object).floatValue()); // führt für alles ausßer Integer zu ClassCastException
		}
		
		byte b = 10;
		Number i = b; // Autoboxing von byte zu Byte und dann widening. Byte kann nicht auf Integer gewidet werden
		
		
		// in <> kommt immer ein Objekttyp/komplexer Typ
		ArrayList<String> list2 = new ArrayList<String>();
		
		ArrayList<String> list3 = new ArrayList<>();
		
		list2.add("Hi"); // Wert muss zum generischen Typ passen
		String s = list2.get(0); // Liefert einen Wert vom generischen Typ
		
		System.out.println(list2.size()); // liefert die Anzahl enthaltener elemente
		// das interne Array hat eine default Kapazität von 10
		// Vergößern: alte Kapazität * 3 / 2
		
		// Wenn viele Elemente hinzugefügt werden müssen ist es besser
		// eine ArrayList mit einer hoher Kapazität zu erzeugen als mehrmals zu vergrößern
		list3 = new ArrayList<>(100); // Eine ArrayList mit initial Kapazität von 100, kann späeter vergrößert werden
		
		System.out.println();
		
		// Liefert eine fix-size Liste mit Inhalt
		List<Integer> ints = Arrays.asList(1,2,3,7,9,11,22,17,8);
		
		// Erzeugt eine ArrayList mit dem Inhalt der fix-size List. Die ArrayList ist veränderbar
		ArrayList<Integer> aInts = new ArrayList(Arrays.asList(1,2,3,7,9,11,22,17,8));

		System.out.println();
		
		for (int j = 0; j < aInts.size(); j++) {
			System.out.println(aInts.get(j)); // möglich aber nicht besonders performant
		}
		
		System.out.println();
		
		for (Integer in : aInts) {
			System.out.println(in); // besser
		}
		System.out.println();
		
		aInts.forEach(in -> System.out.println(in)); // Lambda
		
System.out.println();
		
		aInts.forEach(System.out::println); // Methoden-Referenz
		
	}

}
