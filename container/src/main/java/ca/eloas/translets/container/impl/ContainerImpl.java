package ca.eloas.translets.container.impl;

import ca.eloas.translets.container.Container;
import ca.eloas.translets.container.ContainerException;
import ca.eloas.translets.container.Deployment;
import ca.eloas.translets.container.EgressProtocolHandlerDeployment;
import ca.eloas.translets.container.IngressProtocolHandlerDeployment;
import ca.eloas.translets.container.ProtocolStartupEvent;
import ca.eloas.translets.container.events.EventBus;
import com.google.inject.Inject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JP
 */
public class ContainerImpl implements Container {

    private final EventBus bus;
    private final ConfigurationManager configurationManager;
    private Map<String, Deployment> contexts = new HashMap<>();
    private Map<String, EgressProtocolHandlerDeployment> egressHandlers = new HashMap<>();
    private Map<String, IngressProtocolHandlerDeployment> ingressHandlers = new HashMap<>();


    @Inject
    public ContainerImpl(ConfigurationManager cm, EventBus bus) {

        this.bus = bus;
        this.configurationManager = cm;
    }

    @Override
    public void start() throws ContainerException {

        configurationManager.configure(this);
        ingressHandlers.forEach((x, y) -> y.deploy(this));
        egressHandlers.forEach((x,y) -> y.deploy(this));
        contexts.forEach((x,y) -> y.deploy(this));
        bus.fireEvent(new ProtocolStartupEvent(this));
    }

    @Override
    public void stop() {

    }

    @Override
    public void addContext(String name, Deployment c) {

        contexts.put(name, c);
    }

    @Override
    public void addIngressProtocolHandlerDeployment(String name, IngressProtocolHandlerDeployment deployment) {

        ingressHandlers.put(name, deployment);
    }

    @Override
    public void addEgressProtocolHandlerDeployment(String name, EgressProtocolHandlerDeployment deployment) {

        egressHandlers.put(name, deployment);
    }

    @Override
    public EventBus getEventBus() {
        return bus;
    }

    @Override
    public IngressProtocolHandlerDeployment getIngressDeployment(String ingress) {
        return ingressHandlers.get(ingress);
    }

    @Override
    public EgressProtocolHandlerDeployment getEgressDeployment(String egress) {
        return egressHandlers.get(egress);
    }
}
