package de.lubowiecki.aufgaben.uebung4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveProductTest {
	
	public static void main(String[] args) {
		
	
		// IO, NIO, NIO2
		
		List<Product> products = new ArrayList<>();
		products.add(new Product("Apfel", 0.25, 100, 0.50));
		products.add(new Product("Kiwi", 0.1, 1000, 0.69));
		
		
		try {
			// Gibt Daten in eine Datei aus
			FileOutputStream fos = new FileOutputStream("data.txt");
			
//			Schreibt einen String in die Datei
//			String data = "Das ist ein Haus von Nikigraus!";
//			fos.write(data.getBytes()); // getBytes wandelt ein String in ein Array von Bytes
			
			ObjectOutputStream oos = new ObjectOutputStream(fos); // Bekommt den FileOutputStream als Basis
			oos.writeObject(products); // Schreibt Objekt in eine Datei
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("Datei wurde nicht gefunden!");
		}
		catch (IOException e) {
			System.out.println("Daten konnten nicht geschrieben werden!");
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
