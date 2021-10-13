package de.lubowiecki.ocp.basics.exceptions;

public class FinallyTest {

	public static void main(String[] args) {
		
		//machWasAnderes(-110);
		System.out.println(machGanzWasAnderes(-110));
		
	}
	
	public static String machWas(int zahl) throws IllegalArgumentException {
		
		if(zahl < 0)
			throw new IllegalArgumentException("Die Zahl muss positiv sein!");
		
		//System.out.println(zahl % 2 == 1 ? "ungerade" : "gerade");
		return zahl % 2 == 1 ? "ungerade" : "gerade";
	}
	
	public static void machWasAnderes(int zahl) {
		
		try {
			machWas(zahl);
		}
		catch(IllegalArgumentException e) {
			System.out.println("ungültige zahl");
		}
		finally {
			System.out.println("FIN");
		}
	}
	
	public static String machGanzWasAnderes(int zahl) {
		
		try {
			return machWas(zahl);
		}
		catch(IllegalArgumentException e) {
			return "ungültige zahl";
		}
		finally { // Vor dem verlassen der Methode wird das finally IMMER ausgeführt
			System.out.println("FIN");
		}
	}
}
