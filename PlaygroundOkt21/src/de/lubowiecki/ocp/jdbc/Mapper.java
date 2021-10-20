package de.lubowiecki.ocp.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Mapper<T> {
	
	public List<T> find() throws SQLException;
	
	public Optional<T> find(int id) throws SQLException;
	
	public boolean save(T obj) throws SQLException;
	
	public boolean delete(T obj) throws SQLException;
	
	public boolean delete(int id) throws SQLException;
}
