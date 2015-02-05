package it.cnr.itd.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

@Entity
public class Utente {

	private String username;
	private String name;
	private String password;
	private String email;
	private String telefono;
	private int eta;
	private Ruolo ruolo;

	public Utente() {
	}

	public Utente(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}

	@Id
	public String getUsername() {
		return username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length=20)
	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Min(14)
	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	@ManyToOne
	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	

}
