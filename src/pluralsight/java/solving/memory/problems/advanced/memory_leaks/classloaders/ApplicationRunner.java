package pluralsight.java.solving.memory.problems.advanced.memory_leaks.classloaders;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ApplicationRunner {
    public static void main(String[] args) throws Exception {
        final String pluginName =
                "pluralsight.java.solving.memory.problems.advanced.memory_leaks.classloaders.ExamplePlugin";

        final URL[] urls = {
                new File("out/production/pluralsight-java-solving-memory-problems").toURI().toURL()
        };
        final URLClassLoader classLoader = new URLClassLoader(urls, null);

        while (true) {
            System.out.println("Press any key to reload the plugins");
            System.in.read();

            // URLClassLoader를 통해 매번 새 Plugin 을 생성한다.
            final Class<?> aClass = classLoader.loadClass(pluginName);
            final Object plugin = aClass.newInstance();
            System.out.printf("plugin class: %s\n", aClass);
            System.out.printf("plugin object: %s\n", plugin);
            aClass.getMethod("initialize").invoke(plugin);
        }
    }
}