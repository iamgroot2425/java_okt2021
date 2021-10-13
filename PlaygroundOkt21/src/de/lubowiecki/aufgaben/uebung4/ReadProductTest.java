package de.lubowiecki.aufgaben.uebung4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadProductTest {

	public static void main(String[] args) {
		
		List<Product> products = null;
		
		try {
			FileInputStream fis = new FileInputStream("data.txt");
			
//			liest String aus einer Datei
//			String inhalt = new String(fos.readAllBytes());
//			System.out.println(inhalt);
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			products = (List<Product>) ois.readObject();
			
			for (Product product : products) {
				System.out.println(product);
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden.");
		} 
		catch (IOException e) {
			System.out.println("Daten konnten nicht gelesen werden.");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Klasse für die gespeicherten Daten NICHT gefunden");
		}

	}

}
