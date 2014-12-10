package jpa.model.emb;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity
public class Studente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Indirizzo indirizzo;
	@AttributeOverrides({
			@AttributeOverride(name = "via", column = @Column(name = "via_domicilio",length=40)),
			@AttributeOverride(name = "civico", column = @Column(name = "civico_domicilio")),
			@AttributeOverride(name = "citta", column = @Column(name = "citta_domicilio"))
	})
	private Indirizzo domicilio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

}
