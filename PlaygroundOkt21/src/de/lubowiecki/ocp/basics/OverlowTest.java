package de.lubowiecki.ocp.basics;

import java.time.*;

// alle Klassen aus dem Paket java.lang sind automatisch importiert

/**
 * 
 * @author tlubowiecki
 *
 */
public class OverlowTest { 
	
	// OverlowTest - CamelCase 
	// overlow_test - SnakeCase, wird in Java nicht verwendet 
	// OVERFLOW_TEST - ScreamingSnakeCase, Konstanten 
	
	/**
	 * 
	 * @param args
	 */
	public void main(String... args) {
		
		byte i = 125;
		i++; // i = (byte)(i + 1)
		i++;
		i++; // Überlauf
		//i = i + 1; // Error: Addition führt zu Promotion auf int
		System.out.println(i);
		
		// Muss importiert werden, da es nicht in java.lang oder gleichen Paket liegt
		LocalDate d = LocalDate.now();
		
		// Zugriff auf Programmparameter
		System.out.println(args[0]);
		System.out.println(args[2]);
		
	}
}