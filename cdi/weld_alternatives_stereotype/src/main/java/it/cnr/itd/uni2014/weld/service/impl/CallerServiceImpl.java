package it.cnr.itd.uni2014.weld.service.impl;

import javax.enterprise.context.ApplicationScoped;

import it.cnr.itd.uni2014.weld.service.CallerService;

@ApplicationScoped
public class CallerServiceImpl implements CallerService {
	@Override
	public int call(String param) {
		System.out.println("Ciao "+param);
		return 0;
	}
}
