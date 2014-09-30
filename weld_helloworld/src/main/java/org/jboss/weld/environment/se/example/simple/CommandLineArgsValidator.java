package org.jboss.weld.environment.se.example.simple;

import org.jboss.weld.environment.se.bindings.Parameters;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Validates command line arguments, producing errors where applicable.
 *
 * @author Peter Royle
 */
@ApplicationScoped
public class CommandLineArgsValidator {

    @Inject
    @Parameters
    private List<String> validParams;

    private List<String> errors = new ArrayList<String>();

    public CommandLineArgsValidator() {
    }

    @Inject
    public void checkParameters() {
        if (validParams.size() != 1) {
            errors.add("Please supply just one parameter: your first name");
            validParams = Collections.emptyList();
        }
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<String> getValidParameters() {
        return validParams;
    }
}
