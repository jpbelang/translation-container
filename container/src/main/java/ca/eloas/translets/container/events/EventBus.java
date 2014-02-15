/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package ca.eloas.translets.container.events;

import ca.eloas.translets.container.events.Event.Type;

/**
 * An interface providing minimal access to an {@link EventHandler} manager.
 * 
 * Rather than being attached to a single object, an EventBus provides a central
 * pathway to send events across the whole application.
 * 
 * @author David Peterson
 * 
 */
public interface EventBus {
	<H extends EventHandler> HandlerRegistration addHandler(Type<H> type,
                                                            H handler);

	void fireEvent(Event<?> event);

	<H extends EventHandler> H getHandler(Type<H> type, int index);

	int getHandlerCount(Event.Type<?> type);

	boolean isEventHandled(Event.Type<?> e);
}
