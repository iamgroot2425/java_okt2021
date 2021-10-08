package de.lubowiecki.ocp.basics;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Product {
	
	private String name;
	
	private String description;
	
	private double weight;
	
	private double price;

	public Product(String name, String description, double weight, double price) {
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		
//		if(this == obj) // Prüft, ob es das gleiche Objekt auf dem Heap ist
//			return true;
//		
//		if(obj == null) // Vergleich mit null muss immer false zurückliefern
//			return false;
//		
//		if(obj instanceof Product) { // Prüft, es vom gleich Typ ist
//			
//			Product other = (Product) obj;
//			
//			if(this.name.equals(other.name)) { // Prüft, ob die Eigenschaften den gleiche Zustand haben
//				if(this.description.equals(other.description)) {
//					if(this.weight == other.weight) {
//						if(this.price == other.price) {
//							return true;
//						}
//					}
//				}
//			}
//		}
//		
//		return false;
		
		return EqualsBuilder.reflectionEquals(this, obj, "price"); // preis wird für Vergleich nicht benutzt
	}
	
	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((description == null) ? 0 : description.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(price);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		temp = Double.doubleToLongBits(weight);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		return result;
		
		return HashCodeBuilder.reflectionHashCode(this, "price");
	}

	@Override
	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Product [name=");
//		builder.append(name);
//		builder.append(", description=");
//		builder.append(description);
//		builder.append(", weight=");
//		builder.append(weight);
//		builder.append(", price=");
//		builder.append(price);
//		builder.append("]");
//		return builder.toString();
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
		
	}

	
}
