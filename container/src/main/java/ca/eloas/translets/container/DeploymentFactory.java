package ca.eloas.translets.container;

import java.util.Properties;

/**
 * @author JP
 */
public interface DeploymentFactory {

    IngressProtocolHandlerDeploymentImpl createIngressDeployment( Properties p );
    EgressProtocolHandlerDeploymentImpl createEgressDeployment( Properties p );
}
