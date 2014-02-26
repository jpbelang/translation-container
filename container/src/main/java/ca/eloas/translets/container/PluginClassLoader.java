package ca.eloas.translets.container;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JP
 */
public class PluginClassLoader extends URLClassLoader {

    public PluginClassLoader(ClassLoader classLoader, String pluginDirectory) {
        super(buildClassPath(pluginDirectory), classLoader);
    }

    private static URL[] buildClassPath(String pluginDirectory) {

        try {
            List<URL> urls = new ArrayList<>();
            urls.add(new File(pluginDirectory, "WEB-INF/classes").toURI().toURL());
            for (File file : new File(pluginDirectory, "WEB-INF/lib").listFiles()) {

                urls.add(file.toURI().toURL());
            }

            return urls.toArray(new URL[0]);

        } catch (MalformedURLException e) {

            throw new IllegalArgumentException(e);
        }



    }
}
