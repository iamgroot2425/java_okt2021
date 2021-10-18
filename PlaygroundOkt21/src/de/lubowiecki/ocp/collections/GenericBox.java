package de.lubowiecki.ocp.collections;

// Nicht generisch
//public class GenericBox {
//	
//	private final int SIZE;
//	
//	private String[] elements;
//	
//	public GenericBox(int size) {
//		SIZE = size;
//		elements  = new String[SIZE];
//	}
//	
//	public String getFromPos(int pos) {
//		
//		if(pos <= 0 || pos > SIZE) {
//			System.out.println("Position ungültig");
//			return null;
//		}
//		
//		return elements[pos - 1];
//	}
//	
//	public void setToPos(int pos, String s) {
//		
//		if(pos <= 0 || pos > SIZE) {
//			System.out.println("Position ungültig");
//		}
//		else {
//			elements[pos - 1] = s;
//		}
//	}
//}

// Generisch
public class GenericBox<T> { // Alle Klassen sind von Object abgeleitet
	// Wird kein konkreter Typ vorgegeben dann wird Object verwendet
	
	private final int SIZE;
	
	private T[] elements;
	
	public GenericBox(int size) {
		SIZE = size;
		elements  = (T[]) new Object[SIZE];
	}
	
	public T getFromPos(int pos) {
		
		if(pos <= 0 || pos > SIZE) {
			System.out.println("Position ungültig");
			return null;
		}
		
		return elements[pos - 1];
	}
	
	public void setToPos(int pos, T s) {
		
		if(pos <= 0 || pos > SIZE) {
			System.out.println("Position ungültig");
		}
		else {
			elements[pos - 1] = s;
		}
	}
}
