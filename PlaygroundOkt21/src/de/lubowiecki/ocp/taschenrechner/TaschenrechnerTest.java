package de.lubowiecki.ocp.taschenrechner;

import java.util.Scanner;

public class TaschenrechnerTest {
	
	// Klassen und Instanzvariablen werden mit Standardwerten initialisiert
	
	// Scannt eine Quelle nach Eingaben
	// System.in - in ist eine statische Eigenschaft in der Klasse System
	// Enthält einen Verweis auf die Eingaben in die Konsole
	public static final Scanner SCANNER = new Scanner(System.in);
	
	public static final NextRechner RECHNER = new NextRechner();
	
	public static void main(String[] args) {
		
		String input; // Lokale Variablen werden nicht automatisch mit Standardwerten initialisiert
		
		while(true) {
			// Anweisungen werden endlos ausgeführt
			
			System.out.print("\nOperation: ");
			input = SCANNER.nextLine().trim(); // Liest eine Zeile von der Konsole als String ein
			// trim entfernt nicht benötige Leerzeichen und Tabs
			
			// equals vergleicht den Inhalt von input
			if(input.equalsIgnoreCase("exit")) {
				break; // bricht die Schleife ab
			}
			else if(input.equalsIgnoreCase("protokoll")) {
				System.out.println(RECHNER);
			}
			else {
				
				System.out.print("\nA: ");
				double a = SCANNER.nextDouble(); // List die Eingabe ein und konvertiert sie in einen double
				System.out.print("\nB: ");
				double b = SCANNER.nextDouble();
				
				double erg = RECHNER.add(a, b);
				System.out.println("Summe: " + erg);
				
				SCANNER.nextLine(); // Fix - Behebt ein Problem zwische Einlesen von Einzelwerten und ganzen Zeilen
			}
		}
		
		System.out.println("Ende des Programms");
		SCANNER.close();
		
	}

}
