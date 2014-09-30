package it.cnr.itd.uni2014.spring.service.qualifier;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier
@Retention(RUNTIME)
@Target({ METHOD, TYPE })
public @interface Mock {
}