package jpa.model.ids;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(IdPersona.class)
public class Persona {
	@Id
	private String cognome;
	@Id
	private String nome;
	private int eta;
	
	

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Persona(String cognome, String nome, int eta) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.eta = eta;
	}



	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}



	@Override
	public String toString() {
		return "Persona [cognome=" + cognome + ", nome=" + nome + ", eta="
				+ eta + "]";
	}
	

}
