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
			
//			ProductGroup g = new ProductGroup();
//			g.setName("Obst");
//			g.setDescription("Alles was Obst ist!");
//
//			em.getTransaction().begin(); // Startet die Transaction
//			em.persist(p);
//			em.persist(g);
//			
//			g.addProduct(p);
//			
//			em.getTransaction().commit(); // Überträgt alle Befehle an die DB
			
			// SELECT By ID
			Product p = em.find(Product.class, 1);
			
//			Tag t1 = new Tag();
//			t1.setLabel("Süß");
//			
//			Tag t2 = new Tag();
//			t2.setLabel("Frisch");
//			
//			em.getTransaction().begin();
//			em.persist(t1);
//			em.persist(t2);
//			
//			p.addTag(t1);
//			p.addTag(t2);
//			
//			em.getTransaction().commit();
			
			System.out.println(p.getStatus());
			//p.setStatus(Status.OK);
			
//			for (Tag t : p.getTags()) {
//				System.out.println(t.getLabel());
//			}
			
			
//			ProductGroup g = em.find(ProductGroup.class, 2);
//			for (Product p : g.getProducts()) {
//				System.out.println(p.getName());
//			}
			
			// UPDATE
//			em.getTransaction().begin();
//			em.merge(p);
//			em.getTransaction().commit();
			
			// SELECT ALL			// JPQL arbeitet mit Klassen und Objekten und nicht mit Tabellen
//			List<Product> list = em.createQuery("SELECT p FROM Product p").getResultList();
			
			// Als NAMED_QUERY
//			List<Product> list = em.createNamedQuery("Product.findAll").getResultList();
//			for(Product pro : list) {
//				System.out.println(pro.getName() + ", " + pro.getPrice() + ", " + pro.getId());
//			}
//			
//			System.out.println("ENDE");
			
		}
		finally {
			em.close();
		}

	}

}
