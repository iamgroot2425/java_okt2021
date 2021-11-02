package de.lubowiecki.ocp.streams;

import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;

public class PrimitiveTerminalTest {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		IntStream iStream = IntStream.generate(() -> rand.nextInt(1000) + 1);
//		int sum = iStream.limit(1000).sum();
//		System.out.println(sum);
		
		OptionalDouble opt = iStream.limit(1000).average(); // Optional, weil der Stream leer sein könnte
		opt.ifPresent(w -> System.out.println(w));
		
		// wirft eine Exception, wenn Optional leer ist
		System.out.println(opt.getAsDouble()); // liefert einen primitiven Double
		
		System.out.println(opt.orElse(0)); // liefert eine 0.0 wenn das Optional leer ist
		

	}

}
