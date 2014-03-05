package ca.eloas.translets.container;

import ca.eloas.translets.api.IncomingRequest;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;

import java.util.Properties;

/**
 * @author JP
 */
public class IngressProtocolHandlerDeployment extends AbstractDeployment<IngressProtocolHandler> {

    @Inject
    public IngressProtocolHandlerDeployment(Injector i, @Assisted Properties p) {
        super(i, p);
    }

    @Override
    protected IngressProtocolHandler createComponent(Injector childInjector) {

        IngressProtocolHandler handler = childInjector.getInstance(IngressProtocolHandler.class);
        handler.deploy(getProperties(), new Receiver() {
            @Override
            public void receive(IncomingRequest smtpIncomingRequest) {

            }
        });
        return handler;
    }
}
