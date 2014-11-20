package jpa.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.model.Utente;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu01");
		EntityManager entityManager = (EntityManager) emf.createEntityManager();

		inserisci(entityManager);
		estrai(entityManager);

		entityManager.close();
		emf.close();
	}

	private static void estrai(EntityManager entityManager) {
		List<Utente> h = entityManager.createQuery("select c from Utente c",
				Utente.class).getResultList();
		for (Utente ut : h) {
			System.out.println(ut);
		}
	}

	private static void inserisci(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		Utente utente0 = new Utente();
		utente0.setNome("ciccioooooo");
		entityManager.persist(utente0);
		entityManager.getTransaction().commit();
	}

}
