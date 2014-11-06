package java8_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example_07_list_by_filter {
	public static void main(String[] args) {
		List<String> strList = Arrays.asList("Java", "Scala", "C++", "Haskell",
				"Lisp", "ba");
		// Create a List with String more than 2 characters
		List<String> filtered = strList.stream().filter(x -> x.length() > 2)
				.collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strList,
				filtered);
	}
}
