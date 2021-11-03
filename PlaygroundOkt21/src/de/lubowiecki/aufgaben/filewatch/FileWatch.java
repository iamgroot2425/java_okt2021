package de.lubowiecki.aufgaben.filewatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;

public class FileWatch {
	
	private final Scanner scanner;
	
	public FileWatch() {
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new FileWatch().go();
	}

	private void go() {
		
		System.out.println("Welche Datei soll beobachtet werden?");
		
		String fileName = scanner.next(); // Liest daten von der Konsole ein
		
		String[] fileNames = fileName.split(","); // Zerlegt den String in Teilstrings nach dem ,
		
		for(String fileNamePart : fileNames) {
			new Thread(createWatcher(fileNamePart)).start(); // Startet für jeden Teilstring einen Watcher-Thread
		}
	}
	
	// Erzeugt ein Runnable mit einem passenden Path
	private Runnable createWatcher(String pathStr) {
		
		Path path = Path.of(pathStr);
		
		return () -> {
			if(Files.exists(path)) { // Prüft, ob der Pfad exisitiert
				
				FileTime fileTime = null;
				
				while(true) {
					
					try {
						if(fileTime == null) {
							fileTime = Files.getLastModifiedTime(path); // Liest die Bearbeitungszeit beim ersten Durchlauf aus
						}
						else {
							// Prüft, ob sich die Datei seit der letzten Prüfung geändert hat
							if(!Files.getLastModifiedTime(path).equals(fileTime)) {
								// Wenn ja, gibt es eine Ausgabe
								System.out.println("Die Datei " + path.toString() + " wurde geändert!");
								// ... und die lastModifiedTime für die Datei wird upgedated
								fileTime = Files.getLastModifiedTime(path);
							}
						}
						
						// Wartet eien halbe Sekunde bis zur der nächsten Prüfung
						Thread.sleep(500);
						
					}
					catch(IOException e) {
						System.out.println(e.getMessage());
					}
					catch(InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			else {
				System.out.println("Die Datei " + path.toString() + " gibt es nicht!");
			}
		};
	}
}
