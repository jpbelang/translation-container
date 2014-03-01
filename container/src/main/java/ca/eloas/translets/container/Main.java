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

        c.addIngressProtocolHandler(
                "ca.eloas.translets.protocols.smtp.Module",
                "/Users/jpbelang/Git/eloas/translets/protocols/smtp/target/smtp-1.0-SNAPSHOT");

        c.start();
    }
}
