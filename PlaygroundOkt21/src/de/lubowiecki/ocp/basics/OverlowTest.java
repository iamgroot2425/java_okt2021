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
		//i++;
		//i = i + 1;
		System.out.println(i);
		
		String s = "Hallo String";
		
		LocalDate d = LocalDate.now();
		
		System.out.println(args[0]);
		System.out.println(args[2]);
		
	}
}