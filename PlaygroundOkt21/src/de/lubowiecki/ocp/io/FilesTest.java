package de.lubowiecki.ocp.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

// NIO
public class FilesTest {

	public static void main(String[] args) {
		
		Properties props = System.getProperties();
		for(Entry<Object, Object> e : props.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		
		System.out.println();
		
		String userFolder = System.getProperty("user.home");
		Path p1 = Paths.get(userFolder, "files/file.txt");
		
		try {
			if(Files.notExists(p1.getParent())) {
				Files.createDirectories(p1.getParent()); // Erzeugt alle benötigten Verzeichnisse
				System.out.println("Ordner wurde erzeugt");
			}
			
			if(Files.notExists(p1.getParent().resolve("copies"))) {
				Files.createDirectory(p1.getParent().resolve("copies")); // Erzeugt einen Ordner
				System.out.println("Unter-Ordner wurde erzeugt");
			}
			
			if(Files.notExists(p1)) {
				Files.createFile(p1); // Erzeugt eine Datei
				System.out.println("Datei wurde erzeugt");
			}
			
			System.out.println("Verarbeitung...");
			
			// StandardCopyOption.REPLACE_EXISTING überschreibt eine vorhandene Kopie
			// StandardCopyOption.COPY_ATTRIBUTES alle Attribute des Originals werden mitkopiert
			
			Path copy = p1.getParent().resolve("file_copy.txt");
			Files.copy(p1, copy, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
			
			Path dest = p1.getParent().resolve("copies").resolve(copy.getFileName());
			Files.move(copy, dest, StandardCopyOption.REPLACE_EXISTING); // Datei oder Ordner verschieben
			
			// Files.deleteIfExists(dest); // Löscht eine Datei oder Verzeichnis
			
			// In Datei schreiben
			BufferedWriter w = Files.newBufferedWriter(dest, Charset.defaultCharset());
			w.write("Das ist ein Haus von Nikigraus!");
			w.flush(); // Schreibt in Datei obwohl der Buffer noch nicht voll ist
			w.close();
			
			// Aus Datei lesen
			BufferedReader r = Files.newBufferedReader(dest, Charset.defaultCharset());
			System.out.println(r.readLine());
			
			// alle Zeilen einlesen
			p1 = Paths.get("test.txt");
			List<String> zeilen = Files.readAllLines(p1);
			
			for (String zeile : zeilen) {
				System.out.println(zeile);
			}
			
			zeilen = null; // Liste enthält den Inhalt der Datei und reserviert dafür den Speicher
			
//			p1 = Paths.get("test.txt");
//			System.out.println(p1);
//			Path p2 = p1.toAbsolutePath();
//			System.out.println(p2);
//			System.out.println(p1.equals(p2));
//			System.out.println(Files.isSameFile(p1, p2));
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}
