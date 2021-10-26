package de.lubowiecki.jpastarter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class ProductGroup {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 100)
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy = "group")
	private Set<Product> products = new HashSet<>();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
		product.setGroup(this);
	}
}
