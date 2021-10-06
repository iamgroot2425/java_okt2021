package de.lubowiecki.ocp.basics;

import java.util.Arrays;

public class SearchTest {
	
	public static void main(String[] args) {
		
		new SearchTest().init();
		
	}

	private void init() {
		String[] namen = {"Peter", "Bruce", "Natasha", "Steve", "Tony", "Carol"};
		
		System.out.println(search(namen, "Natasha"));
		
		// mit Utility-Class
		Arrays.sort(namen);
		int pos = Arrays.binarySearch(namen, "Natasha");
		System.out.println(pos); 
		
		
	}
	
	private int search(String[] haufen, String nadel) {
		
		for (int i = 0; i < haufen.length; i++) {
			if(haufen[i].equalsIgnoreCase(nadel))
				return i;
		}
		
		return -1;
	}
}
