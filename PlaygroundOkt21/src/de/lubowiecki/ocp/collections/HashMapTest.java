package de.lubowiecki.ocp.collections;

import java.util.Map;
import java.util.Scanner;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		Map<String, String> outputs = Lang.DE;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(outputs.get("welcome"));
		
		System.out.print(outputs.get("input_label") + ": ");
		String s = scanner.next();
		
		System.out.println(outputs.get("input") + ": " + s);
		
		System.out.print(outputs.get("end"));
	}

}
