package de.lubowiecki.ocp.basics;

import java.time.LocalDate;
import java.util.Date;

public class KonstruktorTest {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		Person p2 = new Person("Peter", "Parker");
		System.out.println(p2.getEmail());
		
		Person p3 = new Person("Bruce");
		
		LocalDate d = LocalDate.now();
		
		p1 = ReplikantenFabrik.get();
		System.out.println(p1);
		
		// Date d2 = new Date();
	}

}
