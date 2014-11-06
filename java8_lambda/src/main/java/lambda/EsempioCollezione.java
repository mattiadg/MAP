package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class EsempioCollezione {

	public static void main(String[] args) {
		List<String> nomi = new ArrayList<String>();
		nomi.add("Marco");
		nomi.add("Mario");
		nomi.add("Elisa");
		nomi.add("Giovanni");

		Function<String, String> f = new Function<String, String>() {

			@Override
			public String apply(String t) {

				return t.toUpperCase();
			}
		};

		UnaryOperator<String> f2 = new UnaryOperator<String>() {

			@Override
			public String apply(String t) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		UnaryOperator<String> f3 = (s) -> s.toUpperCase();

		UnaryOperator<String> f4 = (s) -> s.substring(0, 3);

		Function<String, String> f5 = f3.andThen(f4);

		Stream<String> stream = nomi.stream();

		stream.map((s) -> s.toUpperCase())
				.sorted((s1, s2)-> s1.compareTo(s2))
				.forEach((s) -> System.out.println(s));
		
		
		Supplier<String> sa=new Supplier<String> () {

			@Override
			public String get() {
				
				return null;
			}
		};
		
		Stream<String> saaa=Stream.generate(sa);
		
		
		
		
		
		
		

	}

}
