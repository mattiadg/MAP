package jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.model.Utente;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu01");
		EntityManager entityManager = (EntityManager) emf.createEntityManager();
		Utente utenteCorrente = null;
		Scanner s = new Scanner(System.in);
		int comando = 0;
		while (comando != 6) {
			System.out.println("1) Inserisci utente");
			System.out.println("2) Recupera Utente");
			System.out.println("3) Modifica Nome");
			System.out.println("4) Lista utenti");
			System.out.println("5) Stampa corrente");
			System.out.println("6) Esci");
			System.out.print("Scegli:");
			comando = s.nextInt();
			switch (comando) {
			case 1:
				String nuovoNome = s.next();
				entityManager.getTransaction().begin();
				Utente utente0 = new Utente();
				utente0.setNome(nuovoNome);
				entityManager.persist(utente0);
				entityManager.getTransaction().commit();
				break;
			case 2:
				System.out.print("inserisci id:");
				int id = s.nextInt();
				utenteCorrente = entityManager.find(Utente.class, id);
				break;
			case 3:
				if (utenteCorrente != null) {
					entityManager.getTransaction().begin();
					nuovoNome = s.next();
					utenteCorrente.setNome(nuovoNome);
					entityManager.getTransaction().commit();
				} else
					System.out.println("Nessun utente in memoria");
				break;
			case 4:
				for (Utente u : entityManager.createQuery("from Utente",
						Utente.class).getResultList())
					System.out.println(u);
				break;
			case 5:
				System.out.println(utenteCorrente);
				break;
			}
		}
		s.close();
		entityManager.close();
		emf.close();
	}
}
