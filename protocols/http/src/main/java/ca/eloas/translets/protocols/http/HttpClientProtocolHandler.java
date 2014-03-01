package ca.eloas.translets.protocols.http;

import ca.eloas.translets.api.OutgoingRequest;
import ca.eloas.translets.api.OutgoingResponse;
import ca.eloas.translets.container.EgressProtocolHandler;

/**
 * @author JP
 */
public class HttpClientProtocolHandler implements EgressProtocolHandler {

    @Override
    public void deploy() {

    }

    @Override
    public OutgoingResponse sendRequest(OutgoingRequest request) {
        return null;
    }

    @Override
    public void sendAndForget(OutgoingRequest request) {

    }
}
