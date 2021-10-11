package de.lubowiecki.ocp.designpatterns.composite;

public class Radfahrer implements Movable {

	private int x;
	private int y;
	
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Fährt zu der Position " + x + ", " + y);
		
	}

}
