package de.lubowiecki.ocp.basics.things;

// jede Klasse erbt in Java automatisch von der Klasse Object...
public class Thing {
	
	// alle Objekte von Thing nutzen die gleiche count Variable
	private static int count = 0;
	
	private int id;
	
	private String name;
	
	private double weight;
	
	private static int refNr = 1;
	
	
	public Thing(String name, double weight) {
		id = ++count;
		this.name = name;
		this.weight = weight;
	}
	
	
	
	// ...und bekommt automatisch eine Reihe von Methoden
	// toString - Konvertiert das Objekt in ein String
	// hashCode - Liefert eine Identifikationszahl
	// equals - Vergleicht den Inhalt der Objekte
	// clone - Kopiert ein Objekt
	// getClass - Liefert ein Reflection-Objekt
	// wait, notify, notifyAll - Werden für Threads verwendet
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public static int getRefNr() {
		return refNr;
	}

	public static void setRefNr(int refNr) {
		Thing.refNr = refNr;
	}

	@Override
	public String toString() {
		return name + ", " + weight + ", " + hashCode() + ", " + refNr + ", id: " + id + ", count: " + count;
	}
}
