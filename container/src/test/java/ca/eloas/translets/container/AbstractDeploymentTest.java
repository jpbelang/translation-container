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


        EgressProtocolHandlerDeployment epd = mock(EgressProtocolHandlerDeployment.class, withSettings().verboseLogging());
        Injector injector = mock(Injector.class, withSettings().verboseLogging());
        when(injector.createChildInjector(isA(FakeModule.class))).thenReturn(injector);

        Properties p = new Properties();
        p.setProperty("moduleName", FakeModule.class.getName());

        AbstractDeployment<EgressProtocolHandlerDeployment> ad = new AbstractDeployment<EgressProtocolHandlerDeployment>(injector, p, AbstractDeploymentTest.class.getClassLoader()) {
            @Override
            protected EgressProtocolHandlerDeployment createComponent(Injector childInjector) {

                assertSame(childInjector, injector);
                return epd;
            }
        };

        ad.deploy(null);

    }
}
