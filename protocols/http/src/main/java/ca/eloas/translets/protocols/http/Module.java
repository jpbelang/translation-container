package ca.eloas.translets.protocols.http;

import ca.eloas.translets.container.EgressProtocolHandler;
import com.google.inject.AbstractModule;

/**
 * @author JP
 */
public class Module extends AbstractModule {

    @Override
    protected void configure() {

        binder().requireExplicitBindings();
        bind(EgressProtocolHandler.class).to(HttpClientProtocolHandler.class);
    }
}
