package de.lubowiecki.aufgaben.uebung4;

import java.time.LocalDate;

public class PerishableProduct extends Product {

	private LocalDate expiryDate;
	
	public PerishableProduct() {
	}
	
	public PerishableProduct(String name, double weight, int count, double price, LocalDate expiryDate) {
		super(name, weight, count, price);
		this.expiryDate = expiryDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
}
