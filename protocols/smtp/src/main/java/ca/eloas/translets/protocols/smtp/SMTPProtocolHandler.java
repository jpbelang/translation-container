package ca.eloas.translets.protocols.smtp;


import ca.eloas.translets.container.Container;
import ca.eloas.translets.container.IngressProtocolHandler;
import ca.eloas.translets.container.ProtocolShutdownEvent;
import ca.eloas.translets.container.ProtocolShutdownHandler;
import ca.eloas.translets.container.ProtocolStartupEvent;
import ca.eloas.translets.container.ProtocolStartupHandler;
import ca.eloas.translets.container.Receiver;
import ca.eloas.translets.container.events.EventBus;
import ca.eloas.translets.container.events.Registrations;
import org.subethamail.smtp.server.SMTPServer;

import javax.inject.Inject;
import java.util.Properties;

/**
 * @author JP
 */
public class SMTPProtocolHandler implements IngressProtocolHandler, ProtocolStartupHandler, ProtocolShutdownHandler {

    private  EventBus bus;
    private  SMTPServer smtpServer;
    private Receiver receiver;

    private Registrations registrations = new Registrations();

    @Inject
    public SMTPProtocolHandler(EventBus bus) {

        this.bus = bus;
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
    public void deploy(Properties p, Receiver r) {

        registrations.add(
                bus.addHandler(ProtocolStartupEvent.getType(), this),
                bus.addHandler(ProtocolShutdownEvent.getType(), this));

        smtpServer = new SMTPServer(new DefaultMessageHandlerFactory(r));
        smtpServer.setPort(Integer.parseInt(p.getProperty("port", "2525")));
    }

    public void undeploy() {


    }
}
