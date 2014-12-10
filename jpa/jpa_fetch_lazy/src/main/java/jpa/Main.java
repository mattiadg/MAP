package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.model.Fattura;
import jpa.model.RigaFattura;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu01");
		EntityManager entityManager = (EntityManager) emf.createEntityManager();
		// inserisci(entityManager);
		Fattura t = estrai(entityManager);
		//System.out.println(t);
		entityManager.close();
		//System.out.println(t);
		emf.close();
	}

	private static Fattura estrai(EntityManager entityManager) {
		return entityManager.find(Fattura.class, 1);
	}

	private static void inserisci(EntityManager entityManager) {
		Fattura f = new Fattura();
		f.setId(1);
		RigaFattura r1 = new RigaFattura("pane", 10);
		RigaFattura r2 = new RigaFattura("mela", 20);
		RigaFattura r3 = new RigaFattura("riso", 14);
		f.addRiga(r1);
		f.addRiga(r2);
		f.addRiga(r3);
		entityManager.getTransaction().begin();
		entityManager.persist(f);
		entityManager.getTransaction().commit();
	}
}
