package ca.eloas.translets.protocols.smtp;

import ca.eloas.translets.container.Receiver;
import org.subethamail.smtp.MessageHandler;
import org.subethamail.smtp.RejectException;
import org.subethamail.smtp.TooMuchDataException;

import java.io.IOException;
import java.io.InputStream;

/**
* @author JP
*/
class DefaultMessageHandler implements MessageHandler {

    private final Receiver receiver;
    private String from;
    private String recipient;

    public DefaultMessageHandler(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void from(String from) throws RejectException {

        this.from = from;
    }

    @Override
    public void recipient(String recipient) throws RejectException {

        this.recipient = recipient;
    }

    @Override
    public void data(InputStream data) throws RejectException, TooMuchDataException, IOException {

        receiver.receive();
    }

    @Override
    public void done() {

    }
}
