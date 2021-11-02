package de.lubowiecki.ocp.streams;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import de.lubowiecki.ocp.streams.Termin.Typ;

public class GroupingByTest {

	public static void main(String[] args) {
		
		List<Termin> termine = new ArrayList<>();
		termine.add(new Termin(LocalDateTime.of(LocalDate.now(), LocalTime.NOON), "Bespreechung bei Oracle", Typ.GESCHÄFTLICH));
		termine.add(new Termin(LocalDateTime.of(LocalDate.now(), LocalTime.NOON), "Essen mit Carol", Typ.PRIVAT));
		termine.add(new Termin(LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 33)), "Essen mit Bill G.", Typ.GESCHÄFTLICH));
		termine.add(new Termin(LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 0)), "Kinder von der Kita abholen", Typ.PRIVAT));
		termine.add(new Termin(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(15, 0)), "Verkauf der Facebook Aktien", Typ.GESCHÄFTLICH));
		termine.add(new Termin(LocalDateTime.of(LocalDate.now().plusDays(7), LocalTime.NOON), "Kauf der Google Aktien", Typ.GESCHÄFTLICH));
		termine.add(new Termin(LocalDateTime.of(LocalDate.now().plusDays(7), LocalTime.MIDNIGHT), "UFO Landung beobachten", Typ.UNBEKANNT));
		termine.add(new Termin(LocalDateTime.of(LocalDate.now().plusDays(14), LocalTime.of(18, 15)), "Freigabe der Designs", Typ.GESCHÄFTLICH));
		
		System.out.println(termine);
		
		System.out.println("--- GROUPING_BY ---");
		
		// Gruppierung erfolgt nach Typ
		Map<Typ, List<Termin>> map1 = termine.stream().collect(Collectors.groupingBy(Termin::getTyp));
		// System.out.println(map1); // liefert die ganze map zurück
		System.out.println(map1.get(Typ.GESCHÄFTLICH)); // liefert nur Geschäfts-Termine zurück
		
		
		System.out.println("--- PARTITIONING_BY ---");
		// partitioningBy erwartet ein Predicate
		// liefert zwei Gruppen. Eine entsprecht dem Predicate, die andere nicht
		Predicate<Termin> pred1 = t -> t.getZeitpunkt().toLocalDate().isAfter(LocalDate.of(2021, 11, 5));
		Map<Boolean, List<Termin>> map2 = termine.stream().collect(Collectors.partitioningBy(pred1));
		//System.out.println(map2);
		System.out.println(map2.get(Boolean.TRUE));

	}

}
