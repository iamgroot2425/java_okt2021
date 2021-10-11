package de.lubowiecki.ocp.basics.vererbung;

// abstrakte Klassen können nicht final sein
public abstract class AbstractAnimal {
	
	private String name;

	// Abstrakte Klassen können konkrete und abstrakte Methoden enthalten
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// abstrakte Metghoden dürfen nicht final sein
	public abstract String getSound(); // Abstrakte Methode muss hier nicht komplett ausprogrammiert werden
	
	// Abstrakte Mehoden haben keinen Body und müssen in den Kindklassen zu ende programmiert werden
	public abstract void setSound(String sound);
	
	// Abstrakte Klassen können, aber müssen keine abstrakten Methoden entahlten
	// enthält eine Klasse eine abstrakte Methode, muss die Klasse auch abstrakt sein
	
	// Methoden in abstrakten Klassen dürfen private, package-private, protected oder public sein
	
}
