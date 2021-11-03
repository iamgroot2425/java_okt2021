package de.lubowiecki.aufgaben.rennsimulation;

import java.util.Random;

public class Runner extends Thread {
	
	private int curPos = 0;
	private final int targetPos;
	private final Random randGenerator = new Random();
	
	public Runner(String name) {
		this(name, 100);
	}
	
	public Runner(String name, int targetPos) {
		super(name);
		this.targetPos = targetPos;
	}
	
	@Override
	public void run() {
		
		int steps = 0;
		
		while(curPos < targetPos) {
			steps = randGenerator.nextInt(10) + 1;
			System.out.println(getName() + " bewegt sich von " + curPos + " um " + steps + " weiter");
			curPos += steps;
			
			try {
				Thread.sleep(500);
			} 
			catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(getName() + " hat das Ziel erreicht.");
	}
}
