package de.lubowiecki.aufgaben.uebung4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class ProductManagement {
	
	private final Scanner scanner = new Scanner(System.in);
	
	private final List<Product> products = new ArrayList<>();
	
	private static final String KEYS =  "\n---------------------------------------\n"
										+ "	n : neues Produkt \n"
										+ "	l : Produkte anzeigen \n"
										+ "	q : Programm verlassen \n"
										+ "---------------------------------------\n";
	
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
	
	// TODO: Prüfen, warum nach der Eingabe des Namens noch mal auf Eigabe gewartet wird
	
	
	public static void main(String[] args) {
		new ProductManagement().init();
	}

	// Startet die Anwendung
	private void init() {
		
		while(true) {
			System.out.println(KEYS);
			if(!controll(scanner.next())) {
				break;
			}
		}
		
		System.out.println("Programm wird beendet");
	}
	
	// Usereigabe wird analysiert
	private boolean controll(String input) {
		
		switch(input.trim().toLowerCase()) {
			
			case "n":
				if(createProduct()) {
					System.out.println("Produkt wurde gespeichert.");
				}
				break;
				
			case "l":
				showProducts();
				break;
			
			case "q":
				return false;
				
			default:
				System.out.println("Eingabe ungültig");
		}
		
		return true;
	}

	// Produkterzeugung
	private boolean createProduct() {
		
		try {
			
			System.out.print("Ist es verderblich? [j/n]:");
			boolean verderblich = scanner.next().trim().toLowerCase().equals("j"); 
			
			Product p = null;
			
			if(verderblich) {
				p = new PerishableProduct();
			}
			else {
				p = new Product();
			}
			
			scanner.nextLine(); // FIX
			System.out.print("Produktname: ");
			p.setName(scanner.nextLine()); 
			
			while(!inputWeight(p)) {
				System.out.println("Falsche Eingabe!");
			}
			
			while(!inputCount(p)) {
				System.out.println("Falsche Eingabe!");
			}
			
			while(!inputPrice(p)) {
				System.out.println("Falsche Eingabe!");
			}
			
			if(verderblich) {
				// p ist ein PerishableProduct auf dem Heap aber die Referenz ist ein normales Produkt
				// um an die setExpiryDate zu kommen, muss man die Referenz auf PerishableProduct casten
				while(!inputExpiryDate((PerishableProduct) p)) {
					System.out.println("Falsche Eingabe!");
				}
			}
			
			scanner.nextLine(); // FIX
			
			return products.add(p);
		}
		catch(RuntimeException e) {
			System.out.println("Produkt konnte nicht erzeugt werden, da die Eingaben ungültig sind.");
			return false;
		}
	}
	
	private boolean inputCount(Product p) {
		
		scanner.nextLine(); // FIX
		
		System.out.print("Menge: ");
		try {
			int zahl = scanner.nextInt();
			if(zahl > 0) {
				p.setCount(zahl);
				return true;
			}
			return false;
		}
		catch(RuntimeException e) {
			return false;
		}
	}
	
	private boolean inputPrice(Product p) {
		
		scanner.nextLine(); // FIX
		
		System.out.print("Preis: ");
		try {
			double zahl = scanner.nextDouble();
			if(zahl > 0) {
				p.setPrice(zahl);
				return true;
			}
			return false;
		}
		catch(RuntimeException e) {
			return false;
		}
	}
	
	private boolean inputExpiryDate(PerishableProduct p) {
		
		scanner.nextLine(); // FIX
		
		System.out.print("Datum [TT.MM.JJ]: ");
		try {
			String datum = scanner.next();
			LocalDate expiryDate = LocalDate.parse(datum, FORMATTER);
			p.setExpiryDate(expiryDate);
			return true;
		}
		catch(RuntimeException e) {
			return false;
		}
	}
	
	private boolean inputWeight(Product p) {
		
		scanner.nextLine(); // FIX
		
		System.out.print("Gewicht: ");
		try {
			double zahl = scanner.nextDouble();
			if(zahl > 0) {
				p.setWeight(zahl);
				return true;
			}
			return false;
		}
		catch(RuntimeException e) {
			return false;
		}
	}

	// Produktanzeige
	private void showProducts() {
		System.out.println("Produktliste: ");
		for (Product product : products) {
			System.out.println(product);
		}
	}
}
