package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EsempioCollezione2 {

	public static void main(String[] args)
	{
		
		List<String> nomi = new ArrayList<String>();
		nomi.add("Marco");
		nomi.add("Mario");
		nomi.add("Elisa");
		nomi.add("Giovanni");
		
		
		Predicate<String> p=(s)->s.length()==5;
		
		Predicate<String> p1=(s)->s.startsWith("M");
		
		Predicate<String> p3 = p.and(p1);
		
		
		/*
		nomi.stream()
			.filter(p3)
			.forEach(System.out::println);
		*/
		
		nomi.stream()
		
		.forEach(System.out::println);
		
	}
}
