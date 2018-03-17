package remove.tanks.game.level.resource.configuration;

import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;

import java.util.Map;
import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class ResourceConfigurations {
    private final Map<ResourceType, Properties> properties;

    public ResourceConfigurations(Map<ResourceType, Properties> properties) {
        this.properties = properties;
    }

    public Optional<Properties> getProperties(ResourceType resourceType) {
        return Optional.ofNullable(properties.get(resourceType));
    }
}
