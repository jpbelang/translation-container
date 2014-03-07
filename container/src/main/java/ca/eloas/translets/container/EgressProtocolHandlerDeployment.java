package ca.eloas.translets.container;

import ca.eloas.translets.api.IncomingRequest;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;

import java.util.Properties;

/**
 * @author JP
 */
public class EgressProtocolHandlerDeployment extends AbstractDeployment<EgressProtocolHandler> {

    @Inject
    public EgressProtocolHandlerDeployment(Injector i, @Assisted Properties p) {
        this(i, p, new PluginClassLoader(AbstractDeployment.class.getClassLoader(), p.getProperty("directory")));
    }

    EgressProtocolHandlerDeployment(Injector i, @Assisted Properties p, ClassLoader loader) {
        super(i, p, loader);
    }

    @Override
    protected EgressProtocolHandler createComponent(Injector childInjector) {

        EgressProtocolHandler handler = childInjector.getInstance(EgressProtocolHandler.class);
        handler.deploy(getProperties());
        return handler;
    }
}
