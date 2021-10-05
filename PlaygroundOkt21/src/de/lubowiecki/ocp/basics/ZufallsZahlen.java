package de.lubowiecki.ocp.basics;

import java.util.Random;

public class ZufallsZahlen {
	
	public static void main(String[] args) {
		
		Random rand1 = new Random();
		System.out.println(rand1.nextInt(6) + 1);
		System.out.println(rand1.nextInt(6) + 1);
		System.out.println(rand1.nextInt(6) + 1);
		System.out.println(rand1.nextInt(6) + 1);
		System.out.println(rand1.nextInt(6) + 1);
		System.out.println(rand1.nextInt(6) + 1);
		System.out.println(rand1.nextInt(6) + 1);
		
		System.out.println();
		
		System.out.println((int) (Math.random() * 6) + 1);
		
	}
}
