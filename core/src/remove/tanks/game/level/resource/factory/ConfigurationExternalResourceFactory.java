package remove.tanks.game.level.resource.factory;

import remove.tanks.game.application.context.configuration.Configuration;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.resource.AbstractExternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ConfigurationExternalResourceFactory
        extends AbstractExternalResourceFactory<Configuration>
{
    @Override
    public String getResourceName() {
        return LevelResource.Configuration.toString();
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[0];
    }

    @Override
    public Configuration prepareResourceObject(Configuration object, ResourceRegistry registry) {
        return object;
    }
}
