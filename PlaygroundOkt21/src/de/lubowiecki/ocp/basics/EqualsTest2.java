package de.lubowiecki.ocp.basics;

public class EqualsTest2 {
	
	public static void main(String[] args) {
		
		Object o1 = new Object();
		Object o2 = new Object();
		
		System.out.println(o1 == o2); // Referenzvergleich
		System.out.println(o1.equals(o2)); // Bei der Klasse Object auch Referenzvergleich
		
		System.out.println();
		
		Product p1 = new Product("Uhr", "Junghans - Max Bill", 0.1, 510.0);
		Product p2 = new Product("Uhr", "Junghans - Max Bill", 0.1, 520.0);
		Product p3 = new Product("Uhr", "Junghans - Max Bill", 0.1, 530.0);
		
		System.out.println(p1 == p2);
		// solange equals nicht überschrieben wurde, macht es nur einen Referenzvergleich
		// durch überschreiben sagt man Java, wie zwei Produkte verglichen werden sollen
		System.out.println(p1.equals(p2));
		System.out.println();
		
		System.out.println("reflexiv " + p1.equals(p1));
		System.out.println();
		
		System.out.println("symetrisch " + p1.equals(p2));
		System.out.println("symetrisch " + p2.equals(p1));
		System.out.println();
		
		System.out.println("transitiv " + p1.equals(p2));
		System.out.println("transitiv " + p2.equals(p3));
		System.out.println("transitiv " + p1.equals(p3));
		System.out.println();
		
		// Wenn hashCode nicht überschrieben ist, dann liefert jedes Objekt einen eigenen HashCode
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		System.out.println();
		
		System.out.println(p1);
		
		
	}
}
