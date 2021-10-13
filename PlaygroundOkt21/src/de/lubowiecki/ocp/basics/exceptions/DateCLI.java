package de.lubowiecki.ocp.basics.exceptions;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

// CLI = Command Line Interface
public class DateCLI {
	
	private final Scanner scanner = new Scanner(System.in);

	private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
	
	public static void main(String[] args) {
		new DateCLI().start();
	}

	private void start() {
		
		LocalDate date = null;
		
		while(true) {
			try {
				System.out.print("Tag: ");
				int tag = scanner.nextInt();
				
				System.out.print("Monat: ");
				int monat = scanner.nextInt();
				
				System.out.print("Jahr: ");
				int jahr = scanner.nextInt();
				
				date = LocalDate.of(jahr, monat, tag);
				break; // wird nur erreicht, wenn in der Zeile davor keine Exception entsteht
			}
			catch(DateTimeException e) {
				System.out.println("Datumsangabe ist ungültig!");
			}
		}
		
		System.out.println();
		System.out.println(date.format(FORMATTER)); // Verwendet für die Ausgabe den FORMATTER 
		System.out.println();
		
		scanner.close();
	}
}
