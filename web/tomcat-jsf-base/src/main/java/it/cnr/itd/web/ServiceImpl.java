package it.cnr.itd.web;

import javax.faces.bean.ApplicationScoped;

@ApplicationScoped
public class ServiceImpl implements Service{

	@Override
	public String elabora(String param) {
		// TODO Auto-generated method stub
		return param.toUpperCase();
	}

}
