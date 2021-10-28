package de.lubowiecki.ocp.lambda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import de.lubowiecki.aufgaben.uebung4.Product;

public class LambdaTest4 {

	public static void main(String[] args) {
		
		// Function<T, R>: R apply(T t)
		Function<Integer, Integer> f1 = i -> i * i;
		
		Function<String, Integer> f2 = s -> Integer.parseInt(s);
		
		Function<Integer, String> f3 = i -> i + "";
		
		Function<String, LocalDate> f4 = s -> {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			return LocalDate.parse(s, dtf);
		};
		
		System.out.println(f1.apply(10)); // 100
		System.out.println(f2.apply("10") + 2); //12
		System.out.println(f3.apply(10) + 2); // 102
		System.out.println(f4.apply("10.02.2021"));
		
		System.out.println();
		
		List<Integer> zahlen = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		//editAndPrint(zahlen, f1);
		editAndPrint(zahlen, (i) -> (i + 2) * 3);
		
		System.out.println();
		
		List<Double> dZahlen = new ArrayList<>(Arrays.asList(1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8,9.9,10.10));
		//editAndPrint(zahlen, f1);
		editAndPrint(dZahlen, (i) -> i * i);
		
		System.out.println();

		System.out.println(zahlen);
		
		// UnaryOperator: ist eine Function, deren Eingangstyp und Rückgabetyp gleich sind
		//UnaryOperator<T>: T apply(T t)
		zahlen.replaceAll(z -> z * z);
		System.out.println(zahlen);
		
		
		System.out.println();

		// BiFunction<T,U,R>: R apply(T t, U u)
		BinaryOperator<Integer> add = (a, b) -> a + b; 
		BiFunction<Integer, Integer, Integer> sub = (a, b) -> a - b;
		BinaryOperator<Integer> multi = (a, b) -> a * b;
		BiFunction<Integer, Integer, Double> div = (a, b) -> a.doubleValue() / b;
		
		System.out.println(add.apply(10, 15));
		System.out.println(sub.apply(10, 15));
		System.out.println(multi.apply(10, 15));
		System.out.println(div.apply(10, 15));
		
		System.out.println();
		
		Supplier<Integer> diceCup = () -> (int)(Math.random() * 6) + 1;
		
		System.out.println(diceCup.get());
		System.out.println(diceCup.get());
		System.out.println(diceCup.get());
		System.out.println(diceCup.get());
		System.out.println(diceCup.get());
		System.out.println(diceCup.get());
		
		System.out.println();
		
		Stream.generate(diceCup) // Produziert Zufallszahlen über den Supplier
			  .limit(100) // Hört nach 100 Zahlen auf
			  .forEach(System.out::println); // Gibt jede Zahl auf der Konsole aus
		
		
		System.out.println();
		System.out.println("Produkte");
		
		List<Product> products = new ArrayList<>();
		products.add(new Product("Apfel", 1.0, 1000, 2.29));
		products.add(new Product("Birne", 1.0, 1000, 3.59));
		products.add(new Product("Kiwi", 0.1, 300, 0.69));
		products.add(new Product("Kiwi Gold", 0.1, 150, 0.79));
		products.add(new Product("Kirschen", 1.0, 500, 6.99));
		
		Predicate<Product> pred1 = p -> p.getCount() < 500;
		Predicate<Product> pred2 = p -> p.getPrice() > 0.5;
		
		products.stream()
				//.filter(pred1.and(pred2))
				.filter(LambdaTest4::check) // statische Methode als Methodenreferenz
				.filter(new LambdaTest4()::nextCheck) // Instanzmethode als Methodenreferenz
				.forEach(System.out::println); // (p) -> System.out.println(p)
				// Methodenreferenz ist ein Verweis auf eine Methode mit der gleichen Signatur,
				// die als Implementierung der abstrakten Methode des Interface genutzt werden kann
		
				//public void accept(Product t)
				//public void println(Object x);
	}
	
	// Predicate<Produkt>: boolean test(Product t)
	static boolean check(Product p) {
		return p.getCount() < 500 && p.getPrice() > 0.5;
	}
	
	// Predicate<Produkt>: boolean test(Product t)
	boolean nextCheck(Product p) {
		return p.getCount() < 500 && p.getPrice() > 0.5;
	}
	
	static <T extends Number> void editAndPrint(List<T> l, UnaryOperator<T> f) {
		for (T i : l) {
			System.out.println(f.apply(i));
		}
	}
}
