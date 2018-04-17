package remove.tanks.game.level.resource.factories;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public final class EventBusLocalResourceFactory extends AbstractLocalResourceFactory<EventBus> {
    private static final String EVENT_BUS_IDENTIFIER = "LevelEventBus";

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.EventBusResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }

    @Override
    protected EventBus createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        return new EventBus(EVENT_BUS_IDENTIFIER);
    }
}
