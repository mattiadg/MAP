package commerce.service;

import java.util.List;

import commerce.model.Ordine;

public interface OrdineManager {

	public List<Ordine> getAll();

	public void add(Ordine current);

	public void delete(Ordine personToDelete);

	public Ordine get(Integer valueOf);
}
