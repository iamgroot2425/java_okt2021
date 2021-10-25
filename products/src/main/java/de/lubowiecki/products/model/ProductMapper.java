package de.lubowiecki.products.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.lubowiecki.orm.AbstractMapper;
import de.lubowiecki.orm.DatabaseUtils;

public class ProductMapper extends AbstractMapper<Product> {

	public ProductMapper() {
		super("products"); // Festlegung der DB-Table
	}

	@Override
	protected Product create(ResultSet rs) throws SQLException {
		// Wandelt SQL-Results in Objekte um
		Product p = new Product();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setPrice(rs.getDouble("price"));
		p.setAvailable(rs.getBoolean("available"));
		return p;
	}

	@Override
	protected boolean insert(Product p) throws SQLException {
		
		final String sql = "INSERT INTO " + TABLE + " (name, price, available) VALUES(?,?,?)";
		
		try(Connection dbh = DatabaseUtils.getConnection();
				PreparedStatement stmt = dbh.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			stmt.setString(1, p.getName());
			stmt.setDouble(2, p.getPrice());
			stmt.setBoolean(3, p.isAvailable());
			
			stmt.execute();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if(ids.next()) {
				p.setId(ids.getInt(1));
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean update(Product p) throws SQLException {
		
		final String sql = "UPDATE " + TABLE + " SET name = ?, price = ?, available = ? WHERE id = ?";
		
		try(Connection dbh = DatabaseUtils.getConnection();
				PreparedStatement stmt = dbh.prepareStatement(sql)) {
			
			stmt.setString(1, p.getName());
			stmt.setDouble(2, p.getPrice());
			stmt.setBoolean(3, p.isAvailable());
			stmt.setInt(4, p.getId());
			
			stmt.execute();
			
			return stmt.getUpdateCount() > 0;
		}
	}
}
