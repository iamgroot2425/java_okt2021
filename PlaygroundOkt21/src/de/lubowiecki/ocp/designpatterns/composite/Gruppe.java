package de.lubowiecki.ocp.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

// Composite
public class Gruppe implements Movable {
	
	private final List<Movable> elemente = new ArrayList<>();
	
	public void addElement(Movable m) {
		elemente.add(m);
	}
	
	public void removeElement(Movable m) {
		elemente.remove(m);
		
	}

	@Override
	public void moveTo(int x, int y) {
		for (Movable m : elemente) {
			m.moveTo(x, y);
		}
	}
}
