package it.cnr.itd.uni2014.spring;

import it.cnr.itd.uni2014.spring.service.CalcolatoreService;
import it.cnr.itd.uni2014.spring.service.DIConfiguration;
import it.cnr.itd.uni2014.spring.service.qualifier.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestMain {
	private CalcolatoreService service;

	@Autowired @Mock
	public void setService(CalcolatoreService svc) {
		this.service = svc;
	}


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		TestMain app = context.getBean(TestMain.class);
		app.processMessage();
		context.close();
	}

	private void processMessage() {
		System.out.println("Benvenuto");
		System.out.println(service.calculate(2, 3));
	}
}
