package ca.eloas.translets.container.impl;

import ca.eloas.translets.container.Container;
import ca.eloas.translets.container.ContainerException;
import ca.eloas.translets.container.DeploymentFactory;
import com.google.inject.Inject;

import java.io.File;
import java.util.Properties;

/**
 * @author JP
 */
public class DirectoryScanningConfigurationManager implements ConfigurationManager {


    private final DeploymentFactory factory;
    private String directory;

    @Inject
    public DirectoryScanningConfigurationManager(DeploymentFactory factory, String directory) {
        this.directory = directory;
        this.factory = factory;
    }

    @Override
    public void configure(Container c) {

        File f = new File(directory);
        checkDirectory(f);

        for (File file : f.listFiles()) {

            if ( file.isDirectory() ) {

                continue;
            }

            if (file.getName().endsWith(".ingress.properties")) {

                try {

                    Properties p = new Properties();
                    p.load(file.toURI().toURL().openStream());
                    c.addIngressProtocolHandlerDeployment(factory.createIngressDeployment(p));
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

            if (file.getName().endsWith(".egress.properties")) {

                try {

                    Properties p = new Properties();
                    p.load(file.toURI().toURL().openStream());
                    c.addEgressProtocolHandlerDeployment(factory.createEgressDeployment(p));
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

        }
    }

    private void checkDirectory(File f) {
        if (! f.exists() ) {

            throw new ContainerException("no such directory: " + directory);
        }

        if ( ! f.isDirectory() ) {

            throw new ContainerException("is not a directory: " + directory);
        }
    }
}
