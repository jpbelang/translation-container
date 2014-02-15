package ca.eloas.translets.container;

/**
 * @author JP
 */
public interface Deployer {

    void deploy(DeploymentManager manager);
    void undeploy(DeploymentManager manager);
}
