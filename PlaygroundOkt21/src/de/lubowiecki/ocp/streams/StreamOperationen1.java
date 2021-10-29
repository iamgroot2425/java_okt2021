package de.lubowiecki.ocp.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperationen1 {

	public static void main(String[] args) {
		
		List<String> coll = Arrays.asList("Peter", "Bruce", "Carol", "Tony", "Steve", "Natasha");
		
		Stream<String> namen = coll.stream();
		
		// Alle Operationen betreffen nur den Stream nicht die original Collection
		namen.filter(n -> n.length() > 4) // statuslose intermediate Operation, ist lazy, braucht ein Predicate
			 .map(n -> n.toUpperCase()) // statuslose intermediate Operation, ist lazy, braucht eine Function oder UnaryOperator
			 .forEach(n -> System.out.println(n)); // terminirende Operation (Verbraucher), braucht eine Consumer

		// Ein Stream kann nur 1x verarbeitet werden
		
		System.out.println();
		
		// Die stream-Methode erzeugt jedes mal einen neuen Stream
		
		coll.stream()
			.peek(n -> System.out.print("#1" + n + " "))
		    .peek(n -> System.out.print("#2" + n + " "))
		    .peek(n -> System.out.print("#3" + n + " "))
		    .peek(n -> System.out.print("#4" + n + " "))
		    .forEach(n -> System.out.print("#T" + n + "\n"));
		
//		coll.parallelStream()
//		.peek(n -> System.out.print("#1" + n + " "))
//	    .peek(n -> System.out.print("#2" + n + " "))
//	    .peek(n -> System.out.print("#3" + n + " "))
//	    .peek(n -> System.out.print("#4" + n + " "))
//	    .forEach(n -> System.out.print("#T" + n + "\n"));;
		
		System.out.println();
		
		// map erlaubt eine Änderung des Wertes oder des Typs, braucht eine 
		// Function(Wert- oder Typ-Änderung) oder UnaryOperator(Wert-Änderung)
		
		// filter entfernt alles, was zum vorgegebenen Predicat nicht passt
		
		coll.stream()
		.peek(n -> System.out.print("#1:" + n + " "))
		.filter(n -> !n.startsWith("T")) // Predicate für String
		.map(n -> n.length()) // Ändert String in Integer
	    .peek(i -> System.out.print("#2:" + i + " "))
	    .map(i -> i * 2) // Verändert den Integer
	    .filter(i -> i < 12) // Predicate für Integer
	    .forEach(i -> System.out.print("#T:" + i + "\n"));
		
		System.out.println();
		
		Random r = new Random();
		IntStream zahlen = IntStream.generate(() -> r.nextInt(1000) + 1); // Zahlen zwischen 1 und 1000;
		
		List<Integer> rands = zahlen.limit(1_000_000) // generate wird 1 mio mal ausgeführt
			.filter(z -> z > 500)
			.filter(z -> z < 600)
			.map(z -> Integer.valueOf(z))
			.collect(ArrayList::new, List::add, List::addAll); // Elemente des Streams werden in eine List abgelegt
			//.forEach(System.out::println); // Es werden nur Zufallszahlen zwischen 500 und 600 ausgegeben
		
		// ArrayList::new ist ein Supplier in dieser Form: () -> new ArrayList<Integer>();
		
		
		System.out.println(rands);
		System.out.println(rands.size());
		
		System.out.println();

		// int compare(T o1, T o2);
		Comparator<String> comp = (s1, s2) -> s1.length() - s2.length(); // Sortiert nach der Länge der Zeichenkette
		
		coll.stream()
			.limit(2) // gibt nur 2 Elemente weiter
			//.sorted() // Sortiert die Elemente nach natürlicher Ordnung
			.sorted(comp) // Sortiert die Elemente nach einem Comparator
			.forEach(System.out::println);
		
		
	}

}
