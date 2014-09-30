package it.cnr.itd.uni2014.spring.service;
 
import it.cnr.itd.uni2014.spring.service.impl.CalcolatoreServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
@Configuration
@ComponentScan(value={"it.cnr.itd.uni2014.spring"})
public class DIConfiguration {
 
	@Bean
    public CalcolatoreService getMessageService(){
        return new CalcolatoreServiceImpl();
    }
}