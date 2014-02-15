package ca.eloas.translets.container;

import ca.eloas.translets.api.IncomingRequest;

/**
 * @author JP
 */
public interface Receiver {

    void receive(IncomingRequest smtpIncomingRequest);
}
