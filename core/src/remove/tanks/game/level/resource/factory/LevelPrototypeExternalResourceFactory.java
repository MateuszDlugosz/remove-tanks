package remove.tanks.game.level.resource.factory;

import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.LevelPrototype;
import remove.tanks.game.level.resource.AbstractExternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class LevelPrototypeExternalResourceFactory
        extends AbstractExternalResourceFactory<LevelPrototype>
{
    @Override
    public String getResourceName() {
        return LevelResource.LevelPrototype.toString();
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[0];
    }

    @Override
    public LevelPrototype prepareResourceObject(LevelPrototype object, ResourceRegistry registry) {
        return object;
    }
}
