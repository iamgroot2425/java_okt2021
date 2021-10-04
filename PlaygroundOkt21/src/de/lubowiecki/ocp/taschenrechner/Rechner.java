package de.lubowiecki.ocp.taschenrechner;

public class Rechner {
	
	// Zustand eines Objektes wird durch seine Instanzeigenschaften beschrieben
	// Klassen ohne Instanzeigenschaften produzieren Objekte ohne Zustand
	
	// verbietet die Objekterzeugung
	private Rechner() {
	}
	
	
	public static double add(double a, double b) {
		return a + b;
	}
}
