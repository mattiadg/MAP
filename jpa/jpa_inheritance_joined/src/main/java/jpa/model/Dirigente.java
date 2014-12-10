package jpa.model;

import javax.persistence.Entity;

@Entity
public class Dirigente extends Dipendente {
	private double salarioAccessorio;

	public double getSalarioAccessorio() {
		return salarioAccessorio;
	}

	public void setSalarioAccessorio(double salarioAccessorio) {
		this.salarioAccessorio = salarioAccessorio;
	}

	public Dirigente() {
		super();
	}

	public Dirigente(String matricola, String nome, String cognome,
			double salario) {
		super(matricola, nome, cognome);
		this.salarioAccessorio = salario;
	}

	@Override
	public String toString() {
		return "Dirigente [salarioAccessorio=" + salarioAccessorio + "]";
	}

}
