package ca.eloas.translets.container;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;

import java.util.Properties;

/**
 * @author JP
 */
public class EgressProtocolHandlerDeploymentImpl extends AbstractDeployment<EgressProtocolHandler> implements EgressProtocolHandlerDeployment {

    @Inject
    public EgressProtocolHandlerDeploymentImpl(Injector i, @Assisted Properties p) {
        this(i, p, new PluginClassLoader(AbstractDeployment.class.getClassLoader(), p.getProperty("directory")));
    }

    EgressProtocolHandlerDeploymentImpl(Injector i, @Assisted Properties p, ClassLoader loader) {
        super(i, p, loader);
    }

    @Override
    protected EgressProtocolHandler createAndDeployComponent(Container container, Injector childInjector) {

        EgressProtocolHandler handler = childInjector.getInstance(EgressProtocolHandler.class);
        handler.deploy(getProperties());
        return handler;
    }
}
