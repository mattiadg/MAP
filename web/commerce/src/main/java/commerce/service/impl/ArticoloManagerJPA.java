package commerce.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import commerce.model.Articolo;
import commerce.service.ArticoloManager;

@Stateless
public class ArticoloManagerJPA implements ArticoloManager, Serializable {
	@PersistenceContext(unitName = "pu01")
	EntityManager em;

	@Override
	public List<Articolo> getAll() {
		return em.createQuery("from Articolo a").getResultList();
	}

	@Override
	public void addArticolo(Articolo articolo) {
		em.persist(articolo);
	}

	@Override
	public void deleteArticolo(Articolo articolo) {
		em.remove(articolo);
	}

	@Override
	public Articolo get(Integer valueOf) {
		return em.find(Articolo.class, valueOf);
	}
}
