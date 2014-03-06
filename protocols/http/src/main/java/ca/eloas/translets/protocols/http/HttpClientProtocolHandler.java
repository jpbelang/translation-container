package ca.eloas.translets.protocols.http;

import ca.eloas.translets.api.OutgoingRequest;
import ca.eloas.translets.api.OutgoingResponse;
import ca.eloas.translets.container.EgressProtocolHandler;

import java.util.Properties;

/**
 * @author JP
 */
public class HttpClientProtocolHandler implements EgressProtocolHandler {

    @Override
    public void deploy(Properties p ) {

        System.err.println("deployed with " + p);
    }

    @Override
    public OutgoingResponse sendRequest(OutgoingRequest request) {
        return null;
    }

    @Override
    public void sendAndForget(OutgoingRequest request) {

    }
}
