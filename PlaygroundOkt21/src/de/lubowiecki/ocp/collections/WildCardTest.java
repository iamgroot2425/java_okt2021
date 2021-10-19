package de.lubowiecki.ocp.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WildCardTest {

	public static void main(String[] args) {
		
		// Generische Typen müssen auf beiden Seiten gleich sein
		//List<Number> zahlen = new ArrayList<Integer>();
		
		// <?> beliebiger Typ zur Laufzeit
		List<?> zahlen = new ArrayList<Integer>();
		zahlen = new ArrayList<String>();
		
		// Tur Laufzeit wird ? durch Object ersetzt
		for(Object obj : zahlen) {
			System.out.println(obj);
		}
		
		//zahlen.add("Hallo"); // add auf Wildcard ist verboten
		// Wildcards verwendet man nur zur Verarbeitung der Collection
		
		// zahlen2 kann mit eine List von beliebigen Zahlentypen sein
		List<? extends Number> zahlen2 = new ArrayList<Double>();
		
		System.out.println();
		
		List<Integer> ints = Arrays.asList(1,2,3,4,5,6,8,20,21,100,17);
		System.out.println(addAllNumbers(ints));
		
		List<Double> doubles = Arrays.asList(1.0,2.5,3.7,4.0,5.6,6.1,8.0,20.0,21.5,100.1,17.18);
		System.out.println(addAllNumbers(doubles));
		
		Set<Double> doubleSet = new HashSet<>(Arrays.asList(1.0,2.5,3.7,4.0,5.6,6.1,8.0,20.0,21.5,100.1,17.18));
		System.out.println(addAllNumbers(doubleSet));
		
		
	}
	
	public static double addAllNumbers(Collection<? extends Number> zahlen) {
		
		double sum = 0;
		for (Number n : zahlen) {
			sum += n.doubleValue();
		}
		
		return sum;
	}

}
