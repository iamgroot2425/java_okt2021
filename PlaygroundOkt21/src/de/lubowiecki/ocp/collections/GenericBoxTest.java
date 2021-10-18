package de.lubowiecki.ocp.collections;

public class GenericBoxTest {
	
	public static void main(String[] args) {
		
		GenericBox<String> box = new GenericBox<>(3); // Box für max 3 Elemente 
		box.setToPos(1, "Peter");
		box.setToPos(3, "Carol");
		box.setToPos(8, "Tony");
		box.setToPos(8, (String) "Tony");
		
		System.out.println(box.getFromPos(1));
		System.out.println(box.getFromPos(2));
		System.out.println(box.getFromPos(15));
		System.out.println((String) box.getFromPos(15));
		
		GenericBox<Integer> intBox = new GenericBox<>(10); // Box für max 10 Elemente 
		intBox.setToPos(1, 10);
		intBox.setToPos(2, 20);
		intBox.setToPos(3, 30);
		
		intBox.setToPos(3, (Integer)30);
		
		System.out.println(intBox.getFromPos(1) + intBox.getFromPos(2) + intBox.getFromPos(3));
		
		System.out.println((Integer) intBox.getFromPos(3));
		
		System.out.println();
		
		GenericBox box2 = new GenericBox(2); // Raw-Type, Generischer Typ ist automatisch Object
		
		
	}

}
