package de.lubowiecki.ocp.basics.vererbung;

public class JumboJet implements FlugObjekt {

	// implementiert eine Klasse ein interface, dann MÜSSEN alle
	// abstrakten Methoden eingebaut werden
	
	@Override
	public void starten() {
		towerKontaktieren();
		System.out.println("Motor an");
		System.out.println("Landebahn befahren");
		System.out.println("Ordentlich beschleunigen");
		System.out.println("Abheben");
		towerKontaktieren();
	}

	@Override
	public void landen() {
		towerKontaktieren();
		System.out.println("Landebahn anfliegen");
		System.out.println("Geschwindigkeit reduzieren");
		System.out.println("Landen");
		towerKontaktieren();
		
	}

	@Override
	public void towerKontaktieren() {
		System.out.println(getClass().getSimpleName() + " spricht mit dem Tower...");
		
	}
}
