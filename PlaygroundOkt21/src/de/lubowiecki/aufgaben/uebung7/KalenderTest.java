package de.lubowiecki.aufgaben.uebung7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class KalenderTest {

	private final Cal cal = new Cal();

	private final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		new KalenderTest().start();
	}

	private void start() {

		while(true) {
			controll();
		}
	}

	private void controll() {

		System.out.println("Eingabe [n/l/t/w/m/q]: ");
		switch (cleanString(scanner.next())) {
			
			case "n":
				if(cal.add(createTermin())) {
					System.out.println("Termin wurde gespeichert.");
				}
				else {
					System.out.println("Termin konnte nicht gespeichert werden.");
				}
				break;
				
			case "l":
				cal.showAll();
				break;
				
			case "t":
				// Von heute bis zum morgen
				cal.showAll(cal.findForDate(LocalDate.now()));
				break;
				
			case "w":
				// Von heute 7 Tage
				cal.showAll(cal.findForDate(LocalDate.now(), LocalDate.now().plusDays(7)));
				break;
				
			case "a":
				// nächster Termin
				cal.showTermin(cal.findNext());
				break;	
				
			case "m":
				// Von heute bis zum ersten Tag des nächsten Monats
				cal.showAll(cal.findForDate(LocalDate.now(), LocalDate.now().plusMonths(1).withDayOfMonth(1)));
				break;	
				
			case "q":
				System.out.println("Programmende...");
				System.exit(0);
				break;
				
			default:
				System.out.println("Falsche Eingabe.");
		}
	}
	
	private Termin createTermin() {
		
		Termin t = new Termin();
		
		System.out.print("Datum: ");
		LocalDate td = LocalDate.parse(scanner.next(), Cal.DATE_FORMATTER); // LocalDate.parse wandelt String in LocalDate
		
		System.out.print("Uhrzeit: ");
		LocalTime lt = LocalTime.parse(scanner.next(), Cal.TIME_FORMATTER); // LocalTime.parse wandelt String in LocalTime
		
		t.setDate(LocalDateTime.of(td, lt));
		
		scanner.nextLine(); // FIX
		
		System.out.print("Titel: ");
		t.setTitle(scanner.nextLine());
		
		System.out.print("Beschreibung: ");
		t.setDescription(scanner.nextLine());
		
		return t;
	}

	private String cleanString(String str) {
		return str.trim().toLowerCase();
	}
}
