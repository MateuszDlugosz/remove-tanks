package remove.tanks.game.application.context.configuration;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class Configuration {
    private final Map<String, String> options;

    public Configuration(Map<String, String> options) {
        this.options = options;
    }

    public boolean hasOption(String name) {
        return options.containsKey(name);
    }

    public String getOption(String name) {
        if (!hasOption(name)) {
            throw new OptionNotFoundException(name);
        }
        return options.get(name);
    }
}
