package jpa.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Operaio extends Dipendente {
	private boolean turnista;
	@ManyToOne
	@JoinColumn
	private Gruppo gruppo;

	public Operaio() {
		super();
	}

	public Operaio(String matricola, String nome, String cognome, boolean turno) {
		super(matricola, nome, cognome);
		this.turnista = turno;
	}

	public boolean isTurnista() {
		return turnista;
	}

	public void setTurnista(boolean turnista) {
		this.turnista = turnista;
	}

	@Override
	public String toString() {
		return "Operaio [turnista=" + turnista + "]";
	}

}
