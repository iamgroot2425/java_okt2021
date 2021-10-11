package de.lubowiecki.ocp.basics.vererbung;

public class PKW extends Fahrzeug {

	private int anzahlInsassen;
	
	// Konstruktoren werden NICHT vererbt

	public int getAnzahlInsassen() {
		return anzahlInsassen;
	}

	public void setAnzahlInsassen(int anzahlInsassen) {
		this.anzahlInsassen = anzahlInsassen;
	}
	
	@Override
	public void setPosition(int x, int y) {
		super.setPosition(x, y);
		System.out.println("Wir machen einen Ausflug zu " + getPosition());
	}
	
}
