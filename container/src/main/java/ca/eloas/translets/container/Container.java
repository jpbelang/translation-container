package ca.eloas.translets.container;

import ca.eloas.translets.container.events.EventBus;

/**
 * @author JP
 */
public interface Container {

    void start() throws ContainerException;
    void stop();

    // Experimental
    void addContext(Deployment c);
    void addIngressProtocolHandlerDeployment(Deployment d);

    EventBus getEventBus();
}
