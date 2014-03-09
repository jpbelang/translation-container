package ca.eloas.translets.example;

import ca.eloas.translets.api.IncomingRequest;
import ca.eloas.translets.api.IncomingResponse;
import ca.eloas.translets.api.OutgoingRequest;
import ca.eloas.translets.api.OutgoingResponse;
import ca.eloas.translets.api.Translet;

/**
 * @author JP
 */
public class SimpleTranslet implements Translet {

    @Override
    public void handleRequest(IncomingRequest incoming, OutgoingRequest outgoing) {

    }

    @Override
    public void returnResponse(IncomingResponse incoming, OutgoingResponse outgoing, IncomingRequest originalIncoming, OutgoingRequest originalOutgoingRequest) {

    }
}
