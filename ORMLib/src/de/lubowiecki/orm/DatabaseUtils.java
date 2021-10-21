package de.lubowiecki.orm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DatabaseUtils {
	
	private static final String HOST;
	private static final String PORT;
	private static final String DB_NAME;
	private static final String DB_USER;
	private static final String DB_PASSWORD;
	public static final boolean DEBUG_MODE;
	private static final String CONF_FILE = "dbconf.xml";
	
	private static final Properties configuration = new Properties();
	
	
	static {
		if(!init()) {
			System.out.println("default config-file created.");
		}
		HOST = configuration.getProperty("host");
		PORT = configuration.getProperty("port");
		DB_NAME = configuration.getProperty("db_name");
		DB_USER = configuration.getProperty("user");
		DB_PASSWORD = configuration.getProperty("password");
		DEBUG_MODE = (configuration.getProperty("debug").equals("true")) ? true : false;
	}
	
	private DatabaseUtils() {
	}
	
	public static Connection getConnection() throws SQLException {
		final String URL = String.format("jdbc:mysql://%s:%s/%s?serverTimezone=UTC&useSSL=false", HOST, PORT, DB_NAME);
		return DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
	}
	
	/**
	 * Liest die DB-Koinfiguration aus einer XML-Datei ein
	 * @return
	 */
	private static boolean init() {
		
		try(InputStream in = new FileInputStream(CONF_FILE)) {
			configuration.loadFromXML(in);
			return true;
		}
		catch(IOException e) {
			createConfFile();
			return false;
		}
	}
	
	/**
	 * Erzeugt eine Default Konfiguration in einer XML-Datei
	 * @return
	 */
	private static boolean createConfFile() {
		
		configuration.put("host", "localhost");
		configuration.put("port", "3306");
		configuration.put("db_name", "dbname");
		configuration.put("user", "root");
		configuration.put("password", "");
		configuration.put("debug", "false");
		
		try(OutputStream out = new FileOutputStream(CONF_FILE)) {
			configuration.storeToXML(out, "");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
