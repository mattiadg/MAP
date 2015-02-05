package commerce.service.impl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import commerce.interceptor.Loggami;
import commerce.model.Utente;
import commerce.service.UserManager;

@Stateless
public class UserManagerJPA implements UserManager, Serializable {
	@PersistenceContext(unitName = "pu01")
	EntityManager em;

	@PostConstruct
	private void popola() {
	}

	@Loggami
	public void popola2() {
		Utente u = new Utente();
		u.setNome("admin");
		u.setPassword("admin");
		u.setUsername("admin");
		em.persist(u);
	}

	@Override
	public Utente checkLogin(String username, String password) {
		Utente utente = null;
		try {
			utente = em
					.createQuery(
							"from Utente u where u.username=? and u.password=?",
							Utente.class).setParameter(1, username)
					.setParameter(2, password).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return utente;
	}

	@Override
	public void update(Utente utente) {
		// utenti.put(utente.getUsername(), utente);
	}
}
