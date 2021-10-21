package de.lubowiecki.ocp.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.lubowiecki.orm.AbstractMapper;
import de.lubowiecki.orm.DatabaseUtils;

public class UserMapper extends AbstractMapper<User> {

	public UserMapper() {
		super("user");
	}
	
	@Override
	protected User create(ResultSet row) throws SQLException {
		User u = new User();
		u.setId(row.getInt("id"));
		u.setFirstname(row.getString("firstname"));
		u.setLastname(row.getString("lastname"));
		return u;
	}

	@Override
	protected boolean insert(User obj) throws SQLException {
		
		String sql = "INSERT INTO " + TABLE + " (id, firstname, lastname) VALUES(NULL,?,?)"; // Template
		
		try(Connection dbh = DatabaseUtils.getConnection();
				PreparedStatement stmt = dbh.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				// Statement.RETURN_GENERATED_KEYS liefert die autoincrement ID nach dem Speichern
			
			// 1 = erstes ? im Template, 2 = zweites ? im Template
			stmt.setString(1, obj.getFirstname());
			stmt.setString(2, obj.getLastname());
			
			stmt.execute();
			
			// In der DB neu vergebene IDs 
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				obj.setId(rs.getInt(1));
				return true;
			}
			
			return false;
		}
	}

	@Override
	protected boolean update(User obj) throws SQLException {
		
		String sql = "UPDATE " + TABLE + " SET firstname = ?, lastname = ? WHERE id = ?"; // Template
		
		try(Connection dbh = DatabaseUtils.getConnection();
				PreparedStatement stmt = dbh.prepareStatement(sql)) {
			
			stmt.setString(1, obj.getFirstname());
			stmt.setString(2, obj.getLastname());
			stmt.setInt(3, obj.getId());
			
			stmt.execute();
			
			// getUpdateCount() = Anzahl veränderter Datensätze
			return stmt.getUpdateCount() > 0;
		}
	}
}
