package de.lubowiecki.ocp.basics.vererbung;

import java.awt.Point;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Fahrzeug {
	
	private Point position; // Point enthält x und y Positionen
	
	private String kennzeichen;
	
	// Hier wird alles eingebaut, was ALLE Fahrzeuge gemeinsam haben
	
	public Fahrzeug() {
		position = new Point();
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	public void setPosition(int x, int y) {
		this.position.x = x;
		this.position.y = y;
	}
	

	public String getKennzeichen() {
		return kennzeichen;
	}

	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
		super.toString(); // Aufruf von toString von der Elternklasse (Object)
		toString(); // oder this.toString() ist ein Aufruf von toString aus dieser Klasse
	}
	
	@Override // Überschreibt die toString-Methode von Object
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
