package ca.eloas.translets.protocols.smtp;

import ca.eloas.translets.container.Container;
import ca.eloas.translets.container.IngressProtocolHandler;
import ca.eloas.translets.container.events.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Singleton;

/**
 * @author JP
 */
public class Module extends AbstractModule {



    public Module() {
    }

    @Override
    protected void configure() {

        binder().requireExplicitBindings();

        bind(IngressProtocolHandler.class).to(SMTPProtocolHandler.class).in(Singleton.class);;
    }

  /*  @Provides
    public Container container() {

        return container;
    }

    @Provides
    public EventBus eventBus() {

        return container.getEventBus();
    }
*/
/*
    @Provides
    public IngressProtocolHandler mh() {

        return new SMTPProtocolHandler();
    }
*/

}
