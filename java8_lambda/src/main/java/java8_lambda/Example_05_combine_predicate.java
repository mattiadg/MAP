package java8_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Example_05_combine_predicate {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Java", "Scala", "C++", "Haskell",
				"Lisp");
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		
		Predicate<String> a = startsWithJ.and(fourLetterLong);
		
		names.stream()
				.filter(a)
				.forEach(
						(n) -> System.out
								.print("\nName, which starts with 'J' and four letter long is : "
										+ n));
	}
}
