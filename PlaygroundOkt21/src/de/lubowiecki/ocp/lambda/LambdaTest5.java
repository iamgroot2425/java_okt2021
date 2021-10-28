package de.lubowiecki.ocp.lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class LambdaTest5 {
	
	public static void main(String[] args) {
		
		Function<Integer, Integer> f1 = (i) -> i + 15;
		f1.apply(17); // 32
		
		// ist von Function abgeleitet
		UnaryOperator<Integer> f2 = (i) -> i + 15;
		f1.apply(17); // 32
		
		Function<Integer, Double> f3 = (i) -> i.doubleValue() + 15;
		f1.apply(17); // 32.0
		
	}

}
