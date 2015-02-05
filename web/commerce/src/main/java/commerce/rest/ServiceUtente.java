package commerce.rest;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import commerce.model.Utente;

@Stateless
@Path("utente")
public class ServiceUtente {
	@PersistenceContext(unitName = "pu01")
	EntityManager em;

	@GET
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utente getUtente(@PathParam("id") int id) {
		Utente u = em.find(Utente.class, id);
		return u;
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crea(Utente utente) {

		em.persist(utente);
	}
	/*
	 * public Utente get(int id) { Utente u=em.find(Utente.class, id); return u;
	 * }
	 */

}
