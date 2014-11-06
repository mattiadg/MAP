package others;

import java.util.Arrays;
import java.util.List;

public class EsempioPersonaReduce {

	public static void main(String[] args) {
		List<Persona> persone = Arrays.asList(new Persona("Marco", 18),
				new Persona("Giovanni", 23), new Persona("Maria", 23),
				new Persona("Antonio", 12));

		t1(persone);
		t2(persone);
		t3(persone);
		t4(persone);
	}

	private static void t1(List<Persona> persone) {
		persone.stream().reduce((p1, p2) -> p1.eta > p2.eta ? p1 : p2)
				.ifPresent(System.out::println);

	}

	private static void t2(List<Persona> persone) {
		Persona result = persone.stream().reduce(new Persona("", 0),
				(p1, p2) ->
					{
						p1.eta += p2.eta;
						p1.nome += p2.nome;
						return p1;
					});

		System.out.format("nome=%s; eta=%s", result.nome, result.eta);
	}

	private static void t3(List<Persona> persone) {
		Integer ageSum = persone.stream().reduce(0, (sum, p) -> sum += p.eta,
				(sum1, sum2) -> sum1 + sum2);

		System.out.println(ageSum); // 76
	}

	private static void t4(List<Persona> persone) {

		Integer ageSum = persone.stream().reduce(0, (sum, p) ->
			{
				System.out.format("accumulator: sum=%s; persona=%s\n", sum, p);
				return sum += p.eta;
			}, (sum1, sum2) ->
			{
				System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
				return sum1 + sum2;
			});
	}
}
