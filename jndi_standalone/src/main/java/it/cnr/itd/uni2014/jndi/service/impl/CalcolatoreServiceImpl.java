package it.cnr.itd.uni2014.jndi.service.impl;

import it.cnr.itd.uni2014.jndi.service.CalcolatoreService;


public class CalcolatoreServiceImpl implements CalcolatoreService {
	@Override
	public int calculate(int a, int b) {
		return a+b;
	}
}
