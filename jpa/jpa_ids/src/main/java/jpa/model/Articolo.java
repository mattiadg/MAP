package jpa.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Articolo {
	@EmbeddedId
	private IdArticolo id;
	private String nome;

	public IdArticolo getId() {
		return id;
	}

	public void setId(IdArticolo id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Articolo [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
