package commerce.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import commerce.model.Utente;
import commerce.service.UserManager;

@ApplicationScoped
public class UserManagerHashTable implements UserManager,Serializable {
	Map<String,Utente> utenti=new HashMap<>();
	

	@PostConstruct
	private void popola()
	{
		utenti.put("admin", new Utente("admin","password"));
		utenti.put("ciccio", new Utente("ciccio","password"));
	}
	
	@Override
	public Utente checkLogin(String username, String password) {
		Utente utente = utenti.get(username);
		
		return utente;
	}

	@Override
	public void update(Utente utente) {
		utenti.put(utente.getUsername(), utente);
		
	}

}
