/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package ca.eloas.translets.container;


import ca.eloas.translets.container.events.Event;

public class ServerStartupEvent extends Event<ServerStartupHandler> {

	private static final Type<ServerStartupHandler> TYPE = new Type<ServerStartupHandler>();
    private final Container container;

    public static Type<ServerStartupHandler> getType() {
		return TYPE;
	}

	public ServerStartupEvent(Container container) {

        this.container = container;
	}

	public Container getContainer() {
		return container;
	}

	@Override
	protected void dispatch(ServerStartupHandler handler) {
		handler.onPresenterHidden(this);
	}

	@Override
	public Type<ServerStartupHandler> getAssociatedType() {
		return getType();
	}

}
