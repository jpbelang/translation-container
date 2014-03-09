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
    void addIngressProtocolHandlerDeployment(String name, IngressProtocolHandlerDeployment d);
    void addEgressProtocolHandlerDeployment(String name, EgressProtocolHandlerDeployment d);

    EventBus getEventBus();
    IngressProtocolHandlerDeployment getIngressDeployment(String ingress);
    EgressProtocolHandlerDeployment getEgressDeployment(String egress);
}
