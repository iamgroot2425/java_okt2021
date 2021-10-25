package de.lubowiecki.jpastarter;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaTest {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("jpaStarterPU").createEntityManager();
		
		try {
			
			// INSERT
//			Product p = new Product();
//			p.setName("Apfel");
//			p.setPrice(0.59);
//			p.setAvailable(true);
//			
//			
//			em.getTransaction().begin(); // Startet die Transaction
//			em.persist(p);
//			em.getTransaction().commit(); // Überträgt alle Befehle an die DB
			
			// SELECT By ID
//			Product p = em.find(Product.class, 1);
//			p.setName("Mango");
			
			// UPDATE
//			em.getTransaction().begin();
//			em.merge(p);
//			em.getTransaction().commit();
			
			// SELECT ALL			// JPQL arbeitet mit Klassen und Objekten und nicht mit Tabellen
//			List<Product> list = em.createQuery("SELECT p FROM Product p").getResultList();
			
			// Als NAMED_QUERY
			List<Product> list = em.createNamedQuery("Product.findAll").getResultList();
			for(Product pro : list) {
				System.out.println(pro.getName() + ", " + pro.getPrice() + ", " + pro.getId());
			}
			
			System.out.println("ENDE");
			
		}
		finally {
			em.close();
		}

	}

}
