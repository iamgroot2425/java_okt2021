package de.lubowiecki.ocp.basics;

public class StringTest {

	public static void main(String[] args) {
		
		String s1 = "A";
		String s2 = "A";
		String s3 = new String("A");
		s1 += "BCDE";
		s1 = s1.concat("...");
		s1 = "A";
		
		"Hallo Welt".toLowerCase();
		
		String[] namen = "Peter, Bruce, Natasha, Tony, Steve".split(", ");
		for (String n : namen) {
			System.out.println(n);
		}
	}

}
