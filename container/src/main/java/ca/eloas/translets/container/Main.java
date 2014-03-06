package ca.eloas.translets.container;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author JP
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Injector injector = Guice.createInjector(new ParentModule());
        Container c = injector.getInstance(Container.class);
        c.start();
    }
}
