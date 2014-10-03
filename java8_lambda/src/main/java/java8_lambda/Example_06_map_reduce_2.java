package java8_lambda;

import java.util.Arrays;
import java.util.List;

public class Example_06_map_reduce_2 {
	public static void main(String[] args) {
		// Applying 12% VAT on each purchase
		// Old way:
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			total = total + price;
		}
		System.out.println("Total : " + total); // New way:
		double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost)
				.reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);
	}
}
