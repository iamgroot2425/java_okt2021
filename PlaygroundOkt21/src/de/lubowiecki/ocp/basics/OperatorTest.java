package de.lubowiecki.ocp.basics;

public class OperatorTest {
	
	public static void main(String[] args) {
		
		System.out.println("1" + 2 * 3);
		
		int i = 10;
		int j = i++;
		// i = 11
		// j = 10
		
		i = 10;
		j = ++i;
		// i = 11
		// j = 11
		
		i = 10;
		
		    //10 + 11 + 13
		j = i++ + i++ + ++i;
		System.out.println(j);
		System.out.println(i);
		
		System.out.println(10 % 5); // 0
		System.out.println(5 % 10); // 5
		
		j += 10 + 15;
		
		// Zuweisungsoperatoren und zusammengesetzte Zuweisungsoperatoren haben die niedrigste Prio
		
		System.out.println(8 & 12);
		// 00001000 &
		// 00001100
		//Erg 00001000
		
		
		//String s = null;
		String s = "exit";
		
//		if(s != null & s.equals("exit")) { // beide Teile der Anweisung werden IMMER ausgeführt
//			System.out.println("EXIT");
//		}
		
		// Short-Circuite Operatoren werden nur solange verarbeitet, bis ein Ergebnis feststeht
		if(s != null && s.equals("exit")) { // der zweite Teile der Anweisung wird nur ausgeführt, wenn der erste Teil true ergibt
			System.out.println("EXIT");
		}
		
		// instanceof prüft, ob eine IS-A Beziehung besteht
		// Die Identität des Objektes auf dem Heap ist relevant
		
		Object o = s;
		
		System.out.println(o instanceof Number);
		System.out.println(o instanceof String);
		
		System.out.println('a' + 'b'); // werden vor dem rechnen in int konvertiert
		System.out.println(1 + 'b'); // werden vor dem rechnen in int konvertiert
		
//		System.out.println(10++); // 10 = 10 + 1
//		//10 += 1; // 10 = 10 + 1
		
		
	}

}
