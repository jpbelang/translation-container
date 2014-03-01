package ca.eloas.translets.container;

import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author JP
 */
abstract public class AbstractDeployment<T> implements Deployment {

    private Injector parentInjector;

    final private String pluginDirectory;
    final private String pluginNameModule;
    private Injector childInjector;
    private T component;
    private PluginClassLoader classLoader;

    public AbstractDeployment(Injector parent, String pluginModuleName, String pluginDirectory) {
        this.parentInjector = parent;
        this.pluginNameModule = pluginModuleName;
        this.pluginDirectory = pluginDirectory;
        this.classLoader = new PluginClassLoader(AbstractDeployment.class.getClassLoader(), pluginDirectory);
    }

    @Override
    public void deploy(Container container) throws DeploymentException {

        try {
            Module module = (Module) classLoader.loadClass(pluginNameModule).newInstance();
            childInjector = parentInjector.createChildInjector(module);

            component = createComponent(childInjector);
        } catch (Exception e) {

            throw new DeploymentException(e);
        }

    }


    abstract protected T createComponent(Injector childInjector);

    @Override
    public void undeploy(Container manager) {

    }
}
