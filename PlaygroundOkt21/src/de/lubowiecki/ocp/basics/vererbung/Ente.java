package de.lubowiecki.ocp.basics.vererbung;

public class Ente implements FlugObjekt {

	@Override
	public void starten() {
		towerKontaktieren();
		System.out.println("Anlauf nehmen");
		System.out.println("Abheben");
		towerKontaktieren();
		
	}

	@Override
	public void landen() {
		towerKontaktieren();
		System.out.println("Aufsetzen");
		towerKontaktieren();
		
	}

	@Override
	public void towerKontaktieren() {
		System.out.println(getClass().getSimpleName() + " Quak Quak Quak...");
		
	}

}
