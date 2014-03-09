package ca.eloas.translets.container;

import ca.eloas.translets.api.Translet;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;

import java.util.Properties;

/**
 * @author JP
 */
public class ContextDeployment extends AbstractDeployment<Translet> {


    @Inject
    public ContextDeployment(Injector i, @Assisted Properties p) {
        this(i, p, new PluginClassLoader(AbstractDeployment.class.getClassLoader(), p.getProperty("directory")));
    }

    ContextDeployment(Injector i, @Assisted Properties p, ClassLoader loader) {
        super(i, p, loader);
    }

    @Override
    protected Translet createAndDeployComponent(Container container, Injector childInjector) {


        IngressProtocolHandlerDeployment ingress = container.getIngressDeployment(getProperties().getProperty("ingress"));
        EgressProtocolHandlerDeployment egress = container.getEgressDeployment(getProperties().getProperty("egress"));

        //ingress.registerUsage(this);
        //egress.registerUsage(this);


        Translet t = new TransletWrapper(childInjector);

        return t;
    }

}
