package de.lubowiecki.ocp.basics.vererbung;

public class KonstruktorTest {

	public static void main(String[] args) {
		
		Child c1 = new Child(); 
		// Ruft den default-Konstruktor auf und dieser 
		// ruft den default-Konstruktor der Elternklasse auf
		
		Parent p = new Child(); // Jedes Child Objekt besteht auch aus einem Parent-Objekt
		p.getRandNumber();

	}

}

class Parent {
	
//	public Parent(String s) {
//	}
	
	public Parent() {
		System.out.println("Parent Const...");
	}
	
	public int getRandNumber() {
		return 10;
	}
	
	Number getRandWrapperNumber() { // package-private
		return 10;
	}
}

class Child extends Parent {
	
	// So sieht ein default-Konstruktor aus
	public Child() {
		// ruft immer den default-Konstruktor der Elternklasse auf
		//super();
		System.out.println("Child Const...");
	}
	
	// Für primitive Rückgabe-Type gibt es keine CoVarianz d.h. Rückgabe-Typ muss gleich bleiben
	@Override
	public int getRandNumber() { // protected und package-private geht nicht, da restrektiver
		return 6;
	}
	
	@Override
	public Integer getRandWrapperNumber() { // Integer IS-A Number und daher CoVariant
		return 6;
	}
	
}
