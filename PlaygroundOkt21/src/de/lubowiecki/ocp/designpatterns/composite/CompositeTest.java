package de.lubowiecki.ocp.designpatterns.composite;

public class CompositeTest {
	
	public static void main(String[] args) {
		
		Movable l1 = new Läufer();
		l1.moveTo(10, 10);
		
		Movable r1 = new Radfahrer();
		r1.moveTo(10, 10);
		
		System.out.println();
		
		Gruppe g1 = new Gruppe(); // Gruppe IS-A Movable
		g1.addElement(l1);
		g1.addElement(r1);
		g1.addElement(new Radfahrer());
		g1.addElement(new Läufer());
		g1.addElement(new Läufer());
		
		g1.moveTo(25, 25); // Alle elemente der Gruppe werden an die neue Position bewegt
		
		Gruppe g2 = new Gruppe();
		g2.addElement(new Radfahrer());
		g2.addElement(new Läufer());
		g2.addElement(new Läufer());
		
		Gruppe g3 = new Gruppe();
		g3.addElement(g1);
		g3.addElement(g2); // Gruppe von Gruppen
		g3.addElement(new Radfahrer());
		
		
		System.out.println();
		g3.moveTo(100, 100);
		
		// Composite: Eine Gruppe von Elementen lässt sich mit einem Befehl steuern, wie ein eizelnes Element davon
		
		
	}
}
