package ca.eloas.translets.container;

import ca.eloas.translets.container.impl.ContainerImpl;

/**
 * @author JP
 */
public interface TransletContext {
    void deploy(Container container);
}
