package de.lubowiecki.ocp.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class TerminalOperations1 {

	public static void main(String[] args) {
		
		List<Integer> zahlen = Arrays.asList(10,25,33,1,7,100,27,19,4,5,1000);
		
		// min liefert ein Optional, weil es sein kann, dass das Stream keine Elemente enthält
		// (a, b) -> a.compareTo(b) ist ein Lambda für einen Comparator
		Optional<Integer> opt1 = zahlen.stream().min((a, b) -> a.compareTo(b));
		
		// Integer::compare ist eine Methodenreferenz auf die compare-Methode die zwei Parameter entgegennimmt
		//Optional<Integer> opt1 = zahlen.stream().min(Integer::compare);
		// Ausgeben, wenn Optional gefüllt ist
		opt1.ifPresent(w -> System.out.println("MIN: " + w));
		
		opt1 = zahlen.stream().max((a, b) -> a.compareTo(b));
		// Ausgeben, wenn Optional gefüllt ist
		opt1.ifPresent(w -> System.out.println("MAX: " + w));
		
		System.out.println();
		
		// Match-Methoden
		Predicate<Integer> pred = w -> w > 20; // Behauptung: werte sind größer als 20
		boolean treffer = zahlen.stream().anyMatch(pred); // anyMatch: Mind ein Wert ist größer als 20
		System.out.println("Mindestens ein Treffer: " + treffer);
		
		treffer = zahlen.stream().allMatch(pred); // allMatch: Alle Werte sind größer als 20
		System.out.println("Alle Werte sind Treffer: " + treffer);
		
		treffer = zahlen.stream().noneMatch(pred); // noneMatch: Kein Wert ist größer als 20
		System.out.println("Es gibt keine Treffer: " + treffer);

	}

}
