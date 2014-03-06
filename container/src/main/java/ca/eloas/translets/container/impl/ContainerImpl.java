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
    private final ConfigurationManager configurationManager;
    private List<Deployment> contexts = new ArrayList<>();
    private List<Deployment> egressHandlers = new ArrayList<>();
    private List<Deployment> ingressHandlers = new ArrayList<>();


    @Inject
    public ContainerImpl(DeploymentFactory fac, ConfigurationManager cm, EventBus bus) {

        this.bus = bus;
        this.factory = fac;
        this.configurationManager = cm;
    }

    @Override
    public void start() throws ContainerException {

        configurationManager.configure(this);
        ingressHandlers.forEach(x -> x.deploy(this));
        egressHandlers.forEach(x -> x.deploy(this));
        bus.fireEvent(new ProtocolStartupEvent(this));
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
    public void addIngressProtocolHandlerDeployment(Deployment deployment) {

        ingressHandlers.add(deployment);
    }

    @Override
    public void addEgressProtocolHandlerDeployment(Deployment deployment) {

        ingressHandlers.add(deployment);
    }

    @Override
    public EventBus getEventBus() {
        return bus;
    }
}
