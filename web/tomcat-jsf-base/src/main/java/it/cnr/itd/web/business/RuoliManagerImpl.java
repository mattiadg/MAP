package it.cnr.itd.web.business;

import it.cnr.itd.web.model.Ruolo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
@Named("ruoli")
public class RuoliManagerImpl implements RuoliManager,Serializable {
	Map<Integer,Ruolo> ruoli=new HashMap<>();
	
	@PersistenceContext
    private EntityManager entityManager;
	

	
	@PostConstruct
	private void popola()
	{
		ruoli.put(1,new Ruolo(1,"amministratore"));
		ruoli.put(2,new Ruolo(2,"utente"));
	}

	@Override
	public Collection<Ruolo> getAll() {
		return ruoli.values();
	}

	@Override
	public Ruolo getRuolo(Integer id) {
		// TODO Auto-generated method stub
		return ruoli.get(id);
	}
}
