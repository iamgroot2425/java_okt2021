package de.lubowiecki.ocp.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactionTest {

	public static void main(String[] args) {
		
		
		
		try(Connection dbh = DatabaseUtils.getConnection()) {
			
			Savepoint s1 = null;
			Savepoint s2 = null;
			Savepoint s3 = null;
			Savepoint s4 = null;
			
			try {
			
				dbh.setAutoCommit(false); // Statements werden jetzt nicht mehr sofort an die DB übertragen
				Statement stmt = dbh.createStatement();
				
				// Befehle werden nur ausgeführt, wenn ALLE ausgeführt werden können!
				stmt.execute("INSERT INTO user (id, firstname, lastname) VALUES(NULL, 'Max1', 'Mustermann')");
				s1 = dbh.setSavepoint();
				
				stmt.execute("INSERT INTO user (id, firstname, lastname) VALUES(NULL, 'Max2', 'Mustermann')");
				s2 = dbh.setSavepoint();
				
				stmt.execute("INSERT INTO user (id, firstname, lastname) VALUES(NULL, 'Max3', 'Mustermann')");
				s3 = dbh.setSavepoint();
				
				stmt.execute("INSERT INTO user (id, firstname, las_tname) VALUES(NULL, 'Max4', 'Mustermann')");
				s4 = dbh.setSavepoint();
				
				dbh.commit(); // Alle Befehle werden zusammen übertragen 
				
				System.out.println("Statements abgearbeitet");
			
			}
			catch(SQLException e) {
				System.out.println("Fehler bei abarbeiten der Befehle.");
				
				try {
					dbh.rollback(s3);
					dbh.commit();
				}
				catch(SQLException eSub) {
					System.out.println("Rollback war nicht erfolgreich");
				}
				
			}
			
		}
		catch(SQLException e) {
			System.out.println("Datenbankverbindung konnte nicht aufgebaut werden!");
		}
		
		System.out.println("Programm beendet");
	}

}
