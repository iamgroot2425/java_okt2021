package de.lubowiecki.ocp.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class StreamTest1 {

	public static void main(String[] args) {
		
		List<Integer> zahlen = new ArrayList<>(Arrays.asList(2,5,8,9,15,22,25,32,100));
		
		// Externe Iteration 
		
		for (Integer zahl : zahlen) {
			// Thread.currentThread().getName() liefert den Namen des aktuell laufenden Threads
			// Thread ist ein Sub-Prozess eines Programms
			System.out.println(Thread.currentThread().getName() + ": " + zahl);
		}
		
		System.out.println();
		
		for (int i = 0; i < zahlen.size(); i++) {
			System.out.println(Thread.currentThread().getName() + ": " + zahlen.get(i));
		}
		
		// Interne Iteration
		
		Consumer<Integer> cons = z -> System.out.println(Thread.currentThread().getName() + ": " + z);
		System.out.println();
		zahlen.forEach(cons);
		// zahlen.forEach(null); // null ist durch Objects.requireNonNull(action); nicht erlaubt
		
		System.out.println();
		zahlen.stream().forEach(cons); // sequential
		
		System.out.println();
		zahlen.parallelStream().forEach(cons); // paralell
		
		// Objects ist eine Utility-Klass mit statischen Methoden zur Verarbeitung von Objekten
		
		// Supplier<T>: T get()
		
		String s = "Voll";
		// Supplier<String>: String get(), Methode hat 0 Parameter und String als Return
		s = Objects.requireNonNullElseGet(s, () -> "Leer"); // () -> "Leer" ist ein Supplier
		System.out.println(s);
		
		
		LocalDate ld = LocalDate.of(2021, 11, 7);
		// Supplier<LocalDate>: LocalDate get(), Methode hat 0 Parameter und LocalDate als Return
		ld = Objects.requireNonNullElseGet(ld, () -> LocalDate.now()); // () -> LocalDate.now() ist ein Supplier
		System.out.println(ld);

	}

}
