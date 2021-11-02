package de.lubowiecki.ocp.streams;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReductionTest {

	public static void main(String[] args) {
		
		// Immutable Reduction
		Stream<String> buchstaben = Stream.of("A", "B", "C", "D", "E");
		
		// Optional, weil der Stream leer sein könnte
		Optional<String> erg1 = buchstaben.reduce((a, b) -> a + "," + b);
		
		if(erg1.isPresent()) {
			System.out.println(erg1.get());
		}
		
		System.out.println();
		
		buchstaben = Stream.of("A", "B", "C", "D", "E");
		//erg1 = buchstaben.reduce(Collectors.joining()); // geht nicht
		String erg3 = buchstaben.reduce("#", (a, b) -> a + "," + b);
		// Ist der Stream leer, wird # als Startwert zurückgegeben
		System.out.println(erg3);
		
		System.out.println();

		IntStream zahlen = IntStream.of(5,6,7,8,9,10);
		
		// Optional, weil der Stream leer sein könnte
		OptionalInt erg2 = zahlen.reduce((a, b) -> a + b);
		
		if(erg2.isPresent()) {
			System.out.println(erg2.getAsInt()); // enthält einen int Wert
		}
		
		// Mutable Reduction
		// Kann methoden von Collectors verwenden
		
		buchstaben = Stream.of("A", "B", "C", "D", "E");
		
		// StringBuilder::new ist eine Supplier Methoden-Referenz: 
		// StringBuilder::append ist ein BiConsumer
		// StringBuilder::append ist ein BiConsumer als combiner - wird nur parallele Streams verwendet
		StringBuilder sb = buchstaben.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(sb);
		
		System.out.println();
		
		buchstaben = Stream.of("A", "B", "C", "D", "E");
		// Set::addAll fügt die Teil-Sets zu einem Set zusammen - nur für parallele Streams wichtig
		Set<String> set = buchstaben.collect(HashSet::new, Set::add, Set::addAll);
		System.out.println(set);
		
		System.out.println();
		
		buchstaben = Stream.of("A", "B", "C", "A", "D", "E", "C");
		set = buchstaben.collect(Collectors.toSet());
		System.out.println(set);
		
		System.out.println();
		
		buchstaben = Stream.of("A", "B", "C", "A", "D", "E", "C");
		List<String> list = buchstaben.collect(Collectors.toList());
		System.out.println(list); // Diese Liste kann verändert werden
		
		System.out.println();
		
		buchstaben = Stream.of("A", "B", "C", "A", "D", "E", "C");
		list = buchstaben.collect(Collectors.toUnmodifiableList());
		System.out.println(list); // Diese Liste kann NICHT verändert werden
		
		
		System.out.println();
		
		buchstaben = Stream.of("A", "B", "C", "A", "D", "E", "C");
		//String kette = buchstaben.collect(Collectors.joining());
		//String kette = buchstaben.collect(Collectors.joining(", "));
		String kette = buchstaben.collect(Collectors.joining(", ", ">>", "<<"));
		System.out.println(kette);
		

	}

}
