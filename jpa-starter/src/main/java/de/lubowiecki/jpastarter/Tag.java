package de.lubowiecki.jpastarter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 20, unique = true)
	private String label;
	
	@ManyToMany
	private Set<Product> products = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
		
		if(!product.getTags().contains(this))
			product.addTag(this);
	}
}
