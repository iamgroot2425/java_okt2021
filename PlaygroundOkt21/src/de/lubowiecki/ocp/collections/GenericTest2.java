package de.lubowiecki.ocp.collections;

// T extends Number bedeutet T muss eine Kindklasse von Number sein
public class GenericTest2<T extends Number> {

	public static void main(String[] args) {
		
		GenericTest2<Byte> gt2 = new GenericTest2<>();
		gt2.machWas((byte)10, (byte)15);
	}
	
	// T wird nach dem Kompilieren durch den Bound (Number) ersetzt
	public void machWas(T a, T b) {
		System.out.println(a.doubleValue() + b.doubleValue());
	}
}
