package it.cnr.itd.uni2014.weld.stereo;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Stereotype;

@Alternative
@Stereotype
@Retention(RUNTIME)
@Target(TYPE)
public @interface Mock {
}