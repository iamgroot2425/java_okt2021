package de.lubowiecki.ocp.basics;

public class KontrollstrukturenTest {

	public static void main(String[] args) {
		
		String welcome;
		
		boolean de = false;
		
		// WENN
		if(de) {
			// DANN
			welcome = "Willkommen";
		}
		else {
			// SONST
			welcome = "Welcome";
		}
				// WENN  // DANN		// SONST
		welcome = (de) ? "Willkommen" : "Welcome";
		
		System.out.println(welcome);
		
		
		// Aufgabe
		int time = 11;
		int day = 4;
						// WENN     // DANN						     //SONST
		String dinner = time > 10 ? day == 4 ? "Takeout" : "Salad" : "Leftovers";

	}

}
