package de.lubowiecki.ocp.basics;

public class PolyTest {

	public static void main(String[] args) {
		
		Person p = new Person();
		Object o = p;
		
		Object[] arr = new Object[3];
		
		arr[0] = p;
		arr[1] = "String";
		arr[2] = 2; // int autoboxing Integer, Integer wird zu Object gewidet
		
		int i = 10;
		Integer j = i; // AutoBoxing, primitiv wird zu komplex
		i = j; // AutoUnBoxing, komplex wird zu primitiv
	}
	
}
