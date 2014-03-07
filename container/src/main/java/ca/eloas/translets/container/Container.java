package ca.eloas.translets.container;

import ca.eloas.translets.container.events.EventBus;

/**
 * @author JP
 */
public interface Container {

    void start() throws ContainerException;
    void stop();

    // Experimental
    void addContext(String name, Deployment c);
    void addIngressProtocolHandlerDeployment(String name, Deployment d);
    void addEgressProtocolHandlerDeployment(String name, Deployment d);

    EventBus getEventBus();
}
