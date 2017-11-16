package remove.tanks.game.application.context.configuration;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class Configuration {
    private final Map<String, String> options;
    private final List<String> componentSupplierPackages;

    public Configuration(
            Map<String, String> options,
            List<String> componentSupplierPackages
    ) {
        this.options = options;
        this.componentSupplierPackages = componentSupplierPackages;
    }

    public boolean hasOption(String key) {
        return options.containsKey(key);
    }

    public String getOption(String key) {
        if (!hasOption(key)) {
            throw new OptionNotFoundException(key);
        }
        return options.get(key);
    }

    public List<String> getComponentSupplierPackages() {
        return ImmutableList.copyOf(componentSupplierPackages);
    }
}
