package de.lubowiecki.ocp.lambda;

import java.util.function.Predicate;

public class LambdaTest2 {

	public static void main(String[] args) {
		
		// Kein Lambda ohne FunctionalInterface!!!!
		// Die abstrakte Methode des Interface ist ein Template für das Lambda
		// a ist ein int
		// Rückgabetyp muss void sein
		// Lambda ist die Implementierung der abstrakten Methode
		FuncInterface1 f1 = (a) -> System.out.println(a);
		f1.machWas(1000);
		
		f1 = (int a) -> {
			if(a < 1000) {
				System.out.println("Kleine Zahl: " + a);
			}
			else {
				System.out.println("Große Zahl: " + a);
			}
		};
		
		int zahl = 500;
		
		f1 = a -> {
			// Lokale variablen, die in Lambdas verwendet werden müssen final oder effektiv final sein
			// effektiv final = variable ist NICHT final, wird aber nicht geändert
			
			if(a < 1000) {
				System.out.println("Kleine Zahl: " + (a + zahl));
			}
			else {
				System.out.println("Große Zahl: " + (a + zahl));
			}
		};
		
		//zahl = 600; // führt zum Fehler im Lambda, da nicht mehr effektiv final
		
		f1.machWas(500);
		
		// boolean test(T t);
		Predicate<String> p1 = s -> s.startsWith("H");
		
		System.out.println(p1.test("Hamburg"));
		System.out.println(p1.test("Berlin"));
		
		NumberChecker<Integer> nc1 = z -> z > 100 ? true : false;
		System.out.println(nc1.check(50));
		
		NumberChecker<Double> nc2 = z -> z > 100 ? true : false;
		System.out.println(nc2.check(105.0));

		// String ist nicht von Number abgeleitet
		//NumberChecker<String> nc3 = z -> z.length() > 100 ? true : false;
	}

}
