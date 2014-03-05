package ca.eloas.translets.container;

import java.util.Properties;

/**
 * @author JP
 */
public interface IngressProtocolHandler  {

    void deploy(Properties p, Receiver r);

}
