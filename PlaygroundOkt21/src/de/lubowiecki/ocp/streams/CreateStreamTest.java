package de.lubowiecki.ocp.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamTest {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>(Arrays.asList("Peter", "Bruce", "Carol", "Tony", "Steve", "Natasha"));
		
		// Collection to Stream
		Stream<String> s1 = set.stream();
		
		// Stream direkt erzeugen
		Stream<Integer> s2 = Stream.of(5,7,19,22,1,8,5,18);
		
		// IntStream von primitiven ints
		IntStream s3 = "Das ist ein Haus von Nikigraus".chars();
		
		// 4 Streams: IntStream, LongStream, DoubleStream, Stream<T>
		
		// Stream gefüllt mit Werten eines Arrays
		Stream<String> s4 = Stream.of("Das ist ein Haus von Nikigraus".split(" "));
		
		// Zahlen in einer Range 
		IntStream s5 = IntStream.range(0, 1000); // 0 bis inkl 999
		s5 = IntStream.rangeClosed(0, 1000); // 0 bis inkl 1000
		
		// UnaryOperator<Integer>
		Stream<Integer> s6 = Stream.iterate(1, i -> i + i);
		// das gleiche
		s6 = Stream.iterate(1, i -> { return i + i; });
		
		Random r = new Random();
		IntStream s7 = IntStream.generate(() -> r.nextInt(10) + 1); // Liefert endlos werte zwischen 1 und 10
		
		// Methoden sind Lazy d.h. sie arbein nicht, solange kein Verbraucher gestartet wurde
		
		System.out.println("Ende");
	}

}
