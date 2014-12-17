package jpa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Progetto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@ManyToOne
	@JoinColumn
	private Ditta ditta;
	@ManyToOne
	@JoinColumn
	private Dirigente responsabile;
	@OneToMany(mappedBy = "progetto")
	private Set<Impegno> impegniProgetto;

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

	public Ditta getDitta() {
		return ditta;
	}

	public void setDitta(Ditta ditta) {
		this.ditta = ditta;
	}

	public Dirigente getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(Dirigente responsabile) {
		this.responsabile = responsabile;
	}

	public Set<Impegno> getImpegniProgetto() {
		return impegniProgetto;
	}

	public void setImpegniProgetto(Set<Impegno> impegniProgetto) {
		this.impegniProgetto = impegniProgetto;
	}
}
