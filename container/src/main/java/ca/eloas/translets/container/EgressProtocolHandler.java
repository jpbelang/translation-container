package ca.eloas.translets.container;

import ca.eloas.translets.api.OutgoingRequest;
import ca.eloas.translets.api.OutgoingResponse;

/**
 * @author JP
 */
public interface EgressProtocolHandler {

    void deploy();

    OutgoingResponse sendRequest(OutgoingRequest request);
    void sendAndForget(OutgoingRequest request);
}
