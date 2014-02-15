/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package ca.eloas.translets.container;


import ca.eloas.translets.container.events.EventHandler;

public interface ProtocolShutdownHandler extends EventHandler {
	void onProtocolShutdown(ProtocolShutdownEvent event);
}
