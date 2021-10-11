package de.lubowiecki.ocp.basics.vererbung;

public class VererbungTest3 {
	
	public static void main(String[] args) {
		
		// Interfaces können nicht instanziert werden
		//FlugObjekt f1 = new FlugObjekt();
		
		// Referenvariablen vom Typ des Interface können mit Obkten
		// implementierender Klassen belegt werden
		FlugObjekt f2 = new JumboJet();
		f2 = new Sportflugzeug();
		f2 = new Ente();
		
		f2.starten(); // starten des JumboJets wird verwendet
		
		
		System.out.println();
		f2.landen();
		
		
	}
	
	
	
	

}
