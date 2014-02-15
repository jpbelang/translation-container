/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package ca.eloas.translets.container;


import ca.eloas.translets.container.events.Event;

public class ProtocolShutdownEvent extends Event<ProtocolShutdownHandler> {

	private static final Type<ProtocolShutdownHandler> TYPE = new Type<ProtocolShutdownHandler>();
    private final Container container;

    public static Type<ProtocolShutdownHandler> getType() {
		return TYPE;
	}

	public ProtocolShutdownEvent(Container container) {

        this.container = container;
	}

	public Container getContainer() {
		return container;
	}



	@Override
	protected void dispatch(ProtocolShutdownHandler handler) {
		handler.onProtocolShutdown(this);
	}

	@Override
	public Type<ProtocolShutdownHandler> getAssociatedType() {
		return getType();
	}

}
