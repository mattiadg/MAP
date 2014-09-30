package org.jboss.weld.environment.se.example.numberguess;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class Generator {
    private final java.util.Random random = new java.util.Random(System.currentTimeMillis());
    private int maxNumber = 100;

    java.util.Random getRandom() {
        return random;
    }

    int next() {
        return getRandom().nextInt(maxNumber);
    }

    @Produces
    @MaxNumber
    int getMaxNumber() {
        return maxNumber;
    }
}
