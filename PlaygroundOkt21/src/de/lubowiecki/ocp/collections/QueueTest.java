package de.lubowiecki.ocp.collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	
	public static void main(String[] args) {
		
		Queue<Integer> q1 = new LinkedList<>();
		
		// Fügt ein neues Element am Ende der Warteschlage
		q1.add(10);
		q1.offer(20);
		q1.offer(30);
		q1.offer(40);
		
		System.out.println(q1); // Warteschlange ist gefüllt
		
		while(!q1.isEmpty()) {
			System.out.println(q1.poll()); // Entfernt das nächste Element am Anfang der Warteschlange
			//System.out.println(q1.peek()); // Liefert das Element am Anfang ohne es zu entfernen
		}
		
		System.out.println(q1); // Warteschlange ist leer
		
	}

}
