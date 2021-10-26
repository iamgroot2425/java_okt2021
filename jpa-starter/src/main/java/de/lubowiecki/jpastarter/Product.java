package de.lubowiecki.jpastarter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "products") // Name der Tabelle. Standard: Tabellenname == Klassenname
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product {
	
	@Id // Primary-Key
	@GeneratedValue
	private int id;
	
	@Column(length = 50) // Konfiguration der Spalte in der DB
	private String name;
	
	private double price;
	
	private boolean available;
	
	@ManyToOne
	private ProductGroup group;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.OK;
	
	@ManyToMany(mappedBy = "products")
	private Set<Tag> tags = new HashSet<>();
	
	public Set<Tag> getTags() {
		return tags;
	}

	public void addTag(Tag tag) {
		this.tags.add(tag);
		
		if(!tag.getProducts().contains(this))
			tag.addProduct(this);
	}

	public ProductGroup getGroup() {
		return group;
	}
	
	public void setGroup(ProductGroup group) {
		this.group = group;
	}
	
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
