package jpa.model.msc;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Dipendente {
	@Id
	private String matricola;
	private String nome;
	private String cognome;

	public Dipendente() {
		super();
	}

	public Dipendente(String matricola, String nome, String cognome) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Dipendente [matricola=" + matricola + ", nome=" + nome
				+ ", cognome=" + cognome + "]";
	}
}
