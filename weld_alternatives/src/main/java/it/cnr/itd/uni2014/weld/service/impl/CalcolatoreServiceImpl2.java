package it.cnr.itd.uni2014.weld.service.impl;

import it.cnr.itd.uni2014.weld.service.CalcolatoreService;
import it.cnr.itd.uni2014.weld.service.ServizioSincrono;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ServizioSincrono
public class CalcolatoreServiceImpl2 implements CalcolatoreService {
	
	public int calculate(int a, int b) {
		return a*b;
	}
	
	
}
