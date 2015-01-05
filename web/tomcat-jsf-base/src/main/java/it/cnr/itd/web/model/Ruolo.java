package it.cnr.itd.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ruolo {
	private int id;
	private String nome;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Ruolo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ruolo(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	

}
