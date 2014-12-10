package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.model.Articolo;
import jpa.model.IdArticolo;
import jpa.model.IdPersona;
import jpa.model.Persona;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu01");
		EntityManager entityManager = (EntityManager) emf.createEntityManager();
		// inserisci persone
		inserisciPersone(entityManager);
		// recupera persona
		Persona pe = entityManager.find(Persona.class, new IdPersona("Rossi",
				"Mario"));
		System.out.println(pe);
		//inserisci articolo
		Articolo p = inserisciArticolo(entityManager);
		// esempio deattach articolo
		recuperaArticolo(entityManager);
		entityManager.close();
		// crea un nuovo em e attach articolo
		entityManager = (EntityManager) emf.createEntityManager();
		entityManager.merge(p);
		entityManager.getTransaction().begin();
		p.setNome("fff");
		entityManager.getTransaction().commit();
		entityManager.close();
		emf.close();
	}

	private static Articolo inserisciArticolo(EntityManager entityManager) {
		Articolo a = new Articolo();
		IdArticolo id = new IdArticolo();
		id.setCodiceProdotto(1);
		id.setCodiceProduttore(1);
		a.setId(id);
		a.setNome("phone");
		entityManager.getTransaction().begin();
		entityManager.persist(a);
		entityManager.getTransaction().commit();
		return a;
	}

	private static Articolo recuperaArticolo(EntityManager entityManager) {
		IdArticolo id = new IdArticolo();
		id.setCodiceProdotto(1);
		id.setCodiceProduttore(1);
		return entityManager.find(Articolo.class, id);
	}

	private static void inserisciPersone(EntityManager entityManager) {
		Persona p1 = new Persona("Rossi", "Mario", 34);
		Persona p2 = new Persona("Rossi", "Alfredo", 46);
		entityManager.getTransaction().begin();
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.getTransaction().commit();
	}
}
