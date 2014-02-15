package ca.eloas.translets.api;

/**
 * @author JP
 */
public interface Translet {

    void handleRequest(IncomingRequest incoming, OutgoingRequest outgoing);
    void returnResponse(IncomingResponse incoming, OutgoingResponse outgoing, IncomingRequest originalIncoming, OutgoingRequest originalOutgoingRequest);
}
