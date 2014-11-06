package it.cnr.itd.uni2014.weld.service.impl;

import it.cnr.itd.uni2014.weld.service.CalcolatoreService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class CalcolatoreServiceImpl2 implements CalcolatoreService {
	@Override
	public int calculate(int a, int b) {
		return a*b;
	}
}
