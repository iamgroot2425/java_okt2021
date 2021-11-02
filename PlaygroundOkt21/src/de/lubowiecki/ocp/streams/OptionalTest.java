package de.lubowiecki.ocp.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalTest {

	public static void main(String[] args) {
		
		int pos = search(new int[]{1,2,3,4,5,6,7,8,9,10}, 15);
		System.out.println(pos);
		
		// IntPredicate: z -> z > 9;
		OptionalInt opt = search(new int[]{1,-2,3,-1,5,6,-7,8,-9,10}, z -> z > 9);
		//System.out.println(opt.getAsInt()); // getAsInt zeigt den Wert im Optional
		opt.ifPresent((i) -> System.out.println(i)); // Zeigt den wert aus den Optional, nur, wenn er da ist
		
		// TODO: Schreibe je 2 Implementierungen für
		// Supplier
		// Consumer
		// Predicate
		// Function
		// UnaryOperator
		
		// Array to Stream
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
		IntStream iStream = Arrays.stream(arr);
		
		// Stream to Array
		arr = iStream.filter(i -> i > 5).toArray();
		
		// Komplex
		Integer[] integerArr = new Integer[]{1,2,3,4,5,6,7,8,9,10};
		Stream<Integer> integerStream = Arrays.stream(integerArr);
		
		// Stream to Array
		// toArray auf einem Objekt-Stream liefert per default ein Array von Object
		Object[] objectArr = integerStream.filter(i -> i > 5).toArray();
		
		
		try {
			Stream<String> lines = Files.lines(Paths.get("test.txt"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// Liefert die position des gesuchten Wertes
	public static int search(int[] heuhaufen, int nadel) {
		
		for(int i = 0; i < heuhaufen.length; i++) {
			if(heuhaufen[i] == nadel) {
				return i;
			}
		}
		return -1;
	}
	
	// Liefert den Wert, der dem Predicate entspricht
	public static OptionalInt search(int[] heuhaufen, IntPredicate p) {
		
		for(int i = 0; i < heuhaufen.length; i++) {
			if(p.test(heuhaufen[i])) {
				return OptionalInt.of(heuhaufen[i]);
			}
		}
		//return -1; // falsch
		return OptionalInt.empty(); // liefert einen leeren Container, da kein passender Wert gefunden wurde
	}
}
