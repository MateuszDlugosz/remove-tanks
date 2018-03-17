package remove.tanks.game.level.event.entity.create;

import remove.tanks.game.level.engine.entity.EntityController;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class CreateEntityEventExecutor implements SubEventExecutor<CreateEntityEvent> {
    @Override
    public void executeEvent(CreateEntityEvent event, ResourceRegistry registry) {
        try {
            event.getCreateEntries().forEach(e -> registry.getResource(ResourceType.EntityControllerResource,
                    EntityController.class).createEntity(
                            e.getPrefabCode(),
                            e.getPosition().sum(PhysicsComponent.MAPPER.get(event.getEntity()).getPosition()),
                            registry
                    )
            );
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<CreateEntityEvent> getExecutorType() {
        return CreateEntityEvent.class;
    }
}
