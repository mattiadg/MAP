package commerce.service;

import commerce.model.Utente;

public interface UserManager {
	
	public Utente checkLogin(String username,String password);

	public void update(Utente utenteCorrente);
	
	public void popola2();

}
