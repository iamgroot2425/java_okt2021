package de.lubowiecki.ocp.basics.vererbung;

public class Sportflugzeug implements FlugObjekt {

	@Override
	public void starten() {
		towerKontaktieren();
		System.out.println("Motor an");
		System.out.println("Abheben");
		towerKontaktieren();
		
	}

	@Override
	public void landen() {
		towerKontaktieren();
		System.out.println("Auf der Landbahn aufsetzen");
		System.out.println("Motor aus");
		towerKontaktieren();
		
	}

	@Override
	public void towerKontaktieren() {
		System.out.println(getClass().getSimpleName() + " spricht mit dem Tower...");
	}

}
