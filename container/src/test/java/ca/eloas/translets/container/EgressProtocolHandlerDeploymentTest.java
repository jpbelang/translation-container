package ca.eloas.translets.container;

import com.google.inject.Injector;
import org.junit.Test;
import org.mockito.Mockito;

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
        EgressProtocolHandlerDeployment eph = new EgressProtocolHandlerDeployment(i, p, EgressProtocolHandlerDeploymentTest.class.getClassLoader());

        EgressProtocolHandler handler = eph.createComponent(i);

        verify(ep).deploy(p);
        assertSame(ep, handler);
    }
}
