package ca.eloas.translets.container;

import com.google.inject.Injector;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author JP
 */
public class EgressProtocolHandlerDeploymentTest {


    @Test
    public void testCreatedComponentGetDeployed() throws Exception {

        Injector i = mock(Injector.class);
        EgressProtocolHandler ep = mock(EgressProtocolHandler.class);
        when((i.getInstance(EgressProtocolHandler.class))).thenReturn(ep);

        Properties p = new Properties();
        EgressProtocolHandlerDeploymentImpl eph = new EgressProtocolHandlerDeploymentImpl(i, p, EgressProtocolHandlerDeploymentTest.class.getClassLoader());

        EgressProtocolHandler handler = eph.createAndDeployComponent(null, i); //doesn't use container

        verify(ep).deploy(p);
        assertSame(ep, handler);
    }
}
