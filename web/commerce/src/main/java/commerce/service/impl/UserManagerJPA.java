package commerce.service.impl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import commerce.interceptor.Loggami;
import commerce.model.Utente;
import commerce.service.UserManager;

@ApplicationScoped
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
		Utente utente = null;// utenti.get(username);

		return utente;
	}

	@Override
	public void update(Utente utente) {
		// utenti.put(utente.getUsername(), utente);

	}

}
