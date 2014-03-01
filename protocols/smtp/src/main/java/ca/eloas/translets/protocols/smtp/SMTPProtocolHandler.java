package ca.eloas.translets.protocols.smtp;


import ca.eloas.translets.container.Container;
import ca.eloas.translets.container.IngressProtocolHandler;
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
public class SMTPProtocolHandler implements IngressProtocolHandler, ProtocolStartupHandler, ProtocolShutdownHandler {

    private  EventBus bus;
    private  SMTPServer smtpServer;
    private Receiver receiver;

    @Inject
    public SMTPProtocolHandler(EventBus bus) {

        this.bus = bus;
        bus.addHandler(ProtocolStartupEvent.getType(), this);
        bus.addHandler(ProtocolShutdownEvent.getType(), this);

    }


    @Override
    public void onProtocolStartup(ProtocolStartupEvent event) {

        smtpServer.start();
    }

    @Override
    public void onProtocolShutdown(ProtocolShutdownEvent event) {

        smtpServer.stop();
    }

    @Override
    public void deploy(Receiver r) {

        smtpServer = new SMTPServer(new DefaultMessageHandlerFactory(r));
        smtpServer.setPort(2525);
    }

    public void undeploy() {


    }
}
