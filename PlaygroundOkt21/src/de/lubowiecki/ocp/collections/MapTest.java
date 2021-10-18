package de.lubowiecki.ocp.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		
		Map<String, Integer> einwohner = new HashMap<>(); // Ist keine Kindklasse von Collection
		einwohner.put("Hamburg", 1_900_000); // Fügt ein Element inkl Schlüssel hinzu
		einwohner.put("Berlin", 4_000_000);
		einwohner.put("München", 1_600_000);
		einwohner.put("Köln", 1_200_000);
		einwohner.put("Kiel", 600_000);
		
		// Der Schlüssel ist in einer Map einzigartig
		System.out.println(einwohner.get("Berlin")); // Suche erfolgt nach dem Schlüssel
		einwohner.put("München", 1_700_000); // Aktuallisiert den Wert hinter dem Schüssel München
		
		
		
		

	}

}
