package de.lubowiecki.ocp.basics.vererbung;

public class LKW extends Fahrzeug {
	
	private int ladeFlaeche;

	public int getLadeFlaeche() {
		return ladeFlaeche;
	}

	public void setLadeFlaeche(int ladeFlaeche) {
		this.ladeFlaeche = ladeFlaeche;
	}
	
	@Override
	public void setPosition(int x, int y) {
		super.setPosition(x, y);
		System.out.println("Wir liefern die Waren ab bei " + getPosition());
	}
	
	@Override
	public String getKennzeichen() {
		// super ist eine Referenz auf ein Objekt der Klasse Fahrzeug
		return super.getKennzeichen() + "L"; // Führt getKennzeichen von Fahrzeug aus
	}
}
