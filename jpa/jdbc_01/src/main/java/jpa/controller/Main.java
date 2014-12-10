package jpa.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.model.Utente;
import jpa.model.msc.Dipendente;
import jpa.model.msc.Dirigente;
import jpa.model.msc.Operaio;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu01");
		EntityManager entityManager = (EntityManager) emf.createEntityManager();

		
		Dipendente d1=new Dipendente("0001","Mario","Rossi");
		Dipendente d2=new Dipendente("0002","Giuseppe","Bianchi");
		Operaio o1=new Operaio("0003","Mario","Verdi",false);
		Dirigente dg1=new Dirigente("0004","Enzo","Li Calzi",1000);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(d1);
		entityManager.persist(d2);
		entityManager.persist(o1);
		entityManager.persist(dg1);
		
		entityManager.getTransaction().commit();
		
		
		/*
		List<Operaio> l = entityManager.createQuery("from Operaio", Operaio.class).getResultList();
		
		
		for (Dipendente d:l)
			System.out.println(d);
		
		entityManager.find(Dipendente.class, "0003");
		*/
		
		
		
		/*
		Persona p1=new Persona("Rossi","Mario",34);
		Persona p2=new Persona("Rossi","Alfredo",46);
		
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(p1);
		entityManager.persist(p2);
		
		entityManager.getTransaction().commit();
		*/
		
		//Articolo a=new Articolo();
		/*IdArticolo id=new IdArticolo();
		id.setCodiceProdotto(1);
		id.setCodiceProduttore(1);
		//a.setId(id);
		//a.setNome("phone");
		
		
		entityManager.getTransaction().begin();
		
		Articolo p=entityManager.find(Articolo.class,id);
		System.out.println(p);
		
		p.setNome("ciao");
		
		entityManager.getTransaction().commit();
		
		
		p.setNome("miao");
		
		entityManager.close();
		
		//-----------------
		
		
		entityManager = (EntityManager) emf.createEntityManager();
		
		entityManager.merge(p);
		
		entityManager.getTransaction().begin();
		
		p.setNome("fff");
		
		entityManager.getTransaction().commit();
		
		
		/*
		Persona p = entityManager.find(Persona.class, new IdPersona("Rossi","Mario"));
		
		System.out.println(p);
		*/
		//inserisci(entityManager);
		//estrai(entityManager);

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
