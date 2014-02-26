package ca.eloas.translets.container.impl;

import ca.eloas.translets.container.Container;
import ca.eloas.translets.container.ContainerException;
import ca.eloas.translets.container.Deployer;
import ca.eloas.translets.container.Deployment;
import ca.eloas.translets.container.DeploymentManager;
import ca.eloas.translets.container.events.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JP
 */
public class ContainerImpl implements Container, DeploymentManager {

    private final EventBus bus;
    private List<Deployment> contexts = new ArrayList<>();
    private List<Deployment> protocolHandlers = new ArrayList<>();

    public ContainerImpl(EventBus bus) {

        this.bus = bus;
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
    public void addProtocolHandler(Deployment c) {

        protocolHandlers.add(c);
    }

}
