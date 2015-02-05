package commerce.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import commerce.model.Articolo;
import commerce.service.ArticoloManager;

@SessionScoped
@Named("articoloController")
public class ArticoloController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Articolo current = new Articolo();

	private ListDataModel<Articolo> articoli = new ListDataModel<Articolo>();

	@Inject
	private ArticoloManager pm;

	

	public Articolo getCurrent() {
		return current;
	}

	public void setCurrent(Articolo current) {
		this.current = current;
	}

	public ListDataModel<Articolo> getAll() {
		articoli.setWrappedData(pm.getAll());
		return articoli;
	}

	public String addArticolo() {
		pm.addArticolo(current);
		return "showArticoli";

	}

	public String deletePerson() {
		Articolo personToDelete = articoli.getRowData();
		pm.deleteArticolo(personToDelete);
		return null;
	}

	
}
