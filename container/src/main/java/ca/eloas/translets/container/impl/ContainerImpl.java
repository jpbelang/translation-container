package ca.eloas.translets.container.impl;

import ca.eloas.translets.container.Container;
import ca.eloas.translets.container.ContainerException;
import ca.eloas.translets.container.Deployer;
import ca.eloas.translets.container.Deployment;
import ca.eloas.translets.container.DeploymentFactory;
import ca.eloas.translets.container.DeploymentManager;
import ca.eloas.translets.container.ProtocolStartupEvent;
import ca.eloas.translets.container.events.EventBus;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JP
 */
public class ContainerImpl implements Container, DeploymentManager {

    private final EventBus bus;
    private final DeploymentFactory factory;
    private List<Deployment> contexts = new ArrayList<>();
    private List<Deployment> protocolHandlers = new ArrayList<>();

    @Inject
    public ContainerImpl(DeploymentFactory fac, EventBus bus) {

        this.bus = bus;
        this.factory = fac;
    }

    @Override
    public void start() throws ContainerException {

        try {
            for (Deployment protocolHandler : protocolHandlers) {

                protocolHandler.deploy(this);
            }

            for (Deployment context : contexts) {

                context.deploy(this);
            }

            bus.fireEvent(new ProtocolStartupEvent(this));
        } catch (Exception e) {
            throw new ContainerException(e);
        }
    }

    @Override
    public Deployer attach(Object o) {
        return null;
    }

    @Override
    public void stop() {

    }

    @Override
    public void addContext(Deployment c) {

        contexts.add(c);
    }

    @Override
    public void addIngressProtocolHandler(String modulename, String directory) {

        protocolHandlers.add(factory.createIngressDeployment(modulename, directory));
    }

    @Override
    public EventBus getEventBus() {
        return bus;
    }
}
