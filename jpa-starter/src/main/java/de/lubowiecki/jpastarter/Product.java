package de.lubowiecki.jpastarter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "products") // Name der Tabelle. Standard: Tabellenname == Klassenname
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product {
	
	@Id // Primary-Key
	@GeneratedValue // Auto-Increment
	private int id;
	
	@Column(length = 50) // Konfiguration der Spalte in der DB
	private String name;
	
	private double price;
	
	private boolean available;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
}
