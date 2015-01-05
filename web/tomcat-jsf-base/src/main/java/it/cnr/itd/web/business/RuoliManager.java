package it.cnr.itd.web.business;

import it.cnr.itd.web.model.Ruolo;

import java.util.Collection;

public interface RuoliManager {

	public Collection<Ruolo> getAll();
	public Ruolo getRuolo(Integer id);
}
