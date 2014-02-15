package ca.eloas.translets.container;

/**
 * @author JP
 */
public interface ProtocolHandler {

    void send();

    public void setReceiver(Receiver r);

}
