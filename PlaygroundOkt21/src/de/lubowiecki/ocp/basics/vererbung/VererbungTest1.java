package de.lubowiecki.ocp.basics.vererbung;

import java.awt.Point;
import java.util.ArrayList;

public class VererbungTest1 {
	
	private final static ArrayList<Fahrzeug> parkhaus = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// Eigenschaften und Methoden der Kind-Klassen sind über die Referenz der Elternklasse NICHT sichtbar
		Fahrzeug f = new Fahrzeug(); // Fahrzeug ist eine konkrete Klasse und kann instanziert werden
		f.setKennzeichen("HH-AB123");
		f.setPosition(10,25);
		System.out.println(f);
		
		System.out.println();
		
		PKW p = new PKW();
		p.setKennzeichen("AB-CD123"); // Verfügt automatisch über alle nicht privaten Methoden der Elternklasse
		p.setPosition(new Point(15, 7));
		p.setAnzahlInsassen(4);
		System.out.println(p);
		
		System.out.println();
		
		// PKW IS-A Fahrzeug
		Fahrzeug f2 = new PKW();
		System.out.println(f2);
		
		f2 = new LKW(); // LKW IS-A Fahrzeug
		System.out.println(f2);
		
		System.out.println();
		
		// ArrayList erlaubt jetzt Fahrzeug-Objekte oder objekte von Fahrzeug-Kind-Klassen
		ArrayList<Fahrzeug> fahrzeuge = new ArrayList<>();
		fahrzeuge.add(p);
		fahrzeuge.add(new LKW());
		fahrzeuge.add(new LKW());
		fahrzeuge.add(new PKW());
		
		for (Fahrzeug fahrzeug : fahrzeuge) {
			fahrzeug.setPosition(10, 10); // Hier wird die konkrete Methode des Objektes auf dem Heap verwendet
		}
		
		for (Fahrzeug fr : fahrzeuge) { // Aus der ArrayList bekommt man alle Objkte als Fahrzeug-Referenzen
			
			// Über eine Fahrzeug-Referenz kann man alle Eigenschaften und Methoden benutzen, die in Fahrzeug definiert sind
			System.out.println(fr.getKennzeichen() + ", " + fr.getPosition());
			// anzahlInsassen und ladeFlaeche sind hier NICHT sichtbar
		}
		
		System.out.println();
		
		parkeFahrzeug(p);
		
	}
	
	public static boolean parkeFahrzeug(Fahrzeug f) {
		System.out.println("Fahrzeug wird geparkt...");
		return parkhaus.add(f);
	}
	

}
