package it.cnr.itd.web.business;

import it.cnr.itd.web.model.Utente;

public interface UtentiManager {

	public Utente check(String username, String password);
	
	public void update(Utente utente);
}