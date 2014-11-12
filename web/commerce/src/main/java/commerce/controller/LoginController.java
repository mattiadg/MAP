package commerce.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import commerce.model.Credenziali;
import commerce.model.Utente;
import commerce.service.UserManager;

@Named
@SessionScoped
public class LoginController implements Serializable {
	@Inject
	UserManager manager;
	@Inject
	Credenziali credenziali;
	private Utente utenteCorrente;

	public void login()
	{
		Utente utente=manager.checkLogin(credenziali.getUsername(), 
				credenziali.getPassword());
		if (utente!=null)
		{
			utenteCorrente=utente;
		}
	}
	
	public void logout()
	{
		utenteCorrente=null;
	}
	
	public boolean isLogged()
	{
		return utenteCorrente!=null;
	}

	public Utente getUtenteCorrente() {
		return utenteCorrente;
	}
	
	public String aggiorna()
	{
		manager.update(utenteCorrente);
		return "viewUser";
	}
	
}
