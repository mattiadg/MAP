package commerce.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import commerce.model.Ordine;
import commerce.service.OrdineManager;

@Stateless
public class OrdineManagerJPA implements OrdineManager, Serializable {
	@PersistenceContext(unitName = "pu01")
	EntityManager em;

	@Override
	public List<Ordine> getAll() {
		return em.createQuery("from Ordine a").getResultList();
	}

	@Override
	public void add(Ordine articolo) {
		em.persist(articolo);
	}

	@Override
	public void delete(Ordine articolo) {
		em.remove(articolo);
	}

	@Override
	public Ordine get(Integer valueOf) {
		return em.find(Ordine.class, valueOf);
	}
}
