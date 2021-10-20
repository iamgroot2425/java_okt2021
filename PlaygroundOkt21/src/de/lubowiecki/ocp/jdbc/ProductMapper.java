package de.lubowiecki.ocp.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper extends AbstractMapper<Product> {

	public ProductMapper() {
		super("products");
	}

	@Override
	protected boolean insert(Product obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean update(Product obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Product create(ResultSet row) throws SQLException {
		Product p = new Product();
		p.setId(row.getInt("id"));
		p.setName(row.getString("name"));
		p.setWeight(row.getDouble("weight"));
		p.setDescription(row.getString("description"));
		p.setPrice(row.getDouble("price"));
		return p;
	}
}
