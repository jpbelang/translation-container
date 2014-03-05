package ca.eloas.translets.container;

import com.google.inject.Injector;
import com.google.inject.Module;

import java.util.Properties;

/**
 * @author JP
 */
abstract public class AbstractDeployment<T> implements Deployment {

    private final Properties properties;
    private Injector parentInjector;

    private Injector childInjector;
    private T component;
    private PluginClassLoader classLoader;

    public AbstractDeployment(Injector parent, Properties p) {
        this.parentInjector = parent;
        this.properties = p;
        this.classLoader = new PluginClassLoader(AbstractDeployment.class.getClassLoader(), properties.getProperty("directory"));
    }

    @Override
    public void deploy(Container container) throws DeploymentException {

        try {
            Module module = (Module) classLoader.loadClass(properties.getProperty("moduleName")).newInstance();
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

    protected Properties getProperties() {
        return properties;
    }
}
