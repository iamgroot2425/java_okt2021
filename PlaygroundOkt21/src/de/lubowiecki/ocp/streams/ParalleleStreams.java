package de.lubowiecki.ocp.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ParalleleStreams {

	public static void main(String[] args) {
		
		int[] zahlen = {2,17,22,13,7,18,100,25,29,15,1,2,5,9,102,18,17};
		IntStream stream = Arrays.stream(zahlen);
		
		// parallel ändert den Stream in einen parallelen Stream
		// sequential ändert den Stream in einen sequenziellen Stream
		
		// alles wir sequenziell verarbeitet, da die letzte Änderuzng auf sequential ist
		// stream.parallel().filter(...).sequential().forEach(...);
		
		// Reihenfolge der Verarbeitung ist parallelen-Streams nicht voraussehbar
		stream.parallel().sorted().forEach(i -> System.out.println(i));
		
		System.out.println();
		
		stream = Arrays.stream(zahlen);
		// Geordnete Ausgabe wird auf Kosten der Performance erzwungen
		stream.parallel().sorted().forEachOrdered(i -> System.out.println(i));

	}
}
