package jpa.model;

import static javax.persistence.CascadeType.ALL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Fattura {
	@Id
	private int id;
	@OneToMany(mappedBy = "fattura", cascade = ALL,fetch=FetchType.LAZY)
	@OrderColumn(name = "id_riga")
	private List<RigaFattura> righe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<RigaFattura> getRighe() {
		return righe;
	}

	public void setRighe(List<RigaFattura> righe) {
		this.righe = righe;
	}

	public void addRiga(RigaFattura riga) {
		if (this.righe == null)
			this.righe = new ArrayList<>();
		riga.setFattura(this);
		this.righe.add(riga);
		
	}

	@Override
	public String toString() {
		return "Fattura [id=" + id + ", righe=" + righe + ", getRighe()="
				+ getRighe() + "]";
	}
	
	
}

