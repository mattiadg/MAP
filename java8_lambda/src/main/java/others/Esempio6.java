package others;

import java.util.stream.Stream;

public class Esempio6 {

	public static void main(String[] args) {
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s ->
			{
				System.out.println("filter: " + s);
				return true;
			});
/*
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s ->
			{
				System.out.println("filter: " + s);
				return true;
			}).forEach(s -> System.out.println("forEach: " + s));
	*/
	}

}
