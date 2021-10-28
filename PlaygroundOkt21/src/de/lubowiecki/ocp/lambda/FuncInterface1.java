package de.lubowiecki.ocp.lambda;

// SAM
// Single Abstract Method
@FunctionalInterface // Prüft, ob das Interface wirklich ein FunctionalInterface/SAM ist
public interface FuncInterface1 {
	
	// Methoden im Interface sind immer public
	void machWas(int i);
	
	// Ein FunctionalInterface DARF NUR EINE abstrakte Methode haben
	//void machWasAnderes(String s);
	
}
