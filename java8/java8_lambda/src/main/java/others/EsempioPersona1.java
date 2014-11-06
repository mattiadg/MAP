package others;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EsempioPersona1 {

	public static void main(String[] args) {
		List<Persona> persons = Arrays.asList(new Persona("Marco", 18),
				new Persona("Giovanni", 23), new Persona("Maria", 23),
				new Persona("Antonio", 12));

		t1(persons);
		t2(persons);
		t3(persons);
		t4(persons);
		t5(persons);
		t6(persons);
	}

	private static void t6(List<Persona> persons) {
		Collector<Persona, StringJoiner, String> personNameCollector =
			    Collector.of(
			        () -> new StringJoiner(" | "),          // supplier
			        (j, p) -> j.add(p.nome.toUpperCase()),  // accumulator
			        (j1, j2) -> j1.merge(j2),               // combiner
			        StringJoiner::toString);                // finisher

			String names = persons
			    .stream()
			    .collect(personNameCollector);

			System.out.println(names);
		
	}

	private static void t5(List<Persona> persons) {
		String phrase = persons
			    .stream()
			    .filter(p -> p.eta >= 18)
			    .map(p -> p.nome)
			    .collect(Collectors.joining(" e ", "In Italia ", " sono maggiorenni."));

			System.out.println(phrase);
		
	}

	private static void t4(List<Persona> persons) {
		IntSummaryStatistics ageSummary =
			    persons
			        .stream()
			        .collect(Collectors.summarizingInt(p -> p.eta));

			System.out.println(ageSummary);
	}

	private static void t3(List<Persona> persons) {
		Double averageAge = persons
			    .stream()
			    .collect(Collectors.averagingInt(p -> p.eta));

			System.out.println(averageAge);
	}

	private static void t2(List<Persona> persons) {
		Map<Integer, List<Persona>> personsByAge = persons.stream().collect(
				Collectors.groupingBy(p -> p.eta));

		personsByAge.forEach((eta, p) -> System.out.format("eta %s: %s\n", eta,
				p));
	}

	private static void t1(List<Persona> persons) {
		List<Persona> filtered = persons.stream()
				.filter(p -> p.nome.startsWith("M"))
				.collect(Collectors.toList());

		System.out.println(filtered);
	}

}
