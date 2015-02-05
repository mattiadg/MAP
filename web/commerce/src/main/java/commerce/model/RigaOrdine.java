package commerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RigaOrdine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn
	private Articolo articolo;
	private double quantita;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Articolo getArticolo() {
		return articolo;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	public double getQuantita() {
		return quantita;
	}

	public void setQuantita(double quantita) {
		this.quantita = quantita;
	}
}
