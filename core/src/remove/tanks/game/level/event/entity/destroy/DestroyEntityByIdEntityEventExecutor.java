package remove.tanks.game.level.event.entity.destroy;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.identity.IdentityComponent;
import remove.tanks.game.level.engine.entity.component.lifecycle.DestroyComponent;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEntityEventExecutor implements SubEventExecutor<DestroyEntityByIdEntityEvent> {
    @Override
    public void executeEvent(DestroyEntityByIdEntityEvent event, ResourceRegistry registry) {
        try {
            registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getEntitiesFor(EntityFamily.IdentityFamily.getFamily())
                    .forEach(e -> {
                        if (IdentityComponent.MAPPER.get(e).getId().equals(event.getId())) {
                            e.add(DestroyComponent.INSTANCE);
                        }
                    });
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<DestroyEntityByIdEntityEvent> getExecutorType() {
        return DestroyEntityByIdEntityEvent.class;
    }
}
