package jpa.model.emb;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Indirizzo {
	@Column(length=30)
	private String via;
	
	private String civico;
	private String citta;

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

}
