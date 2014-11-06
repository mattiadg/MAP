package others;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Foo {
	String nome;
	List<Bar> bars = new ArrayList<>();

	Foo(String nome) {
		this.nome = nome;
	}
}

class Bar {
	String nome;

	Bar(String nome) {
		this.nome = nome;
	}
}

public class EsempioFlat {

	public static void main(String[] args) {
		t1();
		t2();
	}

	private static void t1() {
		List<Foo> foos = new ArrayList<>();

		// create foos
		IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));

		// create bars
		foos.forEach(f -> IntStream.range(1, 4).forEach(
				i -> f.bars.add(new Bar("Bar" + i + " di " + f.nome))));

		foos.stream().flatMap(f -> f.bars.stream())
				.forEach(b -> System.out.println(b.nome));
	}

	private static void t2() {
		IntStream.range(1, 4)
	    .mapToObj(i -> new Foo("Foo" + i))
	    .peek(f -> IntStream.range(1, 4)
	        .mapToObj(i -> new Bar("Bar" + i + " di " + f.nome))
	        .forEach(f.bars::add))
	    .flatMap(f -> f.bars.stream())
	    .forEach(b -> System.out.println(b.nome));
		
	}
}
