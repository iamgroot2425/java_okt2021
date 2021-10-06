package de.lubowiecki.ocp.basics;

public class GCTest {
	
	public static void main(String[] args) {
		
		Zeug z1 = new Zeug("Peter");
		Zeug z2 = new Zeug("Steve");
		Zeug z3 = new Zeug("Natasha");
		//return; // die Methode wird hier beendet
		z1 = null;
		System.gc(); // GC wird angewiesen die Objekte vom Heap zu entfernen
	}
}

class Zeug {
	
	private final String name;
	
	public Zeug(String name) {
		this.name = name;
		System.out.println(name + ": ICH LEBE!!!!!");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(name + ": UGH... ICH STERBE!");
	}
}
