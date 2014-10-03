package java8_lambda;

import java.util.Arrays;
import java.util.List;

public class Example_03_iterating {
	public static void main(String[] args) {
		
		List<String> features = Arrays.asList("Lambdas", "Default Method",
				"Stream API", "Date and Time API");
		
		
		
		// Prior Java 8
		for (String feature : features) {
			System.out.println(feature);
		}
		
		// In Java 8:
		features.forEach(n -> System.out.println(n));

	}
}
