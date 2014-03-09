package ca.eloas.translets.container;

import ca.eloas.translets.api.IncomingRequest;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;

import java.util.Properties;

/**
 * @author JP
 */
public class IngressProtocolHandlerDeploymentImpl extends AbstractDeployment<IngressProtocolHandler> implements IngressProtocolHandlerDeployment {

    @Inject
    public IngressProtocolHandlerDeploymentImpl(Injector i, @Assisted Properties p) {
        this(i, p, new PluginClassLoader(AbstractDeployment.class.getClassLoader(), p.getProperty("directory")));
    }

    IngressProtocolHandlerDeploymentImpl(Injector i, Properties p, ClassLoader loader) {
        super(i, p, loader);
    }

    @Override
    protected IngressProtocolHandler createAndDeployComponent(Container container, Injector childInjector) {

        IngressProtocolHandler handler = childInjector.getInstance(IngressProtocolHandler.class);
        handler.deploy(getProperties(), new Receiver() {
            @Override
            public void receive(IncomingRequest smtpIncomingRequest) {

            }
        });
        return handler;
    }
}
