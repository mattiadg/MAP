package it.cnr.itd.uni2014.weld;

import  java.util.logging.Logger;

import it.cnr.itd.uni2014.weld.service.CalcolatoreService;

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
	Logger logger;

	public void start(@Observes ContainerInitialized event) {
		logger.info("Benvenuto");
		logger.info(""+service.calculate(2, 3));
	}

	@PostConstruct
	private void init() {
		System.out.println("init");
	}
}
