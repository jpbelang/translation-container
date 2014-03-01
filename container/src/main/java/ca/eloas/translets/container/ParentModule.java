package ca.eloas.translets.container;

import ca.eloas.translets.container.events.DefaultEventBus;
import ca.eloas.translets.container.events.EventBus;
import ca.eloas.translets.container.impl.ContainerImpl;
import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import javax.inject.Singleton;

/**
 * @author JP
 */
public class ParentModule extends AbstractModule {


    @Override
    protected void configure() {

        install(new FactoryModuleBuilder()
                .build(DeploymentFactory.class));

        bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
        bind(Container.class).to(ContainerImpl.class).in(Singleton.class);

    }
}
