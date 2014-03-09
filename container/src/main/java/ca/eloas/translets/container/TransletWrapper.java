package ca.eloas.translets.container;

import ca.eloas.translets.api.IncomingRequest;
import ca.eloas.translets.api.IncomingResponse;
import ca.eloas.translets.api.OutgoingRequest;
import ca.eloas.translets.api.OutgoingResponse;
import ca.eloas.translets.api.Translet;
import com.google.inject.Injector;

/**
* @author JP
*/
class TransletWrapper implements Translet {

    private final Injector childInjector;
    private Translet target;

    public TransletWrapper(Injector childInjector) {
        this.childInjector = childInjector;
        target = null;
    }

    private Translet translet() {

        if ( target == null ) {
            target = childInjector.getInstance(Translet.class);
        }

        return target;
    }

    @Override
    public void handleRequest(IncomingRequest incoming, OutgoingRequest outgoing) {

        translet().handleRequest(incoming, outgoing);
    }

    @Override
    public void returnResponse(IncomingResponse incoming, OutgoingResponse outgoing, IncomingRequest originalIncoming, OutgoingRequest originalOutgoingRequest) {

        translet().returnResponse(incoming, outgoing, originalIncoming, originalOutgoingRequest);
    }
}
