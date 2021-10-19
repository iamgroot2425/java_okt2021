package de.lubowiecki.ocp.jdbc;

import java.sql.SQLException;
import java.util.List;

public interface Mapper<T> {
	
	public List<T> find() throws SQLException;
	
	public T find(int id) throws SQLException;
	
	public boolean save(T obj) throws SQLException;
	
	public boolean delete(T obj) throws SQLException;
	
	public boolean delete(int id) throws SQLException;
}
