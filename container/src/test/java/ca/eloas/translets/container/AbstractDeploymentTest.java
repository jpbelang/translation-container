package ca.eloas.translets.container;

import com.google.inject.Injector;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

/**
 * @author JP
 */
public class AbstractDeploymentTest {

    @Test
    public void deployCreatesModuleAndCreatesComponent() throws Exception {


        EgressProtocolHandlerDeploymentImpl epd = mock(EgressProtocolHandlerDeploymentImpl.class, withSettings().verboseLogging());
        Injector injector = mock(Injector.class, withSettings().verboseLogging());
        when(injector.createChildInjector(isA(FakeModule.class))).thenReturn(injector);

        Properties p = new Properties();
        p.setProperty("moduleName", FakeModule.class.getName());

        AbstractDeployment<EgressProtocolHandlerDeploymentImpl> ad = new AbstractDeployment<EgressProtocolHandlerDeploymentImpl>(injector, p, AbstractDeploymentTest.class.getClassLoader()) {
            @Override
            protected EgressProtocolHandlerDeploymentImpl createAndDeployComponent(Container container, Injector childInjector) {

                assertSame(childInjector, injector);
                return epd;
            }
        };

        ad.deploy(null);

    }
}
