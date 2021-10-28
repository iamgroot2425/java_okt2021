package de.lubowiecki.ocp.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest3 {

	public static void main(String[] args) {
		
		List<Integer> zahlen = new ArrayList<>(Arrays.asList(5,7,22,15,19,18,7,1));
		
		// Konkrete Klasse (Top-Level oder Inner-Class)
		zahlen.forEach(new CustomConsumer());
		
		// anonyme Klasse
		Consumer<Integer> cons1 = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
		
		System.out.println();
		zahlen.forEach(cons1);
		
		// Lambda in einer Variable
		Consumer<Integer> cons2 = z -> System.out.print(z);
		
		cons2 = cons2.andThen(z -> System.out.println("..."));
		
		System.out.println();
		zahlen.forEach(cons2);
		
		
		System.out.println();
		// Lambda wird direkt eingesetzt
		
		// Consumer: void accept(T t);
		zahlen.forEach(z -> System.out.print(z + " "));
		
		//Predicate: boolean test(T t);
		zahlen.removeIf(z -> z < 10);

		System.out.println();
		zahlen.forEach(z -> System.out.print(z + " "));
		
		//<T> // T mit etwas Rum
		
	}
	
	// Innere Klasse
	private static class CustomConsumer implements Consumer<Integer> {

		@Override
		public void accept(Integer t) {
			System.out.println(t);
		}
	}
}
