package de.lubowiecki.ocp.basics.exceptions;

import java.io.IOException;

public class ExceptionTest1 {
	
	public static void main(String[] args) {
		
		// handle or declare
		// Behandlung liegt in der Verantwortung des Kompilers
		
		try { // versuche diese code auszuführen
			machWas(); // sollte hier tatsächlich eine exception geworfen werden...
		} 
		catch (Exception e) { //... dann fange sie hiermit
			//e.printStackTrace(); //... und behandle sie hier
			System.out.println(e.getMessage());
		}
		
		System.out.println("Hallo Exception");
		
		try {
			machWasAnderes(); // Behandlung liegt in der Verantwortung des Entwicklers9
		}
		catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Hallo RuntimeException");
		
		System.out.println();
		
		try {
			String s = null;
			System.out.println(s.toLowerCase()); // NullPointerException
		}
		catch(NullPointerException e) {
			System.out.println("Der String ist eine NULL");
		}
	}
	
	// throws Exception = hier könnte eine Exception geworfen werden
	public static void machWas() throws Exception { // chacked
		throw new Exception("Ckecked..."); // Exception wird geworfen
	}
	
	public static void machWasAnderes() throws RuntimeException { // unchecked
		throw new RuntimeException("Unckecked...");
	}
	
	public static void machWasGanzAnderes() throws Exception /* declare */ {
		// handle = try-catch, muss  noch im gleichen Block erfolgen
		// declare = throws an den Methodennamen, try-catch muss vom Aufrufer der Methode bereitgestellt werden
		throw new Exception("Ckecked...");
	}

}
