package de.lubowiecki.ocp.streams;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Termin {
	
	private LocalDateTime zeitpunkt;
	
	private String text;
	
	private Typ typ;
	
	public Termin() {
	}
	
	public Termin(LocalDateTime zeitpunkt, String text, Typ typ) {
		this.zeitpunkt = zeitpunkt;
		this.text = text;
		this.typ = typ;
	}

	public LocalDateTime getZeitpunkt() {
		return zeitpunkt;
	}

	public void setZeitpunkt(LocalDateTime zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Typ getTyp() {
		return typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}

	public static enum Typ {
		PRIVAT, GESCHÄFTLICH, UNBEKANNT;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE) + "\n";
	}
}
