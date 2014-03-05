package ca.eloas.translets.container;

import com.google.inject.assistedinject.Assisted;

import java.util.Properties;

/**
 * @author JP
 */
public interface DeploymentFactory {

    IngressProtocolHandlerDeployment createIngressDeployment( Properties p );
}
