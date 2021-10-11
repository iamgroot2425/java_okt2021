package de.lubowiecki.ocp.basics.vererbung;

public class Dog extends AbstractAnimal {
	
	private String sound = "wau wau"; 
	
	// AbstractAnimal zwingt uns dazu die abstrakten Methoden einzubauen!
	// Die abstrakte Klasse sagt WAS eingebaut werden muss aber nicht WIE
	
	public String getSound() {
		return sound.toUpperCase().concat("!!!!");
	}

	public void setSound(String sound) {
		this.sound = sound;
	}
}
