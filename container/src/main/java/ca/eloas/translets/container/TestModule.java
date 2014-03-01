package ca.eloas.translets.container;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provides;

import java.util.Date;

/**
 * @author JP
 */
public class TestModule extends AbstractModule {

    @Override
    protected void configure() {

        binder().requireExplicitBindings();
    }

    @Provides
    public Date date() {

        return new Date(0);
    }


    public static void main(String[] args) throws Exception  {

        PluginClassLoader cl = new PluginClassLoader(TestModule.class.getClassLoader(), "/Users/jpbelang/Git/eloas/translets/protocols/smtp/target/smtp-1.0-SNAPSHOT");
        PluginClassLoader cl2 = new PluginClassLoader(TestModule.class.getClassLoader(), "/Users/jpbelang/Git/eloas/translets/protocols/smtp/target/smtp-1.0-SNAPSHOT");

        Injector i = Guice.createInjector(new TestModule());

        Module m = (Module) cl.loadClass("ca.eloas.translets.protocols.smtp.Module").newInstance();
        Injector child = i.createChildInjector(m);
        IngressProtocolHandler o =child.getInstance(IngressProtocolHandler.class);

        Module m2 = (Module) cl2.loadClass("ca.eloas.translets.protocols.smtp.Module").newInstance();
        Injector child2 = i.createChildInjector(m2);
        IngressProtocolHandler o2 =child2.getInstance(IngressProtocolHandler.class);

        return;

    }
}
