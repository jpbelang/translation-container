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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JP
 */
public class ContainerImpl implements Container, DeploymentManager {

    private final EventBus bus;
    private final DeploymentFactory factory;
    private final ConfigurationManager configurationManager;
    private List<Deployment> contexts = new ArrayList<>();
    private Map<String, Deployment> egressHandlers = new HashMap<>();
    private Map<String, Deployment> ingressHandlers = new HashMap<>();


    @Inject
    public ContainerImpl(DeploymentFactory fac, ConfigurationManager cm, EventBus bus) {

        this.bus = bus;
        this.factory = fac;
        this.configurationManager = cm;
    }

    @Override
    public void start() throws ContainerException {

        configurationManager.configure(this);
        ingressHandlers.forEach((x, y) -> y.deploy(this));
        egressHandlers.forEach((x,y) -> y.deploy(this));
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
    public void addIngressProtocolHandlerDeployment(String name, Deployment deployment) {

        ingressHandlers.put(name, deployment);
    }

    @Override
    public void addEgressProtocolHandlerDeployment(String name, Deployment deployment) {

        egressHandlers.put(name, deployment);
    }

    @Override
    public EventBus getEventBus() {
        return bus;
    }
}
