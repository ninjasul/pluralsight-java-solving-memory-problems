package pluralsight.java.solving.memory.problems.advanced.memory_leaks.classloaders;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamplePlugin implements Plugin {

    private static final long[] LOTS_OF_MEMORY = new long[8 * 1024 * 1024];

    private ExamplePluginLevel level = new ExamplePluginLevel();

    @Override
    public void initialize() {
        Logger.getLogger("ExamplePlugin").log(level, "Hello World!");
    }

    private class ExamplePluginLevel extends Level {
        protected ExamplePluginLevel() {
            super("Example Plugin Log Level", 1000);
        }
    }
}