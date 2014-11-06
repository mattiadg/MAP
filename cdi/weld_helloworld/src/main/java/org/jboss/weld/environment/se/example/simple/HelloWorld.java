package org.jboss.weld.environment.se.example.simple;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;


@ApplicationScoped
public class HelloWorld {

    @Inject
    CommandLineArgsValidator argsValidator;

    public HelloWorld() {
    }

    public void printHello(@Observes ContainerInitialized init) {
        if (!argsValidator.hasErrors()) {
            System.out.println("Hello " + argsValidator.getValidParameters().get(0));
        } else {
            for (String error : argsValidator.getErrors()) {
                System.out.println(error);
            }
        }
    }

}
