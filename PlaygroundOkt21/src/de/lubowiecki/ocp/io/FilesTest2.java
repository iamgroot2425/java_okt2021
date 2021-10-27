package de.lubowiecki.ocp.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

public class FilesTest2 {

	public static void main(String[] args) {
		
		Path p1 = Paths.get("./"); // aktueller Ordner
		System.out.println(p1.toAbsolutePath());
		// System.out.println(p1.toString());
		
		try {
			// Läuft durch alle Unterordner und Dateien
			Files.walk(p1, 6) // Stream von Path-Objekten
				.filter(p -> p.toString().endsWith(".java"))
				.filter(p -> p.getFileName().toString().startsWith("Array"))
				.forEach(p -> System.out.println(p)); // p ist ein Path-Objekt
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------------");
		
		long dateFilter = System.currentTimeMillis() - (1000 * 60 * 60 * 24);
		
		try {
			// Suche von Dateien mit der Endung .java, die innerhalb der letzten 24 Std bearbeitet wurden
			BiPredicate<Path, BasicFileAttributes> pred = (p, a) -> { 
				return p.toString().endsWith(".java") && a.lastModifiedTime().toMillis() > dateFilter;
			};
			
			// Sucht nach Übereinstimmung mit einem BiPredicate
			Files.find(p1, Integer.MAX_VALUE, pred)
				.forEach(p -> System.out.println(p));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------------");
		
		try {
			// Consumer<Path>
			// void	accept(Path t)
			// p -> System.out.println(p)
			// Bedeutet:
//				void ohneNamen(Path p) {
//					System.out.println(p);
//				}
			
			// void	println(Object t)
			
			
			// Liefert den Inhalt des Ordners - nur eine Ebene
			Files.list(p1)
				//.forEach(x -> System.out.println(x)); // Lambda
				.forEach(System.out::println); // Methodenreferenz
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------------");
		
		p1 = Paths.get("test.txt");
		
		try {
			// Liest den Inhalt einer Datei - Liefert einen Stream von Zeilen
			Files.lines(p1)
				.filter(line -> line.contains("was"))
				.forEach(line -> System.out.println(line.toUpperCase()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
