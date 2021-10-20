package de.lubowiecki.ocp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.sql.ResultSetMetaData;

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
			
			if(DatabaseUtils.DEBUG_MODE) {
				ResultSetMetaData meta = results.getMetaData();
				System.out.println(meta.getColumnCount());
				System.out.println(meta.getColumnName(1));
				System.out.println(meta.getColumnTypeName(1));
			}
			
			List<T> list = new ArrayList<>(results.getFetchSize());
			
			while(results.next()) {
				list.add(create(results));
			}
			
			return list;
		}
	}
	
	@Override
	public Optional<T> find(int id) throws SQLException {
		
		try(Connection dbh = DatabaseUtils.getConnection();
				Statement stmt = dbh.createStatement()) {
			
			ResultSet results = stmt.executeQuery("SELECT * FROM " + TABLE + " WHERE id = " + id); // SQL
			
			if(results.next()) {
				return Optional.of(create(results));
			}
			
			return Optional.empty();
		}
	}

	@Override
	public boolean delete(T obj) throws SQLException {
		return delete(obj.getId());
	}

	@Override
	public boolean delete(int id) throws SQLException {
		
		try(Connection dbh = DatabaseUtils.getConnection();
				Statement stmt = dbh.createStatement()) {
			
			// num = Anzahl betroffener Datensätze
			int num = stmt.executeUpdate("DELETE FROM " + TABLE + " WHERE id = " + id); // SQL
			
			if(num > 0) {
				return true;
			}
			
			return false;
			
			// vor dem verlassen des try-Blocks werden die Ressourcen geschlossen
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
