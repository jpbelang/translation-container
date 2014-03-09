package ca.eloas.translets.container.impl;

import ca.eloas.translets.container.Deployment;
import ca.eloas.translets.container.EgressProtocolHandlerDeployment;
import ca.eloas.translets.container.IngressProtocolHandlerDeployment;
import ca.eloas.translets.container.ProtocolStartupEvent;
import ca.eloas.translets.container.events.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author JP
 */
public class ContainerImplTest {

    @Mock
    ConfigurationManager manager;

    @Mock
    EventBus bus;


    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testStart() throws Exception {

        ContainerImpl ci = new ContainerImpl(manager, bus);
        ci.start();

        verify(manager).configure(ci);
        verify(bus).fireEvent(isA(ProtocolStartupEvent.class));
    }

    @Test
    public void testAllDeploymentsHappen() throws Exception {

        EgressProtocolHandlerDeployment eph = mock(EgressProtocolHandlerDeployment.class);
        IngressProtocolHandlerDeployment iph = mock(IngressProtocolHandlerDeployment.class);
        Deployment ctx = mock(Deployment.class);

        ContainerImpl ci = new ContainerImpl(manager, bus);
        ci.addEgressProtocolHandlerDeployment("hello", eph);
        ci.addIngressProtocolHandlerDeployment("goodbye", iph);
        ci.addContext("here", ctx);

        ci.start();

        verify(iph).deploy(ci);
        verify(eph).deploy(ci);
        verify(ctx).deploy(ci);


    }

    @Test
    public void testStop() throws Exception {

    }
}
