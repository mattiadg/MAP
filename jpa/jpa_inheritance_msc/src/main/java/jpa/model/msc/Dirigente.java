package jpa.model.msc;

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
		// TODO Auto-generated constructor stub
	}

	public Dirigente(String matricola, String nome, String cognome,
			double salario) {
		super(matricola, nome, cognome);
		this.salarioAccessorio = salario;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dirigente [salarioAccessorio=" + salarioAccessorio + "]";
	}

}
