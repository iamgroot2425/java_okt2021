package de.lubowiecki.ocp.basics;

public class ArrayTest {
	
	public static void main(String[] args) {
		
		int[] i = {1,2,3}; // {}-Schreibweise nur bei gleichzeitiger Deklaration und Initialisierung
		
		int j[]; // Deklaration
		//j = {1,2,3}; // ungültige Initialisierung
		j = new int[]{1,2,3}; // gültige Initialisierung
		
		int k[] = new int[10]; // Leeres Array mit 10 Positionen
		
		k[4] = 100;
		
		for (int z = 0; z < k.length; z++) {
			System.out.println(k[z]);
		}
		
		System.out.println();
		
		for (int z : k) {
			System.out.println(z);
		}
		
		System.out.println();
		
		System.out.println(k[4]); // Alle Arrays in Java beginnen mit 0
		System.out.println(k); // toString() wird automatisch verwendet
		
		//int[] a, b, c;
		//int a, b[], c;
		int[] a, b[], c;
		
	}

}
