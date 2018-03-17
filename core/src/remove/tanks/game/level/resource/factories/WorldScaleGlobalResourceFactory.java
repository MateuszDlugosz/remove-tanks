package remove.tanks.game.level.resource.factories;

import remove.tanks.game.level.resource.AbstractGlobalResourceFactory;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class WorldScaleGlobalResourceFactory extends AbstractGlobalResourceFactory<Scale> {
    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.WorldScaleResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }

    @Override
    protected Scale prepareResourceObject(Scale object) {
        return object;
    }
}
