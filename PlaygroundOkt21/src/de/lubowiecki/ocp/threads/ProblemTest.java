package de.lubowiecki.ocp.threads;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProblemTest {
	
	private int i = 0;
	
	//private volatile int i = 0; // Variable wird nach jeder änedrung vom Thread sofort upgedated
	
	private final String LOCK = "Moin"; // Es darf ein beliebiges Objekt sein
	
	private final ReentrantLock R_LOCK = new ReentrantLock(true); // Spezielles Lock-Objekt
	
	// Ein Lock mit zwei TeilLocks fürs gleichzeitige Lesen und Schreiben
	private final ReentrantReadWriteLock RW_LOCK = new ReentrantReadWriteLock(true);
	
	public static void main(String[] args) {
		new ProblemTest().start();
	}

	private void start() {
		
		long start = System.currentTimeMillis();
		
		Runnable aufgabe = () -> {
			for(int j = 0; j < 100; j++) {
				increment();
			}
		};
		
		//System.out.println(Thread.currentThread().getName());
		
		Thread t1 = new Thread(aufgabe);
		Thread t2 = new Thread(aufgabe);
		Thread t3 = new Thread(aufgabe);
		Thread t4 = new Thread(aufgabe);
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			// join: der aktuell laufende Thread wartet, bis der Thread,
			// auf dem join aufgerufen wurde seine run-Methode beendet
			t1.join(); // main wartet auf t1
			t2.join(); // main wartet auf t2
			t3.join(); // main wartet auf t3
			t4.join(); // main wartet auf t4
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(i);
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start + "ms");
		
	}
	
//  Nur ein Thread zur Zeit darf die Methode ausführen. Nach dem increment wird das globale i upgedated	
//	public synchronized void increment() {
//		System.out.println(Thread.currentThread().getName());
//		i += 1;
//	}
	
	public void increment() {
		// Diese Zeile kann von den Threads parallel ausgeführt werden
		System.out.println(Thread.currentThread().getName());
		
		// Hier müssen sie die Threads synchronisieren d.h. es läuft immer nur einer zur Zeit diesen Block durch
//		synchronized(LOCK) { // Synchronisierung betrifft nur die Variablenänderung
//			i += 1;
//		}
		
		try {
			// Holt den Lock, so dass die Zeilen danach nur von EINEM Thread gleichzeitig bearbeitet werden
			//R_LOCK.lock();
			RW_LOCK.writeLock().lock(); // Sperrt den Schreiblock
			i += 1;
		}
		finally {
			// Gibt den Lock frei, so dass ein anderer Thread ihn benutzen kann
			//R_LOCK.unlock();
			RW_LOCK.writeLock().unlock(); // gibt den WriteLock frei
		}
	}
	
	public void decrement() {
		try {
			R_LOCK.lock(); 
			i -= 1;
		}
		finally {
			R_LOCK.unlock();
		}
	}
	
	public int getI() {
		try {
			//R_LOCK.lock(); 
			RW_LOCK.readLock().lock(); 
			return i;
		}
		finally {
			// R_LOCK.unlock();
			RW_LOCK.readLock().unlock(); 
		}
	}
}
