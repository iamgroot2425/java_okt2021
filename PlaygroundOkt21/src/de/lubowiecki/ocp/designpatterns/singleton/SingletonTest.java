package de.lubowiecki.ocp.designpatterns.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		
		// Lazy: Objekt wird erst beim ersten Aufruf von getInstance gebaut
		LazySingleton s1 = LazySingleton.getInstance();
		LazySingleton s2 = LazySingleton.getInstance(); // Liefert immer ein und das gleiche Objekt
		System.out.println(s1 == s2);
		
		// Objekt wird bereits beim Laden der Klasse erzeugt
		EagerSingleton s3 = EagerSingleton.getInstance();
		EagerSingleton s4 = EagerSingleton.getInstance(); // Liefert immer ein und das gleiche Objekt
		System.out.println(s3 == s4);
		
		
		

	}

}
