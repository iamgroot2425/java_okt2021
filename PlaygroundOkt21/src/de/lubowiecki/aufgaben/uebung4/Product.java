package de.lubowiecki.aufgaben.uebung4;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Serializable bedeutet, dass das Objekt in Datein geschrieben werden kann
public class Product implements Serializable {
	
	private String name;
	private double weight;
	private int count;
	private double price;
	
	public Product(String name, double weight, int count, double price) {
		this.name = name;
		this.weight = weight;
		this.count = count;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}
}
