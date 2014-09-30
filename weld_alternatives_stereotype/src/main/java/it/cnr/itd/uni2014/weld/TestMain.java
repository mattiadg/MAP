package it.cnr.itd.uni2014.weld;

import it.cnr.itd.uni2014.weld.service.CalcolatoreService;
import it.cnr.itd.uni2014.weld.service.CallerService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

@ApplicationScoped
public class TestMain {
	@Inject
	CalcolatoreService service;
	@Inject
	CallerService service2;

	public void start(@Observes ContainerInitialized event) {
		System.out.println("Benvenuto");
		
		
		System.out.println(service.calculate(2, 3));
		service2.call("Enrico");
	}

	@PostConstruct
	private void init() {
		System.out.println("init");
	}
}
