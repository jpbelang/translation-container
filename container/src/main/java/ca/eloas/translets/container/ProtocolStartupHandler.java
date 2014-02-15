/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package ca.eloas.translets.container;


import ca.eloas.translets.container.events.EventHandler;

public interface ProtocolStartupHandler extends EventHandler {
	void onProtocolStartup(ProtocolStartupEvent event);
}
