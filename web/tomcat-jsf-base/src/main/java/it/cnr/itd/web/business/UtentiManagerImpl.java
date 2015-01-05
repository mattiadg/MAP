package it.cnr.itd.web.business;

import it.cnr.itd.web.model.Utente;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class UtentiManagerImpl implements Serializable, UtentiManager {
	private Map<String, Utente> utenti = new HashMap<>();


	
	@PostConstruct
	private void popola() {
		utenti.put("admin", new Utente("admin", "admin", "password"));
		utenti.put("ciccio", new Utente("ciccio", "ciccio", "password"));
	}

	@Override
	public Utente check(String username, String password) {
		Utente u = utenti.get(username);
		if ((u != null) & (password.equals(u.getPassword())))
			return u;
		return null;

	}

	@Override
	public void update(Utente utente) {

		utenti.put(utente.getUsername(), utente);

	}

}
