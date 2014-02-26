package ca.eloas.translets.protocols.smtp;

import ca.eloas.translets.container.Container;
import ca.eloas.translets.container.events.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * @author JP
 */
public class Module extends AbstractModule {


    private Container container;

    public Module(Container container) {
        this.container = container;
    }

    @Override
    protected void configure() {

    }

    @Provides
    public Container container() {

        return container;
    }

    @Provides
    public EventBus eventBus() {

        return container.getEventBus();
    }
}
