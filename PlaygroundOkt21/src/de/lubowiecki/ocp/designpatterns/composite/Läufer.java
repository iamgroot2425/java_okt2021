package de.lubowiecki.ocp.designpatterns.composite;

public class Läufer implements Movable {

	private int x;
	private int y;
	
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Rennt zu der Position " + x + ", " + y);
		
	}

}
