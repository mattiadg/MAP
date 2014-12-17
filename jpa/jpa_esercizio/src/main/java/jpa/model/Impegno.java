package jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Impegno {
	@Embeddable
	public static class Id implements Serializable {
		private static final long serialVersionUID = -3709332337630183333L;
		@Column(name = "idProgetto")
		private int idProgetto;
		@Column(name = "idDipendente")
		private int idDipendente;

		public Id() {
		}

		public Id(int idProgetto, int idDipendente) {
			super();
			this.idProgetto = idProgetto;
			this.idDipendente = idDipendente;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idDipendente;
			result = prime * result + idProgetto;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (idDipendente != other.idDipendente)
				return false;
			if (idProgetto != other.idProgetto)
				return false;
			return true;
		}
	}

	@EmbeddedId
	private Id id = new Id();
	@ManyToOne
	@JoinColumn(name = "idDipendente", insertable = false, updatable = false)
	private Dipendente dipendente;
	@ManyToOne
	@JoinColumn(name = "idProgetto", insertable = false, updatable = false)
	private Progetto progetto;
	private int oreMensili;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public Progetto getProgetto() {
		return progetto;
	}

	public void setProgetto(Progetto progetto) {
		this.progetto = progetto;
	}

	public int getOreMensili() {
		return oreMensili;
	}

	public void setOreMensili(int oreMensili) {
		this.oreMensili = oreMensili;
	}
}
