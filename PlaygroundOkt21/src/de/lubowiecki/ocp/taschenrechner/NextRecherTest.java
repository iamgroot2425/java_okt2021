package de.lubowiecki.ocp.taschenrechner;

public class NextRecherTest {
	
	public static void main(String[] args) {
		
		NextRechner r1 = new NextRechner();
		NextRechner r2 = new NextRechner();
		
		r1.add(10, 0.5);
		r1.add(12, 15);
		r1.add(17, -3.7);
		
		r2.add(10, 20);
		r2.add(1, 2);
		
		System.out.println(r1);
		System.out.println();
		System.out.println(r2);
		
		// Verarbeitet eine Methode lediglich die Eingangsparameter, ohne den
		// Zustand des Objektes zu verändern, dann kann die Methode auch statisch sein.
		
		
	}

}
