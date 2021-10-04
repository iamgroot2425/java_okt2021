package de.lubowiecki.ocp.basics;

public class ReplikantenFabrik {
	
	private ReplikantenFabrik() {
	}
	
	// Fabrikmethode
	public static Person get() {
		return new Person("Unbekannt", "Unbekannt");
	}

}
