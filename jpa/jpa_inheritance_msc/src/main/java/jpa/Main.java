package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.model.msc.Dipendente;
import jpa.model.msc.Dirigente;
import jpa.model.msc.Operaio;

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
		Operaio o1 = new Operaio("0003", "Mario", "Verdi", false);
		Dirigente dg1 = new Dirigente("0004", "Enzo", "Li Calzi", 1000);
		entityManager.getTransaction().begin();
		entityManager.persist(o1);
		entityManager.persist(dg1);
		entityManager.getTransaction().commit();
	}
}
