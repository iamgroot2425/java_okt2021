package de.lubowiecki.ocp.basics;

import java.util.Iterator;

public class DebugTest {
	
	public static void main(String[] args) {
		int i = 10;
		int j = 20;
		doSomething();
		
		if(true) {
			int x = 50; // ist nur in dem Scope verfügbar, in dem sie erzeugt wurde
		}
		
		for (int z = 0; z < args.length; z++) { // z ist nur innerhalb der Schleife sichtbar
		} // am ende der Schleife wird das z vom Speicher entfernt
		
		for (int z = 0; z < args.length; z++) {
//			for (int z = 0; z < args.length; z++) { // Error. z ist hier noch verfügbar und darf nicht redeklariert werden
//			}
		}
		
		if(true) {
			int x = 80;
		}
		
		int x = 60;
		
		{ // definiert einen neuen scope
			int[] arr = new int[1_000_000_000];
			// arr = null; // löst die Referenz, so dass das Array vom Heap entfernt werden kann 
		} // am ende des scopes ist arr out of scope und kann von gc entfernt werden
		
		//...
	}
	
	public static void doSomething() {
		int i = 100;
		int j = 200;
		doSomethingElse();
	}
	
	public static void doSomethingElse() {
		int i = 1000;
		int j = 2000;
	}

}
