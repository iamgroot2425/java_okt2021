package de.lubowiecki.ocp.threads;

public class ThreadTest1 {
	
	public static void main(String[] args) {
		
		
		new Thread().start(); // läuft parallel aber macht nichts, daher sinnlos
		
		// Runnable: void run();
		// Thread.currentThread() liefert eine Referenz auf den Thread, der diese Zeile gerade ausführt
		new Thread(() -> System.out.println(Thread.currentThread().getName() + ": läuft parallel..."), "Carol").start();
		
		Thread t2 = new Thread(() -> System.out.println(Thread.currentThread().getName() + ": läuft parallel..."));
		t2.setName("Peter");
		t2.start();
		
		new CustomThread("Steve").start();
		
		new Thread(new CustomRunnable(), "Natasha").start();
		
		System.out.println(Thread.currentThread().getName() + ": läuft parallel...");
		
		// anonyme Klasse, die von Thread erbt
		Thread t3 = new Thread() {
			public void run() {
				System.out.println(getName() + ": läuft parallel...");
			};
		};
		
		t3.setName("Tony");
		t3.start();
		
		// anonyme Klasse, die Runnable implementiert
		Runnable aufgabe = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + ": läuft parallel...");
			}
		};
		
		Thread t4 = new Thread(aufgabe);
		t4.start();
		
		// start-Methode erzeugt einen parallelen Task und startet darin die run-Methode
		
	}
}

// Überschreiben von rum in einer von Thread abgeleiteten Klasse 
class CustomThread extends Thread {
	
	public CustomThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(getName() + ": läuft parallel...");
	}
}

// Definition einer Aufgabe durch implementieren von Runnable
class CustomRunnable implements Runnable {
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": läuft parallel...");
	}
}

