package ca.eloas.translets.container;

/**
 * @author JP
 */
public class SimpleDeployment implements Deployment {

    final private String pluginDirectory;
    final private String pluginNameModule;
    private PluginClassLoader classLoader;

    public SimpleDeployment(String pluginModuleName, String pluginDirectory) {
        this.pluginNameModule = pluginModuleName;
        this.pluginDirectory = pluginDirectory;
    }

    @Override
    public void deploy(Container container) throws DeploymentException {

        try {
            classLoader = new PluginClassLoader(SimpleDeployment.class.getClassLoader(), pluginDirectory);
            Object o = classLoader.loadClass(pluginNameModule).getConstructor(Container.class).newInstance(container);
        } catch (Exception e) {

            throw new DeploymentException(e);
        }

    }

    @Override
    public void undeploy(Container manager) {

    }
}
