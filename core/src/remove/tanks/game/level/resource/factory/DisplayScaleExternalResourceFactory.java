package remove.tanks.game.level.resource.factory;

import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.resource.AbstractExternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class DisplayScaleExternalResourceFactory
        extends AbstractExternalResourceFactory<Scale>
{
    @Override
    public String getResourceName() {
        return LevelResource.DisplayScale.toString();
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[0];
    }

    @Override
    public Scale prepareResourceObject(Scale object, ResourceRegistry registry) {
        return object;
    }
}
