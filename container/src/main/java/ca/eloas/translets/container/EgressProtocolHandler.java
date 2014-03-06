package ca.eloas.translets.container;

import ca.eloas.translets.api.OutgoingRequest;
import ca.eloas.translets.api.OutgoingResponse;

import java.util.Properties;

/**
 * @author JP
 */
public interface EgressProtocolHandler {

    void deploy(Properties p);

    OutgoingResponse sendRequest(OutgoingRequest request);
    void sendAndForget(OutgoingRequest request);
}
