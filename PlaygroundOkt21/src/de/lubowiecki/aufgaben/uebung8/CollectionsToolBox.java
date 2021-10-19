package de.lubowiecki.aufgaben.uebung8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsToolBox<T> {
	
	private final Comparator<T> COMPARATOR = (a, b) -> ((Comparable) a).compareTo(b); 

	// Verwendet den generischen Typ der Klasse
	public List<T> toSortedList(Collection<T> elements) {
		
		List<T> list = new ArrayList<>(elements); // Wechsel von Collection auf List
		Collections.sort(list, COMPARATOR);
		
		return list;
	}
	
	public List<T> toSortedList(Collection<T> elements, Comparator<T> comp) {
		
		List<T> list = new ArrayList<>(elements);
		Collections.sort(list, comp);
		
		return list;
	}
	
//	public List<T> toSortedList(Collection<T> elements) {
//		Set<T> set = new TreeSet<>(elements); // Ist automatisch sortiert
//		return new ArrayList<>(set); // Wechsel von TreeSet auf List
//	}
//	
//	public List<T> toSortedList(Collection<T> elements, Comparator<T> comp) {
//		Set<T> set = new TreeSet<>(comp); // Ist automatisch sortiert
//		set.addAll(elements); // Nimmt alle Elemente auf
//		return new ArrayList<>(set); // Wechsel von TreeSet auf List
//	}
	
	
	// Generische Methode, definiert ein eigenes T
	public static <T> List<T> toSortedListStatic(Collection<T> elements) {
		
		Comparator<T> COMPARATOR = (a, b) -> ((Comparable) a).compareTo(b); 
		
		List<T> list = new ArrayList<>(elements); // Wechsel von Collection auf List
		Collections.sort(list, COMPARATOR);
		
		return list;
	}
	
	public static <U> List<U> toSortedListStatic(Collection<U> elements, Comparator<U> comp) {
		
		List<U> list = new ArrayList<>(elements);
		Collections.sort(list, comp);
		
		return list;
	}

}
