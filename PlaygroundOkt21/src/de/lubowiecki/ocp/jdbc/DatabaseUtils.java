package de.lubowiecki.ocp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseUtils {
	
	private static final String HOST = "localhost";
	private static final int PORT = 8889;
	private static final String DB_NAME = "jdbc_playground";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	private static final String URL = String.format("jdbc:mysql://%s:%d/%s?serverTimezone=UTC&useSSL=false", HOST, PORT, DB_NAME);
	
	private DatabaseUtils() {
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
	}
}
