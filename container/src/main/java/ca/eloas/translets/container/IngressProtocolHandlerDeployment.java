package ca.eloas.translets.container;

import ca.eloas.translets.api.IncomingRequest;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;

/**
 * @author JP
 */
public class IngressProtocolHandlerDeployment extends AbstractDeployment<IngressProtocolHandler> {

    @Inject
    public IngressProtocolHandlerDeployment(Injector i, @Assisted("pluginModuleName") String pluginModuleName, @Assisted("directory") String pluginDirectory) {
        super(i, pluginModuleName, pluginDirectory);
    }

    @Override
    protected IngressProtocolHandler createComponent(Injector childInjector) {

        IngressProtocolHandler handler = childInjector.getInstance(IngressProtocolHandler.class);
        handler.deploy(new Receiver() {
            @Override
            public void receive(IncomingRequest smtpIncomingRequest) {

            }
        });
        return handler;
    }
}
