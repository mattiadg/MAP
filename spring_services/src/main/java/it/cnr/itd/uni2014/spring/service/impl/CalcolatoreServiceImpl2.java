package it.cnr.itd.uni2014.spring.service.impl;

import it.cnr.itd.uni2014.spring.service.CalcolatoreService;

import org.springframework.stereotype.Service;

@Service
public class CalcolatoreServiceImpl2 implements CalcolatoreService {
	@Override
	public int calculate(int a, int b) {
		return a*b;
	}
}
