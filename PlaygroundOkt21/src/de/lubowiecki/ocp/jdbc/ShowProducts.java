package de.lubowiecki.ocp.jdbc;

import java.sql.SQLException;

public class ShowProducts {

	public static void main(String[] args) {
		
		try {
		
			Mapper<Product> mapper = new ProductMapper();
			for(Product p : mapper.find()) {
				System.out.println(p.getId());
				System.out.println(p.getName());
				System.out.println(p.getDescription());
				System.out.println(p.getWeight());
				System.out.println(p.getPrice());
				System.out.println();
			}
		
		}
		catch (SQLException e) {
			System.out.println("Los problemos!");
		}

	}

}
