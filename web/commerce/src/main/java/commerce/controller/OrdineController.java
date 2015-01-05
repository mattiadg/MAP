package commerce.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import commerce.model.Ordine;
import commerce.service.OrdineManager;

@SessionScoped
@Named("ordineController")
public class OrdineController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Ordine current = new Ordine ();

	private ListDataModel<Ordine> ordini = new ListDataModel<Ordine>();

	@Inject
	private OrdineManager pm;

	

	public Ordine getCurrent() {
		return current;
	}

	public void setCurrent(Ordine current) {
		this.current = current;
	}

	public ListDataModel<Ordine> getAll() {
		ordini.setWrappedData(pm.getAll());
		return ordini;
	}

	public String addOrdine() {
		pm.add(current);
		return "showOrdini";

	}

	public String deletePerson() {
		Ordine personToDelete = ordini.getRowData();
		pm.delete(personToDelete);
		return null;
	}
	
	public void addArticolo()
	{
		
	}

	
}
