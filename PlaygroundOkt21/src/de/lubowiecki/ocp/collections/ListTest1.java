package de.lubowiecki.ocp.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListTest1 {

	public static void main(String[] args) {
		
		// ArrayList
		
		// [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
		List<Integer> zahlen = new ArrayList<>(50);
		
		// [10][ ][ ][ ][ ][ ][ ][ ][ ][ ]
		zahlen.add(10);
		
		// [10][5][ ][ ][ ][ ][ ][ ][ ][ ]
		zahlen.add(5); // fügt das Element an die nächste frei Stelle
		
		// [7][10][5][ ][ ][ ][ ][ ][ ][ ]
		zahlen.add(0, 7); // fügt das Element an die Stelle 0 - 10 und 5 müssen um eine Stelle verschoben werden
		
		// [10][5][ ][ ][ ][ ][ ][ ][ ][ ]
		zahlen.remove(0); // Entfernt das Element an Stelle 0 - 10 und 5 müssen um eine Stelle zurückgeschoben werden
		
		// Vorteile: 
		// Schneller (Wahlfreier-)Zugriff auf gewünsche Positionen
		// Schnelles Hinzufügen und Entfernen am Ende
		
		// Nachteile:
		// Hinzufügen oder Entfernen an bereits belegten Positionen führt zu langsamen Array-Verschiebungen
		
		// Am besten beeignet um Werte an verschiedenen Positionen zu lesen
		
		// LinkedList
		
		zahlen = new LinkedList<>(); // Kann auch auf eine List Referenz abgelegt werden
		// Collection sammlung = new LinkedList<>(); // Kann auch auf eine Collection Referenz abgelegt werden
		
		// (15) -> 
		zahlen.add(15);
		// (15) <-> (17) ->
		zahlen.add(17);
		
		// (15) <-> (17) <-> (22) ->
		zahlen.add(22);
		
		// (15) <-> (25) <-> (17) <-> (22) ->
		zahlen.add(1, 25);
		
		// Vorteile:
		// Schnelles Hinzufügen an gewüschten Positionen, da keine Elementverschiebungen nötig sind
		// Schnelles Hinzufügen und Entfernen am Ende
		
		// Nachteile
		// Langsamer (Wahlfreier-)Zugriff auf gewünsche Positionen
		
		
		zahlen = new ArrayList<>(zahlen); // Wechsel von LinkedList zu ArrayList
		
		for (Integer zahl : zahlen) {
			System.out.println(zahl);
		}
		
		zahlen = new LinkedList<>(zahlen); // Wechsel von ArrayList zu LinkedList 
		
		for (Integer zahl : zahlen) {
			System.out.println(zahl);
		}
		
		for (int i = 0; i < zahlen.size(); i++) {
			// Abfrage bestimmter Positionen geht nur bei Collections mit einem Index (Listen)
			System.out.println(zahlen.get(i)); 
		}
		
		// Suche in Listen bedeutet, dass alle Elemente geprüft werden müssen
		// Alternative Halbierungs-Suche (Binary-Search)
		// Für Binary-Search müss die Liste sortiert sein
		
		System.out.println("unsortiert: " + zahlen);
		
		// Collections = Utility-Klasse für Sammlungen aller Art
		Collections.sort(zahlen); // sort gibt es NUR für Listen, default: natürliche Reihenfolge
		
		System.out.println("sortiert: " + zahlen); // toString für alle Collection zeigt die Elemente
	}

}
