package ca.eloas.translets.protocols.smtp;

import ca.eloas.translets.container.Receiver;
import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.MessageHandler;
import org.subethamail.smtp.MessageHandlerFactory;

/**
* @author JP
*/
class DefaultMessageHandlerFactory implements MessageHandlerFactory {
    private final Receiver receiver;

    public DefaultMessageHandlerFactory(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public MessageHandler create(MessageContext messageContext) {

        return new DefaultMessageHandler(receiver);
    }
}
