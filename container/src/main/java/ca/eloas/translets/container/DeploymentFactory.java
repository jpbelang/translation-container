package ca.eloas.translets.container;

import com.google.inject.assistedinject.Assisted;

/**
 * @author JP
 */
public interface DeploymentFactory {

    IngressProtocolHandlerDeployment createIngressDeployment( @Assisted("pluginModuleName") String pluginModuleName, @Assisted("directory") String pluginDirectory);
}
