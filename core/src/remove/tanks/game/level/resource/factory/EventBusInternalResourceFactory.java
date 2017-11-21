package remove.tanks.game.level.resource.factory;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.resource.AbstractInternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class EventBusInternalResourceFactory
        extends AbstractInternalResourceFactory<EventBus>
{
    @Override
    protected String getResourceName() {
        return LevelResource.EventBus.toString();
    }

    @Override
    protected EventBus getResourceObject(ResourceRegistry registry) {
        return new EventBus();
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[0];
    }
}
