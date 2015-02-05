package jpa.model.msc;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gruppo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany(mappedBy = "gruppo")
	private Set<Operaio> operai;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Operaio> getOperai() {
		return operai;
	}

	public void setOperai(Set<Operaio> operai) {
		this.operai = operai;
	}
}
