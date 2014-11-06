package others;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Esempio4 {

	public static void main(String[] args) {
		Arrays.
			stream(new int[] { 1, 2, 3 })
			.map(n -> 2 * n + 1)
			.average()
			.ifPresent(System.out::println);
		
		IntStream.range(1, 4)
	    	.mapToObj(i -> "a" + i)	    	
	    	.forEach(System.out::println);

	}

}
