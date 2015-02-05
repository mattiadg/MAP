package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.model.Dipendente;
import jpa.model.Dirigente;
import jpa.model.Operaio;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu01");
		EntityManager entityManager = (EntityManager) emf.createEntityManager();
		insertDipendenti(entityManager);
		estraiDipendenti(entityManager);
		entityManager.close();
		emf.close();
	}

	private static void estraiDipendenti(EntityManager entityManager) {
		List<Operaio> l = entityManager.createQuery("from Operaio",
				Operaio.class).getResultList();
		for (Dipendente d : l)
			System.out.println(d);
	}

	private static void insertDipendenti(EntityManager entityManager) {
		Dipendente d1 = new Dipendente("0001", "Mario", "Rossi");
		Dipendente d2 = new Dipendente("0002", "Giuseppe", "Bianchi");
		Operaio o1 = new Operaio("0003", "Mario", "Verdi", false);
		Dirigente dg1 = new Dirigente("0004", "Enzo", "Li Calzi", 1000);
		entityManager.getTransaction().begin();
		entityManager.persist(d1);
		entityManager.persist(d2);
		entityManager.persist(o1);
		entityManager.persist(dg1);
		entityManager.getTransaction().commit();
	}
}