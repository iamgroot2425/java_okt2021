package de.lubowiecki.ocp.collections;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import de.lubowiecki.aufgaben.uebung7.Termin;

public class TreeMapTest {
	
	public static void main(String[] args) {
		
		Map<String, List<String>> namen = new HashMap<>();
		
		namen.put("A", Arrays.asList("Alex", "Anna", "Arthur", "Anton"));
		namen.put("C", Arrays.asList("Carol", "Christin", "Carla", "Chris"));
		namen.put("D", Arrays.asList("Dora", "Don", "Dia"));
		
		System.out.println(namen);
		
		System.out.println(namen.get("D"));
		
		System.out.println();
		
		
		Map<LocalDate, List<Termin>> cal = new TreeMap<>();
		
		cal.put(LocalDate.now(), new ArrayList<>());
		cal.put(LocalDate.now().plusDays(1), new ArrayList<>());
		cal.put(LocalDate.now().plusDays(2), new ArrayList<>());
		cal.put(LocalDate.now().plusDays(3), new ArrayList<>());
		cal.put(LocalDate.now().plusDays(4), new ArrayList<>());
		cal.put(LocalDate.now().plusDays(5), new ArrayList<>());
		cal.put(LocalDate.now().plusDays(6), new ArrayList<>());
		
		cal.get(LocalDate.now()).add(new Termin("Essen mit Peter", "Beim Asia-King"));
		
		LocalDate in3Tagen = LocalDate.now().plusDays(3);
		cal.get(in3Tagen).add(new Termin(LocalDateTime.of(in3Tagen, LocalTime.now()), "Sport", "In der Urban-Gym..."));
		cal.get(in3Tagen).add(new Termin(LocalDateTime.of(in3Tagen, LocalTime.now()), "Essen mit Carol", "Bei SoHo-Chicken"));
		
		for(LocalDate key : cal.keySet()) {
			List<Termin> termine = cal.get(key);
			System.out.println(termine);
		}
		
		
	}

}
