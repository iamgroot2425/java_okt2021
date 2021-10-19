package de.lubowiecki.ocp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMapper<T extends AbstractEntity> implements Mapper<T> {

	public final String TABLE;
	
	public AbstractMapper(String table) {
		TABLE = table;
	}
	
	@Override
	public List<T> find() throws SQLException {
		
		try(Connection dbh = DatabaseUtils.getConnection();
				Statement stmt = dbh.createStatement()) {
			
			ResultSet results = stmt.executeQuery("SELECT * FROM " + TABLE); // SQL
			
			List<T> list = new ArrayList<>(results.getFetchSize());
			
			while(results.next()) {
				list.add(create(results));
			}
			
			return list;
		}
	}
	
	@Override
	public boolean save(T obj) throws SQLException {
		
		if(obj.getId() > 0) {
			return update(obj);
		}
		else {
			return insert(obj);
		}
	}
	
	protected abstract boolean insert(T obj) throws SQLException;
	
	protected abstract boolean update(T obj) throws SQLException;
	
	protected abstract T create(ResultSet row) throws SQLException;
}
