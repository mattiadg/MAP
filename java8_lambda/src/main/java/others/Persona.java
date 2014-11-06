package others;

public class Persona {
	String nome;
	int eta;

	public Persona(String nome, int eta) {
		this.nome = nome;
		this.eta = eta;
	}

	@Override
	public String toString() {
		return nome;
	}
}