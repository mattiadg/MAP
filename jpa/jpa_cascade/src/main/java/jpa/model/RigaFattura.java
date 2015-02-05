package jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;

@Entity
public class RigaFattura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String articolo;
	private int quantita;
	@ManyToOne
	@JoinColumn(name = "id_fattura")
	
	private Fattura fattura;

	public RigaFattura() {
		super();
	}

	public RigaFattura(String articolo, int quantita) {
		super();
		this.articolo = articolo;
		this.quantita = quantita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticolo() {
		return articolo;
	}

	public void setArticolo(String articolo) {
		this.articolo = articolo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Fattura getFattura() {
		return fattura;
	}

	public void setFattura(Fattura fattura) {
		this.fattura = fattura;
	}
	
	
}
