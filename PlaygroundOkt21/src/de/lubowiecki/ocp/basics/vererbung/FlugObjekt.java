package de.lubowiecki.ocp.basics.vererbung;

public interface FlugObjekt {
	
	// Im Interface sind alle Methoden public  
	// und alle Eigenschaften public static final
	
	//int höhe = 10; // automatisch public static final, muss sofort initialisiert werden
	
	void starten(); // ist trotzdem public
	
	public void landen();
	
	public void towerKontaktieren();
	

}
