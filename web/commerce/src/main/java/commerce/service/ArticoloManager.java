package commerce.service;

import java.util.List;

import commerce.model.Articolo;

public interface ArticoloManager {
	public List<Articolo> getAll();

	public void addArticolo(Articolo articolo);

	public void deleteArticolo(Articolo personToDelete);
}
