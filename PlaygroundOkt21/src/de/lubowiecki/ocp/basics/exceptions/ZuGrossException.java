package de.lubowiecki.ocp.basics.exceptions;

public class ZuGrossException extends RuntimeException {
	
	public ZuGrossException() {
		super("Der Wert ist zu gross");
	}
	
}
