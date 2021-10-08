package de.lubowiecki.ocp.basics;

public class SwitchTest {
	
	public static void main(String[] args) {
		
		byte b = 100;
		
		switch(b) { // byte -128...127
			
			case 10: System.out.println("Klein");
			break;
			
			case 50: System.out.println("Mittel");
			break;
			
			case 100: System.out.println("Groß");
			break;
			
			// case 150: System.out.println("Sehr Groß"); // Error: ist zu groß für einen byte
		}
		
		final byte c1 = 10; // Kompiletime-Konstante
		
		final byte c2; // Runtime-Konstante
		c2 = 10;
		
		switch(b) {
		
			// als case können Kompiletime-Konstanten verwendet werden
			case c1: System.out.println("Klein");
			break;
			
			// Runtime-Konstanten dürfen NICHT verwendet werden
//			case c2: System.out.println("Mittel");
//			break;
			
			case 100: System.out.println("Groß");
			break;
			
			// case 150: System.out.println("Sehr Groß"); // Error: ist zu groß für einen byte
		}
		
		System.out.println();
		System.out.println("Wie lange noch bis zum Ende der Woche?");
		
		Wochentag t = Wochentag.DI;
		switch(t) {
			
			case MO: System.out.println("Montag");
			case DI: System.out.println("Dienstag");
			case MI: System.out.println("Mittwoch");
			case DO: System.out.println("Donnerstag");
			case FR: System.out.println("Freitag");
			case SA: System.out.println("Samstag");
			case SO: System.out.println("Sonntag");
		}
		
		
		switch(t) {
		
			case MO:
					int i = 10;
					System.out.println(i);
					{ // eigener Scope, Variablen werden gelöscht, sobald das Ende des Blocks erreicht wird
						int j = 10;
						System.out.println(j);
					}
				break;
				
			case DI: 
				//int i = 20; // Redeklaration nicht erlaubt, da i bereits vorhanden ist
				i = 20; // Redeklaration nicht erlaubt, da i bereits vorhanden ist
				System.out.println(i);
				break;
				
				
			case MI: {
					int j = 30;
					System.out.println(j);
				}
				break;
		}
		
		
		// Aufgabe
		
		int flavors = 30;
		
		int eaten = 0; // 1, 3, 2
		
		switch(flavors) {
			case 30: eaten++; // Java steigt im passenden case ein und läuft alles bis zum break oder ende von switch durch.
			case 40: eaten+=2;
			default: eaten--;
		}
		System.out.print(eaten);
	}
}

// Aufzählung von möglichen Optionen
enum Wochentag {
	MO, DI, MI, DO, FR, SA, SO;
}
