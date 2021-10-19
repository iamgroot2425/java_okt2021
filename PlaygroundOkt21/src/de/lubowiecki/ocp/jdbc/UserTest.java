package de.lubowiecki.ocp.jdbc;

import java.sql.SQLException;

public class UserTest {

	public static void main(String[] args) {
		
		try {
			Mapper<User> mapper = new UserMapper();
			for(User u : mapper.find()) {
				System.out.println(u.getId() + ", " + u.getFirstname() + " " + u.getLastname());
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
