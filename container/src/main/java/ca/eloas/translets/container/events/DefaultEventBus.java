package ca.eloas.translets.container.events;

/**
 * @author JP
 */
public class DefaultEventBus extends HandlerManager implements EventBus {

    public DefaultEventBus() {
        super(null);
    }
}
