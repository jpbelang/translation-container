package ca.eloas.translets.protocols.smtp;

import ca.eloas.translets.container.Container;
import ca.eloas.translets.container.Deployer;

/**
 * @author JP
 */
public class ProtocolHandlerDeployer implements Deployer {

    private final Container container;

    public ProtocolHandlerDeployer(Container c) {

        this.container = c;

    }
}
