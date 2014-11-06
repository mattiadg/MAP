package lambda;

public class EsempioLambda {

	public static void main(String[] args)
	{
		ClasseProva o=new ClasseProva("mimmo");
		
		System.out.println(o.getNome());
		
		o.elaboraNome((n)->n.toUpperCase());
		
		System.out.println(o.getNome());
	}
}
