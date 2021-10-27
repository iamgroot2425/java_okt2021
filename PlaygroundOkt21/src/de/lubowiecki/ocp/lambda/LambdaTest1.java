package de.lubowiecki.ocp.lambda;

public class LambdaTest1 {
	
	public static void main(String[] args) {
		
		Machbar m1 = (i) -> i + "";
		machIrgendwas(m1, 1000);
		
		m1 = (i) -> i + "..." + i;
		machIrgendwas(m1, 1000);
		
		// Methodenreferenz ist ein Verweis auf eine Methode, die die abstrakte Methode des Interface implementiert
		m1 = LambdaTest1::convertZahlZuString;
		
		machIrgendwas(LambdaTest1::convertZahlZuString, 1000);
	}
	
	public static void machIrgendwas(Machbar m, int i) {
		System.out.println(m.machWas(i));
	}
	
	public static String convertZahlZuString(int i) {
		return "" + (i * 10);
	}
	
	public static int convertStringZuZahl(String s) {
		return Integer.parseInt(s);
	}
	
	static interface Machbar {
		
		String machWas(int i);
		
	}
}
