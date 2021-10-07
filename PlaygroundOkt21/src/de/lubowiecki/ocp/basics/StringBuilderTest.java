package de.lubowiecki.ocp.basics;

public class StringBuilderTest {

	public static void main(String[] args) {
		
		
		new StringBuilder(); // default capacity 16
		new StringBuilder("abcd"); // capacity anzahl Zeichen + 16 = 20
		new StringBuilder(10); // capacity 10
		
		StringBuilder sb1 = new StringBuilder();
		System.out.println(sb1.length()); // Anzahl der Zeichen im sb
		System.out.println(sb1.capacity()); // größe des inneren Arrays
		System.out.println();
		
		sb1.append("abcdef"); // fügt die Inhalte zum sb hinzu
		
		System.out.println(sb1.length());
		System.out.println(sb1.capacity());
		System.out.println();
		
		sb1.append("abcdef");
		sb1.insert(5, "123");
		
		System.out.println(sb1.length());
		System.out.println(sb1.capacity());
		System.out.println(sb1); // toString-Methode gibt den Inhalt aus
		System.out.println();
		
		sb1.append("abcdef"); // Vergrößern = alte größe * 2 + 2
		System.out.println(sb1.length());
		System.out.println(sb1.capacity());
		System.out.println();
		
		sb1.trimToSize(); // Schneidet die capacity auf benötigte Größe zu
		System.out.println(sb1.length());
		System.out.println(sb1.capacity());
		System.out.println();
	}
	
}
