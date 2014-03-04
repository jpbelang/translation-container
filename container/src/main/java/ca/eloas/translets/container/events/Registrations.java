package ca.eloas.translets.container.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * @author JP
 */
public class Registrations {

    private ArrayList<HandlerRegistration> registrations = new ArrayList<>();

    public void add(HandlerRegistration... handlerRegistrations) {

        Collections.addAll(this.registrations, handlerRegistrations);
    }

    public void unregisterAll() {

        registrations.removeIf(x -> { x.removeHandler();return true;});
    }
}
