package de.lubowiecki.ocp.jdbc;

import java.sql.SQLException;
import java.util.Optional;

import de.lubowiecki.orm.Mapper;

public class UserTest {

	public static void main(String[] args) {
		
		try {
			Mapper<User> mapper = new UserMapper();
			
//			User u = new User();
//			u.setFirstname("Tony");
//			u.setLastname("Stark");
			
			Optional<User> uo = mapper.find(30);
			if(uo.isPresent()) {
				User u = uo.get();
				u.setFirstname("Carol");
				if(mapper.save(u)) {
					System.out.println("User wurde geändert!");
				}
			}
			
			
//			if(mapper.save(u)) {
//				System.out.println("User wurde gespeichert! ID:" + u.getId());
//			}

//			Optional<User> opt = mapper.find(2); // Fragt einen User nach seiner id ab
//			if(opt.isPresent()) {
//				User u = opt.get();
//				System.out.println(u.getId() + ", " + u.getFirstname() + " " + u.getLastname());
//				
//				mapper.delete(u); // Löscht einen Unser
//			}
			
			for(User u2 : mapper.find()) { // Fragt alle User ab
				System.out.println(u2.getId() + ", " + u2.getFirstname() + " " + u2.getLastname());
			}
			
		} 
		catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
