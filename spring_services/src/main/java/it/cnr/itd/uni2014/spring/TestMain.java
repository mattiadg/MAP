package it.cnr.itd.uni2014.spring;

import it.cnr.itd.uni2014.spring.service.CalcolatoreService;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMain {
	


	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
 
		CalcolatoreService service = (CalcolatoreService) context
				.getBean("calculatorService");
		System.out.println("Benvenuto");
		System.out.println(service.calculate(2, 3));
		context.close();
		
	}

	
}
