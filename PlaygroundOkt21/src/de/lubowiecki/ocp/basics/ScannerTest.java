package de.lubowiecki.ocp.basics;

import java.util.Scanner;

public class ScannerTest {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("Eingabe: ");
		String input = scanner.next();
		String[] steps = input.split("");
		
		for (String step: steps) {
			System.out.println(step);
		}
		
		

	}

}
