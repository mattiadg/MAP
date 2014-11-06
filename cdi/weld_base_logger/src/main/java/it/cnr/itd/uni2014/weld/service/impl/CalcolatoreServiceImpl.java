package it.cnr.itd.uni2014.weld.service.impl;

import it.cnr.itd.uni2014.weld.service.CalcolatoreService;

import  java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CalcolatoreServiceImpl implements CalcolatoreService {
	@Inject
	Logger logger;
	
	@Override
	public int calculate(int a, int b) {
		logger.info("chiamato calculate");
		return a+b;
	}
}
