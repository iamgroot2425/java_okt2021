package de.lubowiecki.aufgaben.uebung7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class Cal {
	
	private final TreeSet<Termin> dates = new TreeSet<>();
	
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("d.M.yyyy");
	public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:m");
	
	public List<Termin> findForDate(LocalDate date) {
		return findForDate(date, date.plusDays(1));
	}
	
	public List<Termin> findForDate(LocalDate start, LocalDate end) {
		Termin from = new Termin();
		from.setDate(LocalDateTime.of(start, LocalTime.MIN)); // 0 Uhr am gewünschten Tag
		
		Termin to = new Termin();
		to.setDate(LocalDateTime.of(end, LocalTime.MIN)); // 0 Uhr am nächsten Tag
		
		return new ArrayList<>(dates.subSet(from, to));
	}
	
	public List<Termin> getAll() {
		return new ArrayList<>(dates);
	}
	
	public Termin findNext() {
		Termin t = new Termin();
		t.setDate(LocalDateTime.now());
		return dates.higher(t); // Liefert den nächsten Termin
	}
	
	public void showAll() {
		showAll(dates);
	}
	
	public void showAll(Collection<Termin> coll) {
		for (Termin date : coll) {
			showTermin(date);
		}
	}
	
	public void showTermin(Termin termin) {
		System.out.println(termin.getDate().toLocalDate().format(DATE_FORMATTER));
		System.out.println(termin.getDate().toLocalTime().format(TIME_FORMATTER));
		System.out.println(termin.getTitle());
		System.out.println(termin.getDescription());
		System.out.println();
	}
	
	public boolean add(Termin termin) {
		return dates.add(termin);
	}
	
	public boolean remove(Termin termin) {
		return dates.remove(termin);
	}
}
