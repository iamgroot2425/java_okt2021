package de.lubowiecki.aufgaben.rennsimulation;

public class App {

	public static void main(String[] args) {
		
		for(int i = 0; i < 3;) {
			System.out.println(++i);
			
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Das Rennen beginnt.");
		
		new Runner("Carol").start();
		new Runner("Peter").start();
		new Runner("Steve").start();

	}

}
