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
		
		
		System.out.println();

		
		int[][] arr1 = new int[3][5];
		
		int[][] arr2 = new int[3][];
		arr2[0] = new int[3];
		arr2[1] = new int[6];
		arr2[2] = new int[2];
		
		
		int[][] arr3 = {{2,5,8},{1,0},{7,18,22,19,0}};
		
		for (int[] subArr : arr3) {
			for (int wert : subArr) {
				System.out.print(wert + " ");
			}
			System.out.println();
		}
		
		arr3[2][2] = 9;
		System.out.println(arr3[1][2]);
		
	}

}
