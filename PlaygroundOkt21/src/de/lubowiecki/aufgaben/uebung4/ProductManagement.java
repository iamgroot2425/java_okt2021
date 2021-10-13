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
		
		scanner.nextLine(); // FIX
		
		System.out.print("Produktname: ");
		String name = scanner.nextLine(); 
		
		System.out.print("Gewicht: ");
		double gewicht = scanner.nextDouble();
		
		System.out.print("Menge: ");
		int menge = scanner.nextInt();
		
		System.out.print("Preis: ");
		double preis = scanner.nextDouble();
		
		System.out.print("Ist es verderblich? [j/n]:");
		
		boolean verderblich = scanner.next().trim().toLowerCase().equals("j"); 
		
		if(verderblich) {
			System.out.print("Datum [TT.MM.JJ]: ");
			String datum = scanner.next();
			LocalDate expiryDate = LocalDate.parse(datum, FORMATTER);
			
//			System.out.print("Tag: ");
//			int tag = scanner.nextInt();
//			System.out.print("Monat: ");
//			int monat = scanner.nextInt();
//			System.out.print("Jahr: ");
//			int jahr = scanner.nextInt();
//			LocalDate expirDate = LocalDate.of(jahr, monat, tag);
			
			return products.add(new PerishableProduct(name, gewicht, menge, preis, expiryDate));
		}
		else {
			return products.add(new Product(name, gewicht, menge, preis));
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
