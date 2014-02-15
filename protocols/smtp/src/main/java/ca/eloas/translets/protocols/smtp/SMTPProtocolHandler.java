package ca.eloas.translets.protocols.smtp;


import ca.eloas.translets.container.Container;
import ca.eloas.translets.container.ProtocolHandler;
import ca.eloas.translets.container.ProtocolShutdownEvent;
import ca.eloas.translets.container.ProtocolShutdownHandler;
import ca.eloas.translets.container.ProtocolStartupEvent;
import ca.eloas.translets.container.ProtocolStartupHandler;
import ca.eloas.translets.container.Receiver;
import ca.eloas.translets.container.events.EventBus;
import org.subethamail.smtp.server.SMTPServer;

import javax.inject.Inject;

/**
 * @author JP
 */
public class SMTPProtocolHandler implements ProtocolHandler, ProtocolStartupHandler, ProtocolShutdownHandler {

    private final EventBus bus;
    private final SMTPServer smtpServer;
    private Receiver receiver;

    @Inject
    public SMTPProtocolHandler(EventBus bus, final Receiver receiver) {

        this.bus = bus;
        bus.addHandler(ProtocolStartupEvent.getType(), this);
        bus.addHandler(ProtocolShutdownEvent.getType(), this);

        smtpServer = new SMTPServer(new DefaultMessageHandlerFactory(receiver));
    }

    @Override
    public void deploy(Container container) {

    }

    @Override
    public void undeploy(Container container) {

    }

    @Override
    public void send() {

    }

    @Override
    public void setReceiver(Receiver r) {

        this.receiver = r;
    }

    @Override
    public void onProtocolStartup(ProtocolStartupEvent event) {

    }

    @Override
    public void onProtocolShutdown(ProtocolShutdownEvent event) {

    }

}
