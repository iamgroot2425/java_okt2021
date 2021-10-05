package de.lubowiecki.ocp.basics;

public class EqualsTest {
	
	public static void main(String[] args) {
		
		Person p1 = new Person("Peter", "Parker");
		Person p2 = new Person("Peter", "Parker");
		
		System.out.println(p1 == p2); // Referenzvergleich
		System.out.println(p1.equals(p2)); // Inhaltsvergleich
		// equals wird von der Klasse Object geerbt
		
		System.out.println(p1.hashCode() + " " + p2.hashCode());
		
		System.out.println();
		
		String s1 = "Hallo"; // Landet im Pool
		//String s2 = "Hallo";
		String s2 = new String("Hallo"); // landet nicht im Pool
		
		System.out.println(s1 == s2); // Referenzvergleich
		System.out.println(s1.equals(s2)); // Inhaltsvergleich
		
		System.out.println(s1.hashCode() + " " + s2.hashCode());
	}

}
