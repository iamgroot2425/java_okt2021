package de.lubowiecki.aufgaben.uebung8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		
		CollectionsToolBox<String> box = new CollectionsToolBox<>();
		
		Set<String> namen = new HashSet<>(Arrays.asList("Peter", "Carol", "Bruce", "Tony", "Natasha", "Steve"));
		
		Comparator<String> comp = (a, b) -> a.length() - b.length();
		
		List<String> namenListe = box.toSortedList(namen, comp);
		System.out.println(namenListe);
		
		System.out.println();
		
		namenListe = CollectionsToolBox.toSortedListStatic(namen);
		System.out.println(namenListe);
		
		Set<Integer> ints = new HashSet<>(Arrays.asList(5, 1, 18, 3, 2, 6));
		List<Integer> intList = CollectionsToolBox.toSortedListStatic(ints);
		System.out.println(intList);
	}

}
