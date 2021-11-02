package de.lubowiecki.ocp.threads;

public class SleepTest {

	public static void main(String[] args) {
		
		System.out.println("START");
		
		new Thread(() -> {
			
			for(int i = 0; i < 20; i++) {
				System.out.println(i);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		System.out.println("ENDE");
		
		// das Programm endet, wenn alle Threads ihre Aufgabe abgearbeitet haben
	}

}
