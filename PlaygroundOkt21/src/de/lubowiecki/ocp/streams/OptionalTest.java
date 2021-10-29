package de.lubowiecki.ocp.streams;

import java.util.OptionalInt;
import java.util.function.IntPredicate;

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
