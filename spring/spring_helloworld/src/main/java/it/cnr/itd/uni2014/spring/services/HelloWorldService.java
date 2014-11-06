package it.cnr.itd.uni2014.spring.services;
import org.springframework.stereotype.Service;
 
@Service("helloWorldService")
public class HelloWorldService {
 
	private String name;
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String sayHello() {
		return "Hello! " + name;
	}
}