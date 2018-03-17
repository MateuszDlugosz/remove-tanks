package remove.tanks.game.level.event.entity.destroy;

import remove.tanks.game.level.engine.entity.EntityController;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityEventExecutor implements SubEventExecutor<DestroyEntityEvent> {
    @Override
    public void executeEvent(DestroyEntityEvent event, ResourceRegistry registry) {
        try {
            registry.getResource(ResourceType.EntityControllerResource, EntityController.class)
                    .destroyEntity(event.getEntity(), registry);
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<DestroyEntityEvent> getExecutorType() {
        return DestroyEntityEvent.class;
    }
}
