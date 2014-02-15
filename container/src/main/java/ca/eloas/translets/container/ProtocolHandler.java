package ca.eloas.translets.container;

/**
 * @author JP
 */
public interface ProtocolHandler {

    void deploy(Container container);
    void undeploy(Container container);

    void send();
    public void setReceiver(Receiver r);



}
