package it.cnr.itd.uni2014.jndi.service.impl;

import it.cnr.itd.uni2014.jndi.service.CalcolatoreService;


public class CalcolatoreServiceImpl2 implements CalcolatoreService {
	@Override
	public int calculate(int a, int b) {
		return a*b;
	}
}
