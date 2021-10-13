package de.lubowiecki.ocp.basics.exceptions;

public class ZuKleinException extends RuntimeException {
	
	public ZuKleinException() {
		super("Der Wert ist zu klein"); // Konstruktor mit einer Meldung von RuntimeException
	}

}
