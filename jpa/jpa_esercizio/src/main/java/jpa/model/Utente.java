package jpa.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Utente")
public class Utente {
	private int idUtente;
	private String nome;
	private List<String> numeri;
	private Long version;

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

	@ElementCollection
	public List<String> getNumeri() {
		return numeri;
	}

	public void setNumeri(List<String> numeri) {
		this.numeri = numeri;
	}

	@Version
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", numeri="
				+ numeri + ", version=" + version + "]";
	}

}
