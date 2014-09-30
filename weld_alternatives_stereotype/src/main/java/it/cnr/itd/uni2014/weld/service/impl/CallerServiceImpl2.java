package it.cnr.itd.uni2014.weld.service.impl;

import javax.enterprise.context.ApplicationScoped;

import it.cnr.itd.uni2014.weld.service.CallerService;
import it.cnr.itd.uni2014.weld.stereo.Mock;

@ApplicationScoped
@Mock	
public class CallerServiceImpl2 implements CallerService {
	@Override
	public int call(String param) {
		System.out.println("Ciao bello "+param);
		return 0;
	}
}
