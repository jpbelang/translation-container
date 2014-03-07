package ca.eloas.translets.container;

import com.google.inject.Injector;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

/**
 * @author JP
 */
public class IngressProtocolHandlerDeploymentTest {


    @Test
    public void testCreatedComponentGetDeployed() throws Exception {

        Injector i = mock(Injector.class);
        IngressProtocolHandler ep = mock(IngressProtocolHandler.class);
        when((i.getInstance(IngressProtocolHandler.class))).thenReturn(ep);

        Properties p = new Properties();
        IngressProtocolHandlerDeployment iph = new IngressProtocolHandlerDeployment(i, p, IngressProtocolHandlerDeploymentTest.class.getClassLoader());

        IngressProtocolHandler handler = iph.createComponent(i);

        verify(ep).deploy(eq(p), any(Receiver.class));
        assertSame(ep, handler);
    }
}
