package ca.eloas.translets.container;

import ca.eloas.translets.container.events.DefaultEventBus;
import ca.eloas.translets.container.impl.ContainerImpl;

/**
 * @author JP
 */
public class Main {

    public static void main(String[] args) throws Exception  {

        Container c = new ContainerImpl( new DefaultEventBus() );
        //c.addProtocolHandler();

    }
}
