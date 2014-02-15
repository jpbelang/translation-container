/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package ca.eloas.translets.container;


import ca.eloas.translets.container.events.Event;

public class ProtocolStartupEvent extends Event<ProtocolStartupHandler> {

	private static final Type<ProtocolStartupHandler> TYPE = new Type<ProtocolStartupHandler>();
    private final Container container;

    public static Type<ProtocolStartupHandler> getType() {
		return TYPE;
	}

	public ProtocolStartupEvent(Container container) {

        this.container = container;
	}

	public Container getPresenter() {
		return container;
	}



	@Override
	protected void dispatch(ProtocolStartupHandler handler) {
		handler.onProtocolStartup(this);
	}

	@Override
	public Type<ProtocolStartupHandler> getAssociatedType() {
		return getType();
	}

}
