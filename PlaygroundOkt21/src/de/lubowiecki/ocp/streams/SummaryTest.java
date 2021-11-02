package de.lubowiecki.ocp.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class SummaryTest {

	public static void main(String[] args) {
		
		int[] zahlen = {2,17,22,13,7,18,100,25,29,15,1,2,5,9,102,18,17};
		
		IntStream stream = Arrays.stream(zahlen);
		System.out.println(stream.sum());
		//System.out.println(stream.average()); // Fehler: Stream ist bereits verbraucht
		
		System.out.println();
		
		// Lösung: Nur für  int, long und double verfügbar
		stream = Arrays.stream(zahlen);
		IntSummaryStatistics stats = stream.summaryStatistics();
		System.out.println("Anzahl: " + stats.getCount());
		System.out.println("Summe: " + stats.getSum());
		System.out.println("Durchsch.: " + stats.getAverage());
		System.out.println("Min: " + stats.getMin());
		System.out.println("Max: " + stats.getMax());
	}

}
