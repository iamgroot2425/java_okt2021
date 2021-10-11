package de.lubowiecki.ocp.basics.vererbung;

public class VererbungTest2 {

	public static void main(String[] args) {
		
		// Abstrakte Klassen können NICHT instanziert werden!
		// Eine abstrakte Klasse ist eine nicht eigenständig funktionierende Grund-Umsetzung einer Klasse
		// AbstractAnimal a1 = new AbstractAnimal();
		
		// Die Kindklassen sind instanzierbar
		// Abstrakte Klasse kann aber immer als Referenztyp oder Attribut-Typ verwendet werden
		
		AbstractAnimal a1 = new Dog(); // Dog IS-A AbstractAnimal
		AbstractAnimal a2 = new Cat(); // Cat IS-A AbstractAnimal
		
		a1.setName("Rex");
		a2.setName("Leo");
		
		System.out.println(a1.getSound());
		System.out.println(a2.getSound());
		
		// Instanzmethoden werden immer auf dem Objekt-Typ (Objekt auf dem Heap ausgeführt)
		// Klassenmethoden (statisch) werden immer auf dem Referenztyp ausgeführt
		
		// Referenztyp			// Objekt-Typ
		AbstractAnimal a3 = new Dog();
		

	}
}
