package remove.tanks.game.level.event.create;

import remove.tanks.game.level.engine.entity.EntityController;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class CreateEventExecutor implements SubEventExecutor<CreateEvent> {
    @Override
    public void executeEvent(CreateEvent event, ResourceRegistry registry) {
        try {
            event.getCreateEntries().forEach(e -> registry.getResource(ResourceType.EntityControllerResource,
                    EntityController.class).createEntity(e.getPrefabCode(), e.getPosition(), registry));
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<CreateEvent> getExecutorType() {
        return CreateEvent.class;
    }
}
