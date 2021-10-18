package de.lubowiecki.ocp.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMethodTest {
	
	
	public static void main(String[] args) {
		
		List<Integer> ints = new ArrayList<>(Arrays.asList(2,4,6,8,10,12,22,18,1,7,3,5));
		
		// int[] intArr = ints.toArray(); // Liefert ein Array von Object
		Object[] intArr = ints.toArray();
		
		Number[] arr = {};
		Number[] intArr2 = ints.toArray(arr); // Der Typ von arr wird ermittelt und als RückgabeTyp verwendet
		
		System.out.println();
		
		double d = ClassWithGenericMethod.convert(1000); // Parameter (1000) muss eine Kindklasse von Number sein 
		System.out.println(d);
		
		
	}

}
