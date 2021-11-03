package de.lubowiecki.ocp.threads;

public class ThreadsAbbrechen {
	
	public static void main(String[] args) {
		
		Runnable aufgabe = () -> {
			
			while(true) {
				if(Thread.currentThread().isInterrupted())
					break;
				
				System.out.println("Start: Moin!");
				System.out.println("End: Moin!");
			}
			
		};
		
		Thread t1 = new Thread(aufgabe);
		t1.start();
		
		try {
			Thread.sleep(2000); // main-Thread wartet mind. 5 Sek
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// t1.stop(); // sollte nicht mehr benutzt werden
		t1.interrupt();
		
	}

}
