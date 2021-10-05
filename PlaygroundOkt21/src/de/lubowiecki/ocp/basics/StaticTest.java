package de.lubowiecki.ocp.basics;

public class StaticTest {

	public static void main(String[] args) {
		
		// Statische Methoden werden auf dem Bauplan aufgerufen
		
		//doSomething(); // Instanzmethoden brauchen ein Objekt
		
		// doSomething(); ist in wirklichkeit ein Aufruf von this.doSomething();
		// this = dieses Objekt
		// this.doSomething(); // this ist in statischen Methoden nicht verfügbar
		
		// Objekt wurde erzeugt und jetzt kann die Instanzmethode aufgerufen werden
		new StaticTest().doSomething();
		
		StaticTest st = new StaticTest();
		st.doSomething();

		doStaticSomething(); // Klassenmethoden können direkt aufgerufen werden
	}
	
	public String doSomething() {
		return "Moin!";
	}
	
	public static String doStaticSomething() {
		return "Moin Moin!";
	}

}
