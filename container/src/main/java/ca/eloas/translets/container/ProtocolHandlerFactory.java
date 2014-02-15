package ca.eloas.translets.container;

/**
 * @author JP
 */
public interface ProtocolHandlerFactory {

    ProtocolHandler create(Receiver r);
}
