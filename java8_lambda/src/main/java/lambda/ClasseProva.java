package lambda;

public class ClasseProva {
	private String nome;
	
	public ClasseProva(String nome) {
		super();
		this.nome = nome;
	}
	

	public String getNome() {
		return nome;
	}


	public void elaboraNome(Servizio s)
	{
		nome=s.elabora(nome);
	}

}
