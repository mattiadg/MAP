package java8_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example_08_fun_list {
	public static void main(String[] args) {
		// Convert String to Uppercase and join them using coma
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
				"Italy", "U.K.", "Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase())
				.collect(Collectors.joining(", "));
		System.out.println(G7Countries);
	}
}
