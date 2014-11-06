package it.cnr.itd.uni2014.weld.service.impl;

import it.cnr.itd.uni2014.weld.service.CalcolatoreService;
import it.cnr.itd.uni2014.weld.stereo.Mock;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Mock
public class CalcolatoreServiceImpl2 implements CalcolatoreService {
	@Override
	public int calculate(int a, int b) {
		return a*b;
	}
}
