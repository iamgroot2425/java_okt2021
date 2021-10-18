package de.lubowiecki.ocp.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> ints = new PriorityQueue<>();
		ints.addAll(Arrays.asList(3,7,9,22,11,8,15,1,3,5)); // Fügt alle Elemente mit einer Aktion ein
		
		// Ab Java 9
		//List<Integer> zahlen =  List.of(1,2,7,9,22,18);
		
		// Ab Java 8, arbeitet mit Lambdas
		//ints.forEach(e -> System.out.println(e)); // Nicht für Queues optimiert 
		
		while(!ints.isEmpty()) {
			System.out.println(ints.poll());
		}
		
		System.out.println();
		
		// Stack
		
		LinkedList<String> stack = new LinkedList<>();
		stack.push("Montag"); // Legt ein neues Element auf den Stapel (LIFO)
		stack.push("Dienstag");
		stack.push("Mittwoch");
		stack.push("Donnerstag");
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop()); // Entfernt das letzte Element auf dem Stapel
		}
		
		System.out.println();
		
		Queue<String> stack2 = Collections.asLifoQueue(new LinkedList<>()); // Queue die wie ein Stack funktioniert
		stack2.offer("Montag");
		stack2.offer("Dienstag");
		stack2.offer("Mittwoch");
		stack2.offer("Donnerstag");
		
		while(!stack2.isEmpty()) {
			System.out.println(stack2.poll());
		}
		
	}

}
