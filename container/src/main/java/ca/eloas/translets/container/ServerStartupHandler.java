/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package ca.eloas.translets.container;


import ca.eloas.translets.container.events.EventHandler;

public interface ServerStartupHandler extends EventHandler {
	void onPresenterHidden(ServerStartupEvent event);
}
