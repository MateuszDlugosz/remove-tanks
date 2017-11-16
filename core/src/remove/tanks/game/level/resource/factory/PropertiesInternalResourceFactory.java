package remove.tanks.game.level.resource.factory;

import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.LevelPropertiesInitializer;
import remove.tanks.game.level.LevelPrototype;
import remove.tanks.game.level.resource.AbstractInternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.properties.PropertyExistsValidator;

/**
 * @author Mateusz Długosz
 */
public final class PropertiesInternalResourceFactory
        extends AbstractInternalResourceFactory<Properties>
{
    private final PropertyExistsValidator propertyExistsValidator;
    private final LevelPropertiesInitializer levelPropertiesInitializer;

    public PropertiesInternalResourceFactory(
            PropertyExistsValidator propertyExistsValidator,
            LevelPropertiesInitializer levelPropertiesInitializer
    ) {
        this.propertyExistsValidator = propertyExistsValidator;
        this.levelPropertiesInitializer = levelPropertiesInitializer;
    }

    @Override
    protected String getResourceName() {
        return LevelResource.Properties.toString();
    }

    @Override
    protected Properties getResourceObject(ResourceRegistry registry) {
        Properties properties = registry.getResource(
                LevelResource.LevelPrototype.toString(), LevelPrototype.class).getProperties();
        propertyExistsValidator.validateProperties(properties);
        properties = levelPropertiesInitializer.initializeLevelProperties(properties);
        return properties;
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[] {
                LevelResource.LevelPrototype.toString()
        };
    }
}
