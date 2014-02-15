package ca.eloas.translets.container.impl;

import ca.eloas.translets.container.Container;
import ca.eloas.translets.container.TransletContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JP
 */
public class ContainerImpl implements Container {

    private List<TransletContext> contexts = new ArrayList<TransletContext>();

    @Override
    public void start() {

        for (TransletContext context : contexts) {

            context.deploy(this);
        }

    }

    @Override
    public void stop() {

    }

    @Override
    public void addContext(TransletContext c) {

        contexts.add(c);
    }
}
