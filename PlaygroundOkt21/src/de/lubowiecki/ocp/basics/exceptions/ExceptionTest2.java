package de.lubowiecki.ocp.basics.exceptions;

public class ExceptionTest2 {

	public static void main(String[] args) {
		
		int wert = -100;
		
		try {
			System.out.println(checkWert(wert)); // wen hier eine Exception autaucht, wird der try-block sofort abgebrochen
			System.out.println("Code nach dem Aufruf der Methode...");
		}
		catch(ZuGrossException e) {
			System.out.println("Behandlung von zu großen Werten...");
			System.out.println(e.getMessage());
		}
		catch(ZuKleinException e) {
			System.out.println("Behandlung von zu kleinen Werten...");
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean checkWert(int wert) throws ZuGrossException, ZuKleinException {
		
		if(wert > 1000) {
			throw new ZuGrossException();
		}
		else if(wert < 0) {
			throw new ZuKleinException();
		}
		else {
			return true;
		}
	}
	
	
}
