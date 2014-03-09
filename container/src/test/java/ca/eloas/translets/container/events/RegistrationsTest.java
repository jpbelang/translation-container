package ca.eloas.translets.container.events;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author JP
 */
public class RegistrationsTest {
    @Test
    public void testUnregisterAll() throws Exception {

        HandlerRegistration r1 = mock(HandlerRegistration.class);
        HandlerRegistration r2 = mock(HandlerRegistration.class);

        Registrations registrations = new Registrations();
        registrations.add(r1, r2);

        registrations.unregisterAll();

        verify(r1).removeHandler();
        verify(r2).removeHandler();
    }
}
