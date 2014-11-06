package it.cnr.itd.uni2014.weld;

import it.cnr.itd.uni2014.weld.service.CalcolatoreService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

@ApplicationScoped
public class TestMain {
	@Inject @Any Instance<CalcolatoreService> service;
	
	public void start(@Observes ContainerInitialized event) {
		System.out.println("Benvenuto");
		
		for (CalcolatoreService c:service)
			System.out.println(c.getClass());
		
		//System.out.println(service.calculate(2, 3));
	}

	@PostConstruct
	private void init() {
		System.out.println("init");
	}
}
