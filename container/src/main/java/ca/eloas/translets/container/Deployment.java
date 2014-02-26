package ca.eloas.translets.container;

/**
 * @author JP
 */
public interface Deployment {

    void deploy(Container container) throws DeploymentException;
    void undeploy(Container Container);
}
