package de.lubowiecki.ocp.lambda;

public interface NumberChecker<T extends Number> {
	
	boolean check(T t);

}
