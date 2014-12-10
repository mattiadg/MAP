package jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Dipendente {
	@Id
	private String matricola;
	private String nome;
	private String cognome;

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

	public Dipendente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dipendente(String matricola, String nome, String cognome) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Dipendente [matricola=" + matricola + ", nome=" + nome
				+ ", cognome=" + cognome + "]";
	}
	
	

}
