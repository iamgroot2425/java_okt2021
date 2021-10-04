package de.lubowiecki.ocp.taschenrechner;

public class NextRechner {
	
	private String protokoll = "";
	
	public double add(double a, double b) {
		double erg = a + b;
		protokoll += "\n" + a + " + " + b + " = " + erg; // Veränderung des Objekt-Zustandes
		return erg;
	}
	
	@Override
	public String toString() {
		return protokoll;
	}
}