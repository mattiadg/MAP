package it.cnr.itd.web;

import it.cnr.itd.web.business.UtentiManager;
import it.cnr.itd.web.model.Credentials;
import it.cnr.itd.web.model.Utente;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class Login implements Serializable {

	private static final long serialVersionUID = 7965455427888195913L;

	@Inject
	private Credentials credentials;
	@Inject
	private UtentiManager manager;

	private Utente currentUser;

	public void login() {
		Utente u = manager.check(credentials.getUsername(),
				credentials.getPassword());
		if (u != null) {
			currentUser = u;
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Welcome, " + currentUser.getName()));
		} else {
			/*
			 * FacesContext.getCurrentInstance().addMessage( "login", new
			 * FacesMessage(FacesMessage.SEVERITY_ERROR, "Welcome, " +
			 * currentUser.getName(), ""));
			 */
		}

	}

	public void logout() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Goodbye, " + currentUser.getName()));
		currentUser = null;
	}

	public boolean isLoggedIn() {
		return currentUser != null;
	}

	@Produces
	@LoggedIn
	public Utente getCurrentUser() {
		return currentUser;
	}

	public void checkLoggedIn(ComponentSystemEvent event) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) ctx
				.getApplication().getNavigationHandler();

		// navigate to login-screen
		if (this.currentUser == null) {
			nav.performNavigation("home");
		} 
	}
	
	public String aggiornaDati()
	{
		manager.update(currentUser);
		return "viewUser";
	}

}
