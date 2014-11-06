package it.cnr.itd.uni2014.weld.service.impl;

import javax.enterprise.context.ApplicationScoped;

import it.cnr.itd.uni2014.weld.service.CalcolatoreService;

@ApplicationScoped
public class CalcolatoreServiceImpl implements CalcolatoreService {
	@Override
	public int calculate(int a, int b) {
		return a+b;
	}
}
