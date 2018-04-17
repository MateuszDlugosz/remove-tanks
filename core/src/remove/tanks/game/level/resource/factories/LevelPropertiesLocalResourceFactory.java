package remove.tanks.game.level.resource.factories;

import remove.tanks.game.level.LevelPrefab;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LevelPropertiesLocalResourceFactory extends AbstractLocalResourceFactory<Properties> {
    @Override
    protected Properties createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        Properties properties = new Properties(Arrays.stream(LevelProperty.values()).collect(Collectors.toMap(
                LevelProperty::getName,
                LevelProperty::getDefaultValue
        )));
        registry.getResource(ResourceType.LevelPrefabResource, LevelPrefab.class).getResourceConfigurations()
                .getProperties(ResourceType.LevelPropertiesResource).ifPresent(properties::merge);
        return properties;
    }

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.LevelPropertiesResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[] {
                ResourceType.LevelPrefabResource
        };
    }
}
