package jpa.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Utente")
public class Utente {
	private int idUtente;
	private String nome;
	private Ruolo ruolo;
	private List<String> numeri;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne
	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	
	@ElementCollection
	public List<String> getNumeri() {
		return numeri;
	}

	public void setNumeri(List<String> numeri) {
		this.numeri = numeri;
	}

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ","
				+ ruolo.getNome() + "]";
	}

}
