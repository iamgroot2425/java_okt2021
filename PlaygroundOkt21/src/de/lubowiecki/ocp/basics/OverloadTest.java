package de.lubowiecki.ocp.basics;

public class OverloadTest {
	
	public static void main(String[] args) {
		new OverloadTest().init();
	}

	private void init() {
		byte b = 1;
		doSomething(b);
		
		doSomething(1);
		
		// Falls keine passende Methode vorhanden ist, wird der wert als erstes primitiv gewidet
		// Wenn nichts passendes gefunden wurde, wird der Wert zum Wrapper-Typ geboxt
		// Bei Wrapper-Typen gibt es kein widening zum höheren Zahlentyp, sondern nur zur Elternklasse
		// VarArg
		// Kompilererror
	}

	private void doSomething(byte i) {
		System.out.println("byte");
	}
	
	private void doSomething(int i) {
		System.out.println("int");
	}
	
	// Wrappertyp
	private void doSomething(Integer i) {
		System.out.println("Integer");
	}
	
	// Wrappertyp
	private void doSomething(Long i) {
		System.out.println("Long");
	}
	
	private void doSomething(Number i) {
		System.out.println("Number");
	}
	
	private void doSomething(long i) {
		System.out.println("long");
	}
	
	private void doSomething(double i) {
		System.out.println("double");
	}
	
	private void doSomething(int... i) {
		System.out.println("int VarArg");
	}
	

}
