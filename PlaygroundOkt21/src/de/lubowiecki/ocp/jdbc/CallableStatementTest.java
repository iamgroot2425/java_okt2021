package de.lubowiecki.ocp.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.lubowiecki.orm.DatabaseUtils;

public class CallableStatementTest {

	public static void main(String[] args) {

		// SQL für die Prozedur
		// CREATE PROCEDURE `usersStartsWith`(IN `str` VARCHAR(10) CHARSET utf8) NOT DETERMINISTIC CONTAINS SQL SQL SECURITY DEFINER 
		// SELECT * FROM user WHERE user.firstname LIKE str
		
		// usersStartsWith ist als Prozedur in der DB definiert
		String query = "{ call usersStartsWith(?) }"; // Ruft eine Prozedur, die in der DB definiert ist auf
		
		try(Connection dbh = DatabaseUtils.getConnection();
				CallableStatement stmt = dbh.prepareCall(query)) {
			
			stmt.setString(1, "M%"); // Marbeitsparameter werden übergeben
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("firstname"));
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
