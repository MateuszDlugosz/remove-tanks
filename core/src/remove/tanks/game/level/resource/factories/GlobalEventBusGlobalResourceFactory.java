package remove.tanks.game.level.resource.factories;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.resource.AbstractGlobalResourceFactory;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class GlobalEventBusGlobalResourceFactory extends AbstractGlobalResourceFactory<EventBus> {
    @Override
    protected EventBus prepareResourceObject(EventBus object) {
        return object;
    }

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.GlobalEventBusResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }
}
