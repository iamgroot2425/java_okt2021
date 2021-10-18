package de.lubowiecki.ocp.collections;

public class ClassWithGenericMethod {
	
	//Nicht Generic Method
//	public static double convert(Number n) {
//		return n.doubleValue();
//	}
	
	// Generic Method
	// <T> genericher Platzhalter, muss vor dem Rückgabetyp vorgestellt werden
	// extends Number = generischer Typ muss eine Kindklasse von Number sein
	public static <T extends Number> double convert(T n) {
		return n.doubleValue();
	}
	

}
