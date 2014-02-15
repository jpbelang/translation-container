package ca.eloas.translets.container;

/**
 * @author JP
 */
public interface Container {

    void start();
    void stop();

    // Experimental
    void addContext(TransletContext c);
}
