package it.cnr.itd.uni2014.jndi;

import it.cnr.itd.uni2014.jndi.service.CalcolatoreService;
import it.cnr.itd.uni2014.jndi.service.impl.CalcolatoreServiceImpl2;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Example {
	public static void main(String[] args) {
		try {
			Context ctxt = new InitialContext();
			try {
				List<String> list = (List<String>) ctxt.lookup("ciao/item");
				System.out.println("Items are: " + list);
				ctxt.bind("servizio", new CalcolatoreServiceImpl2());
				CalcolatoreService service = (CalcolatoreService) ctxt
						.lookup("servizio");
				System.out.println(service.calculate(2, 3));
			} catch (ClassCastException cce) {
				System.err.println("List not created, instead made: "
						+ ctxt.lookup("ciao/item"));
			}
		} catch (NamingException ne) {
			System.err.println("NamingException: " + ne.getMessage());
		}
	}
}
