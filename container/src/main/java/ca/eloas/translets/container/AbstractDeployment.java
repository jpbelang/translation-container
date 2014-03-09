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
    private ClassLoader classLoader;

    public AbstractDeployment(Injector parent, Properties p, ClassLoader loader) {
        this.parentInjector = parent;
        this.properties = p;
        this.classLoader = loader;
    }

    @Override
    public void deploy(Container container) throws DeploymentException {

        try {
            Module module = (Module) classLoader.loadClass(properties.getProperty("moduleName")).newInstance();
            childInjector = parentInjector.createChildInjector(module);

            component = createAndDeployComponent(container, childInjector);
        } catch (Exception e) {

            throw new DeploymentException(e);
        }

    }


    abstract protected T createAndDeployComponent(Container container, Injector childInjector);

    @Override
    public void undeploy(Container manager) {

    }

    protected Properties getProperties() {
        return properties;
    }
}
