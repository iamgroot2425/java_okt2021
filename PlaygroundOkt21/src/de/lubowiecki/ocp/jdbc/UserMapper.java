package de.lubowiecki.ocp.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper extends AbstractMapper<User> {

	public UserMapper() {
		super("user");
	}
	
	@Override
	public User find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(User obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean insert(User obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean update(User obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected User create(ResultSet row) throws SQLException {
		User u = new User();
		u.setId(row.getInt("id"));
		u.setFirstname(row.getString("firstname"));
		u.setLastname(row.getString("lastname"));
		return u;
	}
}
