package remove.tanks.game.level.resource.factories;

import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.scale.MultiplyingMutableScale;
import remove.tanks.game.utility.scale.MutableScale;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public final class TimeScaleLocalResourceFactory extends AbstractLocalResourceFactory<MutableScale> {
    @Override
    protected MutableScale createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        return new MultiplyingMutableScale(1f);
    }

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.TimeScaleResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }
}
